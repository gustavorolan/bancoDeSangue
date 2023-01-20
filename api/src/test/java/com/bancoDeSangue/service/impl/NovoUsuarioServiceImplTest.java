package com.bancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bancoDeSangue.dtos.request.CriarNovoUsuarioRequest;
import com.bancoDeSangue.mapper.UsuarioMapper;
import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.DoarService;
import com.bancoDeSangue.service.IdadeService;
import com.bancoDeSangue.service.ImcService;
import com.bancoDeSangue.util.factory.UsuarioFactory;

@ExtendWith(MockitoExtension.class)
class NovoUsuarioServiceImplTest {

	@InjectMocks
	private NovoUsuarioServiceImpl novoUsuarioService;

	@Mock
	private PasswordEncoder passwordEncoder;

	@Mock
	private UsuarioMapper usuarioMapper;

	@Mock
	private IdadeService idadeService;

	@Mock
	private ImcService imcService;

	@Mock
	private DoarService doarService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Captor
	private ArgumentCaptor<Usuario> captor;

	@Test
	@DisplayName("Deve criar um novo usuário")
	void criar() {
		CriarNovoUsuarioRequest request = UsuarioFactory.obterCriarNovoUsuarioRequest();
		Usuario usuario = UsuarioFactory.obterUsuario();
		Usuario usuarioComIdade = UsuarioFactory.obterUsuario();
		usuarioComIdade.setIdade(64);

		Usuario usuarioComImc = UsuarioFactory.obterUsuario();
		usuarioComImc.setIdade(64);
		usuarioComImc.setImc(34.17488999957281);
		usuarioComImc.setObeso(true);

		Usuario usuarioComIsPermitidoDoar = UsuarioFactory.obterUsuario();
		usuarioComIsPermitidoDoar.setIdade(64);
		usuarioComIsPermitidoDoar.setImc(34.17488999957281);
		usuarioComIsPermitidoDoar.setObeso(true);
		usuarioComIsPermitidoDoar.setPermitidoDoar(true);

		Mockito.when(passwordEncoder.encode(request.getSenha()))
				.thenReturn(request.getSenha());
		Mockito.when(usuarioMapper.toEntity(request))
				.thenReturn(usuario);
		Mockito.when(idadeService.preencher(any()))
				.thenReturn(usuarioComIdade);
		Mockito.when(imcService.preencher(usuarioComIdade))
				.thenReturn(usuarioComImc);
		Mockito.when(doarService.preencher(usuarioComImc))
				.thenReturn(usuarioComIsPermitidoDoar);
		Mockito.when(usuarioRepository.save(usuarioComIsPermitidoDoar))
				.thenReturn(usuarioComIsPermitidoDoar);

		Long result = novoUsuarioService.criar(request);

		Mockito.verify(usuarioRepository)
				.save(captor.capture());
		Mockito.verify(passwordEncoder)
				.encode(request.getSenha());
		Mockito.verify(usuarioMapper)
				.toEntity(request);
		Mockito.verify(idadeService)
				.preencher(usuario);
		Mockito.verify(imcService)
				.preencher(usuarioComIdade);
		Mockito.verify(doarService)
				.preencher(usuarioComImc);

		assertEquals(usuarioComIsPermitidoDoar.getId(), result);
		assertEquals(usuarioComIsPermitidoDoar, captor.getValue());
	}

	@Test
	@DisplayName("Deve criar um novo usuário, a partir de uma lista de requests")
	void criarLista() {
		CriarNovoUsuarioRequest request = UsuarioFactory.obterCriarNovoUsuarioRequest();
		Usuario usuario = UsuarioFactory.obterUsuario();
		Usuario usuarioComIdade = UsuarioFactory.obterUsuario();
		usuarioComIdade.setIdade(64);

		Usuario usuarioComImc = UsuarioFactory.obterUsuario();
		usuarioComImc.setIdade(64);
		usuarioComImc.setImc(34.17488999957281);
		usuarioComImc.setObeso(true);

		Usuario usuarioComIsPermitidoDoar = UsuarioFactory.obterUsuario();
		usuarioComIsPermitidoDoar.setIdade(64);
		usuarioComIsPermitidoDoar.setImc(34.17488999957281);
		usuarioComIsPermitidoDoar.setObeso(true);
		usuarioComIsPermitidoDoar.setPermitidoDoar(true);

		Mockito.when(passwordEncoder.encode(request.getSenha()))
				.thenReturn(request.getSenha());
		Mockito.when(usuarioMapper.toEntity(request))
				.thenReturn(usuario);
		Mockito.when(idadeService.preencher(any()))
				.thenReturn(usuarioComIdade);
		Mockito.when(imcService.preencher(usuarioComIdade))
				.thenReturn(usuarioComImc);
		Mockito.when(doarService.preencher(usuarioComImc))
				.thenReturn(usuarioComIsPermitidoDoar);
		Mockito.when(usuarioRepository.save(usuarioComIsPermitidoDoar))
				.thenReturn(usuarioComIsPermitidoDoar);

		List<Long> result = novoUsuarioService.criar(List.of(request));

		Mockito.verify(usuarioRepository)
				.save(captor.capture());
		Mockito.verify(passwordEncoder)
				.encode(request.getSenha());
		Mockito.verify(usuarioMapper)
				.toEntity(request);
		Mockito.verify(idadeService)
				.preencher(usuario);
		Mockito.verify(imcService)
				.preencher(usuarioComIdade);
		Mockito.verify(doarService)
				.preencher(usuarioComImc);

		assertEquals(usuarioComIsPermitidoDoar.getId(), result.get(0));
		assertEquals(usuarioComIsPermitidoDoar, captor.getValue());
	}
}