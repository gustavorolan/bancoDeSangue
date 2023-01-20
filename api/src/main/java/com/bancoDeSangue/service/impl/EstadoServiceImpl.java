package com.bancoDeSangue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.response.EstadoResponse;
import com.bancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;
import com.bancoDeSangue.model.Estado;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.EstadoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<EstadoResponse> obter() {
		List<Estado> estados = Estado.obterLitaDeEstados();
		return estados.stream()
				.map(estado -> EstadoResponse.builder()
						.sigla(estado)
						.nome(estado.getNome())
						.build())
				.collect(Collectors.toList());
	}

	@Override
	public List<NumeroDeDoadoresPorEstadoResponse> numeroDeDoadores() {
		List<Estado> estados = Estado.obterLitaDeEstados();
		return estados.stream()
				.map(this::obterNumeroDeDoadoresPorEstadoResponse)
				.collect(Collectors.toList());
	}

	private NumeroDeDoadoresPorEstadoResponse obterNumeroDeDoadoresPorEstadoResponse(Estado estado) {
		Long numeroDeDoadores = usuarioRepository.contadorPorEstado(estado);

		return NumeroDeDoadoresPorEstadoResponse.builder()
				.estado(estado)
				.numeroDeDoadores(numeroDeDoadores)
				.build();
	}
}
