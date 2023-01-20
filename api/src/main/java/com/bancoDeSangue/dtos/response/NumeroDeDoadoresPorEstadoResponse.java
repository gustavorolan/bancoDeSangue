package com.bancoDeSangue.dtos.response;

import com.bancoDeSangue.model.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumeroDeDoadoresPorEstadoResponse {
	private Estado estado;
	private Long numeroDeDoadores;
}
