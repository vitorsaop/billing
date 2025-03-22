package br.com.itsolution.fintech.billing.dto;

public class BillingMessageDto {
    private String cnpj;
    private String appId;
    private String endpoint;

    public BillingMessageDto() {}

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getAppId() { return appId; }
    public void setAppId(String appId) { this.appId = appId; }

    public String getEndpoint() { return endpoint; }
    public void setEndpoint(String endpoint) { this.endpoint = endpoint; }
}
