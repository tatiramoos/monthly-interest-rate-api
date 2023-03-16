package com.tati.ibm.bcb.service;

import com.tati.ibm.bcb.client.MonthlyInterestRateClient;
import com.tati.ibm.bcb.model.MonthlyInterestRate;
import com.tati.ibm.bcb.repository.MonthlyInterestRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MonthlyInterestRateService implements Serializable {

    private final MonthlyInterestRateClient client;
    private final MonthlyInterestRateRepository repository;

    public List<MonthlyInterestRate> getAll() {
        List<MonthlyInterestRate> list = client.getAllTaxas().getValue();
        return repository.saveAll(list);
    }

    public List<MonthlyInterestRate> findAll() {
        return repository.findAll();
    }

    public Optional<MonthlyInterestRate> findById(Long id) {
        return repository.findById(id);
    }

    public MonthlyInterestRate save(MonthlyInterestRate entity) {
        return repository.save(entity);
    }

    public MonthlyInterestRate update(Long id, MonthlyInterestRate taxaJurosMensal) {
        MonthlyInterestRate obj = validarTaxaExistente(id);
        BeanUtils.copyProperties(taxaJurosMensal, obj, "id");
        return repository.save(obj);
    }

    private MonthlyInterestRate validarTaxaExistente(Long id) {
        Optional<MonthlyInterestRate> obj = findById(id);
        if (obj.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return obj.get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
