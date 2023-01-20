package com.bancoDeSangue.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuantidadeDeDoadoresPossiveisResponse {
	private Long numeroDoadores;
	private String tipoSanguineo;
}
