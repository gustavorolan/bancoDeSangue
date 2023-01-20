package com.bancoDeSangue.service.tipoSanguineo.impl;

import static com.bancoDeSangue.model.TipoSanguineo.A_B_NEGATIVO;
import static com.bancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.bancoDeSangue.model.TipoSanguineo.B_NEGATIVO;
import static com.bancoDeSangue.model.TipoSanguineo.B_POSITIVO;
import static com.bancoDeSangue.model.TipoSanguineo.O_NEGATIVO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.model.TipoSanguineo;
import com.bancoDeSangue.service.tipoSanguineo.TipoSanguineoService;

@Service
public class BNegativoServiceImpl implements TipoSanguineoService {
	@Override
	public List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo) {
		if (B_NEGATIVO == tipoSanguineo)
			return List.of(B_POSITIVO, B_NEGATIVO, A_B_POSITIVO, A_B_NEGATIVO);
		return List.of();
	}

	@Override
	public List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo) {
		if (B_NEGATIVO == tipoSanguineo)
			return List.of(B_NEGATIVO, O_NEGATIVO);
		return List.of();
	}
}
