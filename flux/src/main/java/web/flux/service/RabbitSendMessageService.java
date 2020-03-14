package web.flux.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.flux.entity.AccessLog;

/**
 * @author z
 */
@Service
public class RabbitSendMessageService {

    private AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitSendMessageService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendAccessLog(AccessLog log) {
        this.amqpTemplate.convertAndSend(RabbitmqService.LOG_EXCHANGE, RabbitmqService.ACCESS_ROUTE_KEY,log);
    }

    public void sendErrorLog(AccessLog log) {
        this.amqpTemplate.convertAndSend(RabbitmqService.LOG_EXCHANGE, RabbitmqService.ERROR_ROUTE_KEY, log);
    }

}
