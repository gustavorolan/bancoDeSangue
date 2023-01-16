package com.BancoDeSangue.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.response.QuantidadeDeDoadoresPossiveisResponse;
import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.repository.UsuarioRepository;
import com.BancoDeSangue.service.QuantidadeDeDoadoresPossiveisService;
import com.BancoDeSangue.service.tipoSanguineo.TipoSanguineoExecutorService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuantidadeDeDoadoresPossiveisServiceImpl implements QuantidadeDeDoadoresPossiveisService {

	private final TipoSanguineoExecutorService tipoSanguineoExecutorService;

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<QuantidadeDeDoadoresPossiveisResponse> consultar() {
		Collection<TipoSanguineo> listaDeTiposSanguineos = TipoSanguineo.obterLitaDeTiposSanguineos()
				.values();

		return listaDeTiposSanguineos.stream()
				.map(this::obterQuantidadeDeDoadoresPossiveisResponse)
				.collect(Collectors.toList());
	}

	private QuantidadeDeDoadoresPossiveisResponse obterQuantidadeDeDoadoresPossiveisResponse(TipoSanguineo tipoSanguineo) {
		List<TipoSanguineo> listaTipoSanguineos = tipoSanguineoExecutorService.obterListaPossivelReceber(tipoSanguineo);
		Long numeroDeDoadores = usuarioRepository.contadorPorListaDeTipoSanguineo(listaTipoSanguineos);
		return new QuantidadeDeDoadoresPossiveisResponse(numeroDeDoadores, tipoSanguineo.getSigla());
	}
}
