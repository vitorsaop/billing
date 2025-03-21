package br.com.itsolution.fintech.billing.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String BILLING_QUEUE = "billing-queue";

    @Bean
    public Queue billingQueue() {
        return new Queue(BILLING_QUEUE, true);
    }
}