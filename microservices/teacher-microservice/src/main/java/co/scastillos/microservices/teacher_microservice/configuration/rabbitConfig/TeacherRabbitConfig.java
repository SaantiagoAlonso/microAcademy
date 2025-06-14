package co.scastillos.microservices.teacher_microservice.configuration.rabbitConfig;

import co.scastillos.microservices.common_rabbitConfig.RabbitConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherRabbitConfig  {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(RabbitConstants.TEACHER_EXCHANGE);
    }

    @Bean
    public Queue teacherQueue(){
        return new Queue(RabbitConstants.TEACHER_QUEUE);
    }

    @Bean
    public Binding teacherBinding(){
        return BindingBuilder.bind(teacherQueue()).to(topicExchange())
                .with(RabbitConstants.TEACHER_ROUTING_KEY);
    }

}
