package com.BancoDeSangue.dtos.response;

import com.BancoDeSangue.model.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumeroDeDoadoresPorEstadoResponse {
	private Estado estado;
	private Long numeroDeDoadores;
}
