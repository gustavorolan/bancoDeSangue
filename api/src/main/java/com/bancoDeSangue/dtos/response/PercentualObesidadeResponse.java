package com.bancoDeSangue.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PercentualObesidadeResponse {
	private String sexo;
	private Float percentual;
}
