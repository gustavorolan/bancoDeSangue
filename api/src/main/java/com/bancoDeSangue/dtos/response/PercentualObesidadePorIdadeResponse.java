package com.BancoDeSangue.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PercentualObesidadePorIdadeResponse {
	private String faixaEtaria;
	private Double media= (double) 0;
}
