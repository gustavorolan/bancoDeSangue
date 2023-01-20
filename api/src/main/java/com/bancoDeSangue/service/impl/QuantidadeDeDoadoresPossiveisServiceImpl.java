package com.bancoDeSangue.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.response.QuantidadeDeDoadoresPossiveisResponse;
import com.bancoDeSangue.model.TipoSanguineo;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.QuantidadeDeDoadoresPossiveisService;
import com.bancoDeSangue.service.tipoSanguineo.TipoSanguineoExecutorService;
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
		Long numeroDeDoadores = usuarioRepository.contadorPorListaDeTipoSanguineo(listaTipoSanguineos, true);
		return QuantidadeDeDoadoresPossiveisResponse.builder()
				.numeroDoadores(numeroDeDoadores)
				.tipoSanguineo(tipoSanguineo.getSigla())
				.build();
	}
}
