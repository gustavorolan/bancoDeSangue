package com.BancoDeSangue.service.tipoSanguineo;

import static com.BancoDeSangue.model.TipoSanguineo.A_B_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.B_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_POSITIVO;

import java.util.List;

import com.BancoDeSangue.model.TipoSanguineo;

public class ABPositivoServiceImpl  implements TipoSanguineoService{
	@Override
	public List<TipoSanguineo> isPossivelDoar(TipoSanguineo tipoSanguineo) {
		return List.of(A_B_POSITIVO);
	}

	@Override
	public List<TipoSanguineo> isPossivelReceber(TipoSanguineo tipoSanguineo) {
		return List.of(A_POSITIVO,B_POSITIVO,O_POSITIVO,A_B_POSITIVO,A_NEGATIVO,B_NEGATIVO,O_NEGATIVO,A_B_NEGATIVO);
	}
}
