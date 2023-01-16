package com.BancoDeSangue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.response.EstadoResponse;
import com.BancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;
import com.BancoDeSangue.model.Estado;
import com.BancoDeSangue.repository.UsuarioRepository;
import com.BancoDeSangue.service.EstadoService;
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
