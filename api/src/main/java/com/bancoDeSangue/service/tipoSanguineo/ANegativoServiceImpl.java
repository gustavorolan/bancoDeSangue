package com.BancoDeSangue.service.tipoSanguineo;

import static com.BancoDeSangue.model.TipoSanguineo.A_B_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_NEGATIVO;

import java.util.List;

import com.BancoDeSangue.model.TipoSanguineo;

public class BNegativoServiceImpl implements TipoSanguineoService {
	@Override
	public List<TipoSanguineo> isPossivelDoar(TipoSanguineo tipoSanguineo) {
		return List.of(A_POSITIVO, A_NEGATIVO, A_B_POSITIVO, A_B_NEGATIVO);
	}

	@Override
	public List<TipoSanguineo> isPossivelReceber(TipoSanguineo tipoSanguineo) {
		return List.of(A_NEGATIVO,O_NEGATIVO);
	}
}
