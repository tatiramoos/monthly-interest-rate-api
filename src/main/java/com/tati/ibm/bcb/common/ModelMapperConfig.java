package com.tati.ibm.bcb.common;

import com.tati.ibm.bcb.model.MonthlyInterestRate;
import com.tati.ibm.bcb.response.MonthlyInterestRateResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(MonthlyInterestRate.class, MonthlyInterestRateResponse.class)
                .<Long>addMapping(MonthlyInterestRate::getId, MonthlyInterestRateResponse::setId);

        return modelMapper;
    }
}
