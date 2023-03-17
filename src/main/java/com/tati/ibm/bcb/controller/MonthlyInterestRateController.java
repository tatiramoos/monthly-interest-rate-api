package com.tati.ibm.bcb.controller;

import com.tati.ibm.bcb.mapper.MonthlyInterestRateMapper;
import com.tati.ibm.bcb.model.MonthlyInterestRate;
import com.tati.ibm.bcb.request.MonthlyInterestRateRequest;
import com.tati.ibm.bcb.response.MonthlyInterestRateResponse;
import com.tati.ibm.bcb.service.MonthlyInterestRateService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/MonthlyInterestRate")
public class MonthlyInterestRateController {

    private final MonthlyInterestRateService service;
    private final MonthlyInterestRateMapper mapper;
    private final Logger log = LoggerFactory.getLogger(MonthlyInterestRateController.class);

    public MonthlyInterestRateController(ModelMapper modelMapper, MonthlyInterestRateService service, MonthlyInterestRateMapper mapper) {
        this.mapper = mapper;
        this.service = service;
    }

   @GetMapping
    public ResponseEntity<List<MonthlyInterestRate>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all-rates")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MonthlyInterestRateResponse>> findAll(){
        List<MonthlyInterestRate> entity = service.findAll();
        List<MonthlyInterestRateResponse> response = mapper.toMonthlyInterestRateResponseList(entity);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthlyInterestRateResponse> findById(@PathVariable Long id) {
        Optional<MonthlyInterestRate> optional= service.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toMonthlyInterestRateResponse(optional.get()));
    }

    @PostMapping("/save")
    public ResponseEntity<MonthlyInterestRateResponse> save(@Valid @RequestBody MonthlyInterestRateRequest request) {
        MonthlyInterestRate entity = mapper.toMonthlyInterestRate(request);
        MonthlyInterestRate entitySaved = service.save(entity);
        MonthlyInterestRateResponse response = mapper.toMonthlyInterestRateResponse(entitySaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<MonthlyInterestRateResponse> update (@PathVariable Long id, @RequestBody MonthlyInterestRateRequest request) {
        MonthlyInterestRate entity = mapper.toMonthlyInterestRate(request);
        MonthlyInterestRate entitySaved = service.save(entity);
        MonthlyInterestRateResponse response = mapper.toMonthlyInterestRateResponse(entitySaved);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
