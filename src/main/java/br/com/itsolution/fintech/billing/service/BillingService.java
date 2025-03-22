package br.com.itsolution.fintech.billing.service;

import br.com.itsolution.fintech.billing.model.BillingRecord;
import br.com.itsolution.fintech.billing.repository.BillingRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BillingService {

    private static final Logger logger = LoggerFactory.getLogger(BillingService.class);

    @Autowired
    private BillingRecordRepository repository;

    @Transactional
    public void registrar(String cnpj, String appId, String endpoint) {
        BillingRecord record = new BillingRecord(cnpj, appId, endpoint);
        try {
            repository.save(record);
        } catch (DataAccessException dae) {
            logger.warn("Falha ao persistir billing: {}@{}, endpoint={}", cnpj, appId, endpoint, dae);
        }
    }

}
