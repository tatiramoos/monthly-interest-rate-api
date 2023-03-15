package com.tati.ibm.bcb.repository;

import com.tati.ibm.bcb.model.MonthlyInterestRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyInterestRateRepository extends JpaRepository<MonthlyInterestRate, Long> {
}
