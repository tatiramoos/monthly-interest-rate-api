package com.tati.ibm.bcb.service;

import com.tati.ibm.bcb.client.MonthlyInterestRateClient;
import com.tati.ibm.bcb.model.MonthlyInterestRate;
import com.tati.ibm.bcb.repository.MonthlyInterestRateRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class MonthlyInterestRateService implements Serializable {

    private final MonthlyInterestRateClient client;
    private final MonthlyInterestRateRepository repository;

    public MonthlyInterestRateService(MonthlyInterestRateClient client, MonthlyInterestRateRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    public List<MonthlyInterestRate> getAll() {
        List<MonthlyInterestRate> list = client.getAllTaxas().getValue();
        return repository.saveAll(list);
    }
}
