package com.tati.ibm.bcb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taxa_juros_mensal")
public class MonthlyInterestRate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "mes")
    @JsonProperty("Mes")
    private String mes;

    @Column(name = "modalidade")
    @JsonProperty("Modalidade")
    private String modalidade;

    @Column(name = "posicao")
    @JsonProperty("Posicao")
    private Integer posicao;

    @Column(name = "instituicao_financeira")
    @JsonProperty("InstituicaoFinanceira")
    private String instituicaoFinanceira;

    @Column(name = "taxa_juros_ao_mes")
    @JsonProperty("TaxaJurosAoMes")
    private Double taxaJurosAoMes;

    @Column(name = "taxa_juros_ao_ano")
    @JsonProperty("TaxaJurosAoAno")
    private Double taxaJurosAoAno;

    @Column(name = "cnpj8")
    @JsonProperty("cnpj8")
    private String cnpj8;

    @Column(name = "ano_mes")
    @JsonProperty("anoMes")
    private String anoMes;
}
