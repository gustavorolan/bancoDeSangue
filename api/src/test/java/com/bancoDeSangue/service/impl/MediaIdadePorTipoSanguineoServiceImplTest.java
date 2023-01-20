package com.bancoDeSangue.service.impl;

import static java.util.stream.Collectors.*;
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

import com.bancoDeSangue.dtos.response.MediaIdadePorTipoSanguineoResponse;
import com.bancoDeSangue.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
class MediaIdadePorTipoSanguineoServiceImplTest {

	@InjectMocks
	private MediaIdadePorTipoSanguineoServiceImpl mediaIdadePorTipoSanguineoService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Test
	@DisplayName("Deve calcular media corretamente")
	void consultar() {
		List<Integer> listaDeIdades = List.of(2, 2, 4, 4, 4, 2, 4, 2);
		Float mediaEsperada = 3F;

		Mockito.when(usuarioRepository.listaDeIdadePorTipoSanguineo(any()))
				.thenReturn(listaDeIdades);

		List<Float> resultado = mediaIdadePorTipoSanguineoService.consultar()
				.stream()
				.map(MediaIdadePorTipoSanguineoResponse::getMedia)
				.collect(toList());

		resultado.forEach(media -> {
			assertEquals(mediaEsperada, media);
		});

	}
}