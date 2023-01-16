package com.BancoDeSangue.service.impl;

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

import com.BancoDeSangue.dtos.response.PercentualObesidadeResponse;
import com.BancoDeSangue.model.Sexo;
import com.BancoDeSangue.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class PercentualObesidadeServiceImplTest {

	@InjectMocks
	private PercentualObesidadeServiceImpl percentualObesidadeService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Test
	@DisplayName("Deve calcular percentual de obesidade por sexo")
	void consultar() {
		Long numeroDeObesos = 50L;
		Long numeroDePessoas = 100L;
		float percentualEsperado = 50F;

		Mockito.when(usuarioRepository.contadorPorSexoAndObesidade(any(Sexo.class), Mockito.anyBoolean()))
				.thenReturn(numeroDeObesos);

		Mockito.when(usuarioRepository.contadorPorSexo(any()))
				.thenReturn(numeroDePessoas);

		List<Float> listaDePercentuais = percentualObesidadeService.consultar()
				.stream()
				.map(PercentualObesidadeResponse::getPercentual)
				.collect(Collectors.toList());

		listaDePercentuais.forEach(percentual -> {
			assertEquals(percentualEsperado, percentual);
		});
	}
}