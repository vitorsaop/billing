package br.com.itsolution.fintech.billing.service;

import br.com.itsolution.fintech.billing.model.BillingRecord;
import br.com.itsolution.fintech.billing.repository.BillingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingService {

    @Autowired
    private BillingRecordRepository repository;

    @Transactional
    public void registrar(String cnpj, String appId, String endpoint) {
        BillingRecord record = new BillingRecord(cnpj, appId, endpoint);
        repository.save(record);
    }

}
