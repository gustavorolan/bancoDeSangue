package com.bancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bancoDeSangue.dtos.response.UsuarioResponse;
import com.bancoDeSangue.mapper.UsuarioMapper;
import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.security.service.UsuarioAutenticadoService;
import com.bancoDeSangue.util.factory.UsuarioFactory;

@ExtendWith(MockitoExtension.class)
class UsuarioAutenticadoResponseServiceImplTest {

	private final UsuarioMapper usuarioMapper = new UsuarioMapper();

	private final UsuarioAutenticadoService usuarioAutenticadoService = Mockito.mock(UsuarioAutenticadoService.class);

	@InjectMocks
	private UsuarioAutenticadoResponseServiceImpl usuarioAutenticadoResponseService = new UsuarioAutenticadoResponseServiceImpl(usuarioAutenticadoService, usuarioMapper);

	@Test
	@DisplayName("Deve retornar usuario autenticado corretamente")
	void obter() {

		Usuario usuario = UsuarioFactory.obterUsuario();
		UsuarioResponse usuarioResponse = UsuarioFactory.obterUsuarioResponse();

		Mockito.when(usuarioAutenticadoService.obter())
				.thenReturn(usuario);

		UsuarioResponse resultado = usuarioAutenticadoResponseService.obter();

		assertEquals(usuarioResponse, resultado);
	}
}