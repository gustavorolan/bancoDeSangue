package com.BancoDeSangue.service.tipoSanguineo;

import static com.BancoDeSangue.model.TipoSanguineo.A_B_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_POSITIVO;

import static com.BancoDeSangue.model.TipoSanguineo.B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_POSITIVO;

import java.util.List;

import com.BancoDeSangue.model.TipoSanguineo;

public class OPositivoServiceImpl implements TipoSanguineoService {
	@Override
	public List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo) {
		if (O_POSITIVO == tipoSanguineo) {
			return List.of(A_POSITIVO, B_POSITIVO, O_POSITIVO, A_B_POSITIVO);
		}
		return List.of();
	}

	@Override
	public List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo) {
		if (O_POSITIVO == tipoSanguineo) {
			return List.of(O_POSITIVO, O_NEGATIVO);
		}
		return List.of();
	}
}
