package com.bancoDeSangue.dtos.response;

import com.bancoDeSangue.model.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstadoResponse {
	private Estado sigla;
	private String nome;
}
