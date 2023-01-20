package com.bancoDeSangue.dtos.request;

import javax.validation.constraints.NotNull;

import com.bancoDeSangue.model.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObterTodosUsuariosPorEstadoRequest {
	@NotNull(message = "Estado deve ser preenchido")
	private Estado estado;

	@NotNull(message = "Estado deve ser preenchido")
	private int pagina = 0;
}
