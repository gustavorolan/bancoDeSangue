package com.BancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.BancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.BancoDeSangue.dtos.response.UsuarioResponse;
import com.BancoDeSangue.mapper.UsuarioMapper;
import com.BancoDeSangue.model.Estado;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.repository.UsuarioRepository;
import com.BancoDeSangue.util.factory.UsuarioFactory;

@ExtendWith(MockitoExtension.class)
class UsuariosPorEstadoServiceImplTest {
	private final UsuarioMapper usuarioMapper = new UsuarioMapper();

	private final UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);

	@InjectMocks
	private UsuariosPorEstadoServiceImpl usuariosPorEstadoService = new UsuariosPorEstadoServiceImpl(usuarioRepository, usuarioMapper);

	@Test
	@DisplayName("Deve retornar usuário por estado")
	void obter() {
		Page<Usuario> usuario =  new PageImpl<>(List.of(UsuarioFactory.obterUsuario()));
		UsuarioResponse usuarioResponse = UsuarioFactory.obterUsuarioResponse();

		ObterTodosUsuariosPorEstadoRequest request = ObterTodosUsuariosPorEstadoRequest.builder()
				.estado(Estado.RS)
				.build();

		PageRequest pageRequest = PageRequest.of(0, 10);

		Mockito.when(usuarioRepository.findByEstado(request.getEstado(), pageRequest))
				.thenReturn(usuario);

		Page<List<UsuarioResponse>> resultado = usuariosPorEstadoService.obter(request);

		assertEquals(usuarioResponse, resultado.getContent().get(0).get(0));
	}
}