package com.bancoDeSangue.service.tipoSanguineo.impl;

import static com.bancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.bancoDeSangue.model.TipoSanguineo.A_POSITIVO;

import static com.bancoDeSangue.model.TipoSanguineo.B_POSITIVO;
import static com.bancoDeSangue.model.TipoSanguineo.O_NEGATIVO;
import static com.bancoDeSangue.model.TipoSanguineo.O_POSITIVO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.model.TipoSanguineo;
import com.bancoDeSangue.service.tipoSanguineo.TipoSanguineoService;

@Service
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
