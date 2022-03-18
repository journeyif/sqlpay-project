package com.sqlpay.project.rabbitmq.confirm;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试confirm 机制，专门创建了一个队列
 */
@Configuration
public class ConfirmRabbitConfig {
    @Bean
    public Queue confirmQueue() {
        return new Queue("rabbit_confirm_queue");
    }

    @Bean
    public FanoutExchange confirmExchange() {
        return new FanoutExchange("confirm_fanout_exchange");
    }

    @Bean
    public Binding confirmFanoutExchangeBing() {
        return BindingBuilder.bind(confirmQueue()).to(confirmExchange());
    }
}
