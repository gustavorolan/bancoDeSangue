package com.bancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bancoDeSangue.dtos.response.EstadoResponse;
import com.bancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.util.factory.EstadoResponseFactory;

@ExtendWith(MockitoExtension.class)
class EstadoServiceImplTest {

	@InjectMocks
	private EstadoServiceImpl estadoService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Test
	@DisplayName("Deve retornar os Estados do brasil")
	void obter() {
		List<EstadoResponse> listaDeEstadosResponse = EstadoResponseFactory.obter();
		List<EstadoResponse> result = estadoService.obter();
		assertEquals(listaDeEstadosResponse,result);
	}

	@Test
	@DisplayName("Deve retornar o numero esperado")
	void numeroDeDoadores() {
		long numeroDoadoresEsperado = 10L;
		Mockito.when(usuarioRepository.contadorPorEstado(any())).thenReturn(numeroDoadoresEsperado);
		List<Long> listaComNumeroDeDoadores = estadoService.numeroDeDoadores()
				.stream()
				.map(NumeroDeDoadoresPorEstadoResponse::getNumeroDeDoadores)
				.collect(Collectors.toList());

		listaComNumeroDeDoadores.forEach(numero->{
			assertEquals(numeroDoadoresEsperado, numero);
		});
	}
}