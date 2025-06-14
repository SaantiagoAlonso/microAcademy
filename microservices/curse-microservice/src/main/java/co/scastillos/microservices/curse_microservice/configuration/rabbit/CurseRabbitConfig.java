package co.scastillos.microservices.curse_microservice.configuration.rabbit;

import co.scastillos.microservices.common_rabbitConfig.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurseRabbitConfig {


    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(RabbitConstants.CURSE_EXCHANGE);
    }

    @Bean
    public Queue curseQueue(){
        return new Queue(RabbitConstants.CURSE_QUEUE);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(curseQueue()).to(topicExchange())
                .with(RabbitConstants.CURSE_ROUTING_KEY);
    }



}
