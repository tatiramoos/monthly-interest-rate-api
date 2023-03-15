package com.tati.ibm.bcb.controller;

import com.tati.ibm.bcb.model.MonthlyInterestRate;
import com.tati.ibm.bcb.response.MonthlyInterestRateResponse;
import com.tati.ibm.bcb.service.MonthlyInterestRateService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MonthlyInterestRate")
public class MonthlyInterestRateController {

    private ModelMapper modelMapper;

    private final MonthlyInterestRateService service;

    public MonthlyInterestRateController(MonthlyInterestRateService service) {
        this.service = service;
    }
   @GetMapping
    public ResponseEntity<List<MonthlyInterestRate>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    private MonthlyInterestRateResponse toMonthlyInterestRate (MonthlyInterestRate monthlyInterestRate) {
        return modelMapper.map(monthlyInterestRate, MonthlyInterestRateResponse.class);
    }
}
