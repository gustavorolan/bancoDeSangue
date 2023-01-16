package com.BancoDeSangue.dtos.request;

import javax.validation.constraints.NotNull;

import com.BancoDeSangue.model.Estado;
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
