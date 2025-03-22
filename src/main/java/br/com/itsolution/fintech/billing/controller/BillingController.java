package br.com.itsolution.fintech.billing.controller;

import br.com.itsolution.fintech.billing.model.BillingRecord;
import br.com.itsolution.fintech.billing.repository.BillingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/billing")
public class BillingController {

    @Autowired
    private BillingRecordRepository repository;

    @GetMapping
    public ResponseEntity<List<BillingRecord>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }
}
