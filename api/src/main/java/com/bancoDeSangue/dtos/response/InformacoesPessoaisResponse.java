package com.BancoDeSangue.dtos.response;

import com.BancoDeSangue.model.Sexo;
import com.BancoDeSangue.model.TipoSanguineo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformacoesPessoaisResponse {
	private Sexo sexo;
	private TipoSanguineo tipoSanguineo;
}
