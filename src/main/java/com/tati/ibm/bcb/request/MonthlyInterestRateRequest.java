package com.tati.ibm.bcb.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyInterestRateRequest extends RepresentationModel<MonthlyInterestRateRequest> {

    @JsonProperty("Mes")
    @NotBlank(message = "O campo 'mes' não pode ser vazio")
    private String mes;

    @JsonProperty("Modalidade")
    @NotBlank(message = "O campo 'modalidade' não pode ser vazio")
    private String modalidade;

    @JsonProperty("Posicao")
    @NotNull(message = "O campo 'posicao' não pode ser nulo")
    private Integer posicao;

    @JsonProperty("InstituicaoFinanceira")
    @NotBlank(message = "O campo 'instituicaoFinanceira' não pode ser vazio")
    private String instituicaoFinanceira;

    @JsonProperty("TaxaJurosAoMes")
    @NotNull(message = "O campo 'taxaJurosAoMes' não pode ser nulo")
    private Double taxaJurosAoMes;

    @JsonProperty("TaxaJurosAoAno")
    @NotNull(message = "O campo 'taxaJurosAoAno' não pode ser vazio")
    private Double taxaJurosAoAno;

    @JsonProperty("cnpj8")
    @NotBlank(message = "O campo 'cnpj8' não pode ser vazio")
    @Length(min = 1, max = 8, message = "O campo 'cnpj8' deve ter entre 1 e 8 caracteres.")
    private String cnpj8;

    @JsonProperty("anoMes")
    @NotBlank(message = "O campo 'anoMes' não pode ser vazio")
    private String anoMes;
}
