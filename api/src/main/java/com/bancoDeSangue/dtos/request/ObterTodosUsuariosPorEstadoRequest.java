package com.BancoDeSangue.dtos.request;

import com.BancoDeSangue.model.Estado;
import lombok.Data;

@Data

public class ObterTodosUsuariosPorEstadoRequest {
	private Estado estado;
}
