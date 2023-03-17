package com.tati.ibm.bcb.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyInterestRateResponse extends RepresentationModel<MonthlyInterestRateResponse> {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("Mes")
    private String mes;

    @JsonProperty("Modalidade")
    private String modalidade;

    @JsonProperty("Posicao")
    private Integer posicao;

    @JsonProperty("InstituicaoFinanceira")
    private String instituicaoFinanceira;

    @JsonProperty("TaxaJurosAoMes")
    private Double taxaJurosAoMes;

    @JsonProperty("TaxaJurosAoAno")
    private Double taxaJurosAoAno;

    @JsonProperty("cnpj8")
    private String cnpj8;

    @JsonProperty("anoMes")
    private String anoMes;
}
