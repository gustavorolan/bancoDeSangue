package com.bancoDeSangue.dtos.response;

import com.bancoDeSangue.model.Sexo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformacoesPessoaisResponse {
	private Sexo sexo;
	private String tipoSanguineo;
}
