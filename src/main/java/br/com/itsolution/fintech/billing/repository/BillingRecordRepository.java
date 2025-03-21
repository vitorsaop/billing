package br.com.itsolution.fintech.billing.repository;

import br.com.itsolution.fintech.billing.model.BillingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {
}
