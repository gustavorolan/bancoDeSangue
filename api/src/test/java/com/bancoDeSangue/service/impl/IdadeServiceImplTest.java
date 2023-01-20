package com.bancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.util.factory.LocalDateFactory;
import com.bancoDeSangue.util.factory.UsuarioFactory;

@ExtendWith(MockitoExtension.class)
class IdadeServiceImplTest {

	@InjectMocks
	private IdadeServiceImpl idadeService;

	@Mock
	private LocalDateServiceImpl localDateServiceImpl;

	@Test
	@DisplayName("Deve preencher idade corretamente, aniversario antes da data atual")
	void preencherIdadeAntesAniversario() {
		Usuario usuario = UsuarioFactory.obterUsuario();
		LocalDate data = LocalDateFactory.data();
		int idadeEsperada = 58;

		Mockito.when(localDateServiceImpl.now())
				.thenReturn(data);
		Usuario resultado = idadeService.preencher(usuario);

		Mockito.verify(localDateServiceImpl).now();

		assertEquals(idadeEsperada, resultado.getIdade());
	}

	@Test
	@DisplayName("Deve preencher idade corretamente, aniversario depois da data atual")
	void preencherIdadeAposAniversario() {
		Usuario usuario = UsuarioFactory.obterUsuario();
		LocalDate data = LocalDate.of(2023, 6, 16);
		int idadeEsperada = 59;

		Mockito.when(localDateServiceImpl.now())
				.thenReturn(data);
		Usuario resultado = idadeService.preencher(usuario);

		Mockito.verify(localDateServiceImpl).now();

		assertEquals(idadeEsperada, resultado.getIdade());
	}
}