package com.BancoDeSangue.service.tipoSanguineo;

import static com.BancoDeSangue.model.TipoSanguineo.A_B_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_NEGATIVO;

import java.util.List;

import com.BancoDeSangue.model.TipoSanguineo;

public class ANegativoServiceImpl implements TipoSanguineoService {
	@Override
	public List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo) {
		if (A_NEGATIVO == tipoSanguineo)
			return List.of(A_POSITIVO, A_NEGATIVO, A_B_POSITIVO, A_B_NEGATIVO);
		return List.of();
	}

	@Override
	public List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo) {
		if (A_NEGATIVO == tipoSanguineo)
			return List.of(A_NEGATIVO, O_NEGATIVO);
		return List.of();
	}
}
