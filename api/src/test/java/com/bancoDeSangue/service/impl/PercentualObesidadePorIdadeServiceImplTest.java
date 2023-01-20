package com.bancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bancoDeSangue.dtos.response.PercentualObesidadePorIdadeResponse;
import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.util.factory.PercentualObesidadePorIdadeResponseFactory;
import com.bancoDeSangue.util.factory.UsuarioFactory;

@ExtendWith(MockitoExtension.class)
class PercentualObesidadePorIdadeServiceImplTest {

	@InjectMocks
	private PercentualObesidadePorIdadeServiceImpl percentualObesidadePorIdadeService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Test
	@DisplayName("Deve criar renge corretamente e calcular media das idades para eles")
	void consultar() {
		Usuario usuario1 = UsuarioFactory.obterUsuario();
		usuario1.setImc(20L);
		Usuario usuario2 = UsuarioFactory.obterUsuario();
		usuario2.setImc(30L);
		Usuario usuario3 = UsuarioFactory.obterUsuario();
		usuario3.setImc(40L);
		Usuario usuario4 = UsuarioFactory.obterUsuario();
		usuario4.setImc(50L);
		usuario4.setIdade(40);

		List<Usuario> listaDeUsuarios = List.of(usuario1, usuario2, usuario3, usuario4);

		List<PercentualObesidadePorIdadeResponse> percentualObesidadePorIdadeResponses = PercentualObesidadePorIdadeResponseFactory.obter();

		Mockito.when(usuarioRepository.listaDeUsuariosPorIdade(any(), any()))
				.thenReturn(listaDeUsuarios);

		Mockito.when(usuarioRepository.findFirstByOrderByIdadeDesc()).thenReturn(usuario4);

		List<PercentualObesidadePorIdadeResponse> resultado = percentualObesidadePorIdadeService.consultar();

		assertEquals(percentualObesidadePorIdadeResponses,resultado);
	}

	@Test
	@DisplayName("Deve devolver media igual a zero, pois não tem usuários para calcular")
	void consultarListaVazia() {
		Usuario usuario4 = UsuarioFactory.obterUsuario();
		usuario4.setImc(50L);
		usuario4.setIdade(20);

		List<Usuario> listaDeUsuarios = List.of();

		long mediaEsperada = 0;

		Mockito.when(usuarioRepository.listaDeUsuariosPorIdade(any(), any()))
				.thenReturn(listaDeUsuarios);

		Mockito.when(usuarioRepository.findFirstByOrderByIdadeDesc()).thenReturn(usuario4);

		List<PercentualObesidadePorIdadeResponse> resultado = percentualObesidadePorIdadeService.consultar();

		assertEquals(mediaEsperada,resultado.get(0).getMedia());
	}
}