package com.tati.ibm.bcb.mapper;

import com.tati.ibm.bcb.controller.MonthlyInterestRateController;
import com.tati.ibm.bcb.model.MonthlyInterestRate;
import com.tati.ibm.bcb.request.MonthlyInterestRateRequest;
import com.tati.ibm.bcb.response.MonthlyInterestRateResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MonthlyInterestRateMapper {

    private final ModelMapper modalMapper;

    public MonthlyInterestRate toMonthlyInterestRate(MonthlyInterestRateRequest request) {
        return modalMapper.map(request, MonthlyInterestRate.class);
    }

    public MonthlyInterestRateResponse toMonthlyInterestRateResponse(MonthlyInterestRate monthlyInterestRate) {
        MonthlyInterestRateResponse response = modalMapper.map(monthlyInterestRate, MonthlyInterestRateResponse.class);
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MonthlyInterestRateController.class).findById(response.getId())).withSelfRel());
        response.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MonthlyInterestRateController.class).findAll()).withSelfRel());
        return response;
    }

    public List<MonthlyInterestRateResponse> toMonthlyInterestRateResponseList(List<MonthlyInterestRate> monthlyInterestRateList) {
        return monthlyInterestRateList.stream()
                .map(this::toMonthlyInterestRateResponse)
                .collect(Collectors.toList());
    }
}
