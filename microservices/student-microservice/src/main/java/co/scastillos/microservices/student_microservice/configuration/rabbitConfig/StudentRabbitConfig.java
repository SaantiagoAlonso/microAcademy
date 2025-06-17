package co.scastillos.microservices.student_microservice.configuration.rabbitConfig;

import co.scastillos.microservices.common_rabbitConfig.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentRabbitConfig {

    @Bean
    public DirectExchange studentExchange(){
        return new DirectExchange(RabbitConstants.STUDENT_EXCHANGE);
    }

    @Bean
    public Queue studentQueue(){
        return new Queue(RabbitConstants.STUDENT_QUEUE);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(studentQueue())
                .to(studentExchange())
                .with(RabbitConstants.STUDENT_ROUTING_KEY);
    }

}
