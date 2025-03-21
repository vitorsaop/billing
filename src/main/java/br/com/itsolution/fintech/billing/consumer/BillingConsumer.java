package br.com.itsolution.fintech.billing.consumer;

import br.com.itsolution.fintech.billing.config.RabbitMQConfig;
import br.com.itsolution.fintech.billing.service.BillingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BillingConsumer {

    @Autowired
    private BillingService billingService;

    @RabbitListener(queues = RabbitMQConfig.BILLING_QUEUE)
    public void process(Map<String, String> payload) {
        String cnpj = payload.get("cnpj");
        String appId = payload.get("appId");
        String endpoint = payload.get("endpoint");
        billingService.registrar(cnpj, appId, endpoint);
    }
}