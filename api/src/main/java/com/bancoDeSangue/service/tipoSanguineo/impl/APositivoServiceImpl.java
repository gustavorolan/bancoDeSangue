package com.BancoDeSangue.service.tipoSanguineo.impl;

import static com.BancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.O_POSITIVO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.service.tipoSanguineo.TipoSanguineoService;

@Service
public class APositivoServiceImpl implements TipoSanguineoService {
	public List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo) {
		if (A_POSITIVO == tipoSanguineo)
			return List.of(A_B_POSITIVO, A_POSITIVO);
		return List.of();
	}

	public List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo) {
		if (A_POSITIVO == tipoSanguineo)
			return List.of(A_NEGATIVO, A_POSITIVO, O_POSITIVO, O_NEGATIVO);
		return List.of();
	}
}
