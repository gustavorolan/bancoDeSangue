package com.bancoDeSangue.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContatoResponse {
	private String celular;
	private String telefone;
}
