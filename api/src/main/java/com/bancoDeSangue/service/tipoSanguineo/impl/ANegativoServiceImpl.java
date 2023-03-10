package com.bancoDeSangue.service.tipoSanguineo.impl;

import static com.bancoDeSangue.model.TipoSanguineo.A_B_NEGATIVO;
import static com.bancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.bancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.bancoDeSangue.model.TipoSanguineo.A_POSITIVO;
import static com.bancoDeSangue.model.TipoSanguineo.O_NEGATIVO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.model.TipoSanguineo;
import com.bancoDeSangue.service.tipoSanguineo.TipoSanguineoService;

@Service
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
