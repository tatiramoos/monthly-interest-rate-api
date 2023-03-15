package com.tati.ibm.bcb.client;

import com.tati.ibm.bcb.dto.MonthlyInterestRateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "MonthlyInterestRate", url = "https://olinda.bcb.gov.br/olinda/servico/taxaJuros/versao/v2/odata/TaxasJurosMensalPorMes?$top=20&$format=json")
public interface MonthlyInterestRateClient {
    @GetMapping
    MonthlyInterestRateDTO getAllTaxas();
}