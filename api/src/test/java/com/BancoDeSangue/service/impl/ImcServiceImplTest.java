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
class ImcServiceImplTest {

	@InjectMocks
	private ImcServiceImpl imcService;

	@Test
	@DisplayName("Deve preencher imc corretamente, para pessoa obesa")
	void preencherImcCorretamenteObesoTrue() {
		Usuario usuario = UsuarioFactory.obterUsuario();
		double imc = 34.17488999957281;

		Usuario resultado = imcService.preencher(usuario);

		assertTrue(resultado.isObeso());
		assertEquals(imc, resultado.getImc());
	}

	@Test
	@DisplayName("Deve preencher imc corretamente, para pessoa não obesa")
	void preencherImcCorretamenteObesoFalse() {
		double imc = 22.877405702193368;
		Usuario usuario = UsuarioFactory.obterUsuario();
		usuario.getInformacoesPessoais().setPeso(80.00);
		usuario.getInformacoesPessoais().setAltura(1.87);

		Usuario resultado = imcService.preencher(usuario);

		assertFalse(resultado.isObeso());
		assertEquals(imc, resultado.getImc());
	}

}