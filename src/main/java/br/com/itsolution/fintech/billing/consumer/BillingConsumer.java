package br.com.itsolution.fintech.billing.consumer;

import br.com.itsolution.fintech.billing.config.RabbitMQConfig;
import br.com.itsolution.fintech.billing.dto.BillingMessageDto;
import br.com.itsolution.fintech.billing.service.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillingConsumer {

    private static final Logger logger = LoggerFactory.getLogger(BillingConsumer.class);

    @Autowired
    private BillingService billingService;

    @RabbitListener(queues = RabbitMQConfig.BILLING_QUEUE)
    public void process(BillingMessageDto payload) {
        try {
            billingService.registrar(payload.getCnpj(), payload.getAppId(), payload.getEndpoint());
        } catch (AmqpException amqpEx) {
            logger.error("Erro de comunicação com RabbitMQ ao processar a fila '{}': {}", RabbitMQConfig.BILLING_QUEUE, amqpEx.getMessage(), amqpEx);
        } catch (RuntimeException ex) {
            logger.error("Erro inesperado ao processar mensagem de billing: {}@{} {}", payload.getCnpj(), payload.getAppId(), payload.getEndpoint(), ex);
        }
    }

}