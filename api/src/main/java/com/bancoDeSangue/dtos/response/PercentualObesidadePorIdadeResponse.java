package com.BancoDeSangue.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PercentualObesidadePorIdadeResponse {
	private String faixaEtaria;
	private Double media= (double) 0;
}
