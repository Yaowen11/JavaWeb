package web.flux.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import web.flux.entity.AccessLog;
import web.flux.entity.JsonData;
import web.flux.repository.AccessLogRepository;
import web.flux.service.RabbitSendMessageService;
import web.flux.utls.Ip2Long;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author z
 */
@Aspect
@Component
@Slf4j
public class LogAspectJ {

    private RabbitSendMessageService rabbitSendMessageService;

    @Autowired
    public LogAspectJ(RabbitSendMessageService rabbitSendMessageService) {
        this.rabbitSendMessageService = rabbitSendMessageService;
    }

    @Pointcut("execution(* web.flux.api.UserController.store(..))")
    public void controllerLog() {

    }

    @Around("controllerLog()")
    public Object accessLog(ProceedingJoinPoint pjp) {
        Object result;
        AccessLog webLog = new AccessLog();
        RequestAttributes attribute = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(attribute)).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(attribute)).getResponse();
        try {
            webLog.setUri(request.getRequestURI());
            webLog.setClientIp(Ip2Long.ipv42Int(request.getRemoteAddr()));
            webLog.setType(AccessLogRepository.TYPE.API.ordinal());
            webLog.setMethod(request.getMethod());
            long start = System.currentTimeMillis();
            result = pjp.proceed();
            webLog.setHttpCode(Objects.requireNonNull(response).getStatus());
            webLog.setUseTime(System.currentTimeMillis() - start);
            webLog.setErrors(HttpStatus.OK.name());
            webLog.setRecordAt(Timestamp.valueOf(LocalDateTime.now()));
            rabbitSendMessageService.sendAccessLog(webLog);
            log.debug("date: " + webLog.getRecordAt() + " uri: " + webLog.getUri() +  " using: " + webLog.getUseTime());
            return result;
        } catch (Throwable e) {
            webLog.setErrors(null);
            webLog.setErrors(e.getClass().getName());
            webLog.setRecordAt(Timestamp.valueOf(LocalDateTime.now()));
            rabbitSendMessageService.sendAccessLog(webLog);
            log.debug("date: " + webLog.getRecordAt() + " uri: " + webLog.getUri() +  " using: " + webLog.getUseTime());
            return null;
        }
    }

}
