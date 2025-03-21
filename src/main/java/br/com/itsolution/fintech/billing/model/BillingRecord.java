package br.com.itsolution.fintech.billing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class BillingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Identificação fiscal do cliente (obrigatório para faturamento)
    private String cnpj;

    // Identificador da aplicação/sistema que gerou a requisição
    private String appId;

    // Identificador único composto (ex: 12345678000195@pix-app)
    private String identificador;

    // Endpoint da API acessado
    private String endpoint;

    // Timestamp de criação da cobrança
    private LocalDateTime createdAt = LocalDateTime.now();

    public BillingRecord() {}

    public BillingRecord(String cnpj, String appId, String endpoint) {
        this.cnpj = cnpj;
        this.appId = appId;
        this.identificador = cnpj + "@" + appId;
        this.endpoint = endpoint;
    }

    public Long getId() { return id; }
    public String getCnpj() { return cnpj; }
    public String getAppId() { return appId; }
    public String getIdentificador() { return identificador; }
    public String getEndpoint() { return endpoint; }
    public LocalDateTime getCreatedAt() { return createdAt; }

}
