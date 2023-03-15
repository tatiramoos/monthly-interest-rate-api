package com.tati.ibm.bcb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tati.ibm.bcb.model.MonthlyInterestRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyInterestRateDTO {

    @JsonProperty("@odata.context")
    private String context;

    @JsonProperty("value")
    private List<MonthlyInterestRate> value;
}
