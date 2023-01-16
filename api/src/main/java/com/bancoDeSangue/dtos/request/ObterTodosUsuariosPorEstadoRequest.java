package com.BancoDeSangue.dtos.request;

import com.BancoDeSangue.model.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObterTodosUsuariosPorEstadoRequest {
	private Estado estado;
}
