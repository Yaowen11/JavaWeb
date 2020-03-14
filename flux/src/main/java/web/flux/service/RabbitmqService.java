package web.flux.service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author z
 */
@Configuration
public class RabbitmqService {

    public static final String LOG_EXCHANGE = "log";

    public static final String ACCESS_QUEUE = "access";

    public static final String ACCESS_ROUTE_KEY = "*.access";

    public static final String ERROR_ROUTE_KEY = "*.error";

    public static final String REQUEST_ERROR_QUEUE = "request.error";

    public static final String SERVER_ERROR_QUEUE = "server.error";

    @Bean
    public Queue accessQueue() {
        return new Queue(ACCESS_QUEUE);
    }

    @Bean
    public Queue requestErrorQueue() {
        return new Queue(REQUEST_ERROR_QUEUE);
    }

    @Bean
    public Queue serverErrorQueue() {
        return new Queue(SERVER_ERROR_QUEUE);
    }

    @Bean
    public TopicExchange logExchange() {
        return new TopicExchange(LOG_EXCHANGE);
    }

    @Bean
    public Binding accessBindingLog() {
        return BindingBuilder.bind(accessQueue()).to(logExchange()).with(ACCESS_ROUTE_KEY);
    }

    @Bean
    public Binding requestErrorBindingLog() {
        return BindingBuilder.bind(requestErrorQueue()).to(logExchange()).with(ERROR_ROUTE_KEY);
    }

    @Bean
    public Binding serverErrorBindingLog() {
        return BindingBuilder.bind(serverErrorQueue()).to(logExchange()).with(ERROR_ROUTE_KEY);
    }

}
