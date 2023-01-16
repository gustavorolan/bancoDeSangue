package com.BancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.util.factory.UsuarioFactory;

@ExtendWith(MockitoExtension.class)
class DoarServiceImplTest {

	@InjectMocks
	private DoarServiceImpl doarServiceImpl;

	@Test
	@DisplayName("Preenche o campo permitidoDoar como true")
	void preencherTrue() {
		Usuario usuario = UsuarioFactory.obterUsuario();

		doarServiceImpl.preencher(usuario);

		assertTrue(usuario.isPermitidoDoar());

	}

	@Test
	@DisplayName("Preenche o campo permitidoDoar como false por causa da idade ser menor que a permitida")
	void preencherFalseIdadeMenor() {
		Usuario usuario = UsuarioFactory.obterUsuario();
		usuario.setIdade(12);

		doarServiceImpl.preencher(usuario);

		assertFalse(usuario.isPermitidoDoar());
	}

	@Test
	@DisplayName("Preenche o campo permitidoDoar como false por causa da idade ser maior que a permitida")
	void preencherFalseIdadeMaior() {
		Usuario usuario = UsuarioFactory.obterUsuario();
		usuario.setIdade(70);

		doarServiceImpl.preencher(usuario);

		assertFalse(usuario.isPermitidoDoar());
	}

	@Test
	@DisplayName("Preenche o campo permitidoDoar como false por causa do peso ser abaixo do permitido")
	void preencherFalsePesoMenor() {
		Usuario usuario = UsuarioFactory.obterUsuario();
		usuario.getInformacoesPessoais().setPeso(49.0);

		doarServiceImpl.preencher(usuario);

		assertFalse(usuario.isPermitidoDoar());
	}
}