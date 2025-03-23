package br.com.itsolution.fintech.billing.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AppInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", Map.of(
                "name", "billing",
                "description", "Serviço de bilhetagem para produtos de Fintech",
                "version", "1.0.0"
        ));
    }

}
