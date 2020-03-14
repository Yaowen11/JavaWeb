package web.flux.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.flux.entity.AccessLog;
import web.flux.repository.AccessLogRepository;

/**
 * @author z
 */
@Slf4j
@Service
public class RabbitReceiverService {

    private AccessLogRepository accessLogRepository;

    @Autowired
    RabbitReceiverService(AccessLogRepository accessLogRepository) {
        this.accessLogRepository = accessLogRepository;
    }

    @RabbitListener(queues = RabbitmqService.ACCESS_QUEUE)
    public void receiveAccessLog(AccessLog accessLog) {
        accessLogRepository.save(accessLog);
        dump(accessLog);
    }

    @RabbitListener(queues = RabbitmqService.REQUEST_ERROR_QUEUE)
    public void receiveRequestLog(AccessLog requestErrorLog) {
        dump(requestErrorLog);
    }

    @RabbitListener(queues = RabbitmqService.SERVER_ERROR_QUEUE)
    public void receiveErrorLog(AccessLog serverErrorLog) {
        dump(serverErrorLog);
    }

    private void dump(AccessLog logInfo) {
        log.debug(logInfo.getUri() + logInfo.getRecordAt() + logInfo.getId());
    }

}
