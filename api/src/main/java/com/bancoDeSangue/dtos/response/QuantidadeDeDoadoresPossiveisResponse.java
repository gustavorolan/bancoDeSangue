package com.BancoDeSangue.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeDeDoadoresPossiveisResponse {
	private Long numeroDoadores;
	private String tipoSanguineo;
}
