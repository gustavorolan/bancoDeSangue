package com.BancoDeSangue.service.tipoSanguineo.impl;

import static com.BancoDeSangue.model.TipoSanguineo.A_B_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.B_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_POSITIVO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.service.tipoSanguineo.TipoSanguineoService;

@Service
public class ABPositivoServiceImpl implements TipoSanguineoService {
	@Override
	public List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo) {
		if (A_B_POSITIVO == tipoSanguineo)
			return List.of(A_B_POSITIVO);
		return List.of();
	}

	@Override
	public List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo) {
		if (A_B_POSITIVO == tipoSanguineo)
			return List.of(A_POSITIVO, B_POSITIVO, O_POSITIVO, A_B_POSITIVO, A_NEGATIVO, B_NEGATIVO, O_NEGATIVO, A_B_NEGATIVO);
		return List.of();
	}
}
