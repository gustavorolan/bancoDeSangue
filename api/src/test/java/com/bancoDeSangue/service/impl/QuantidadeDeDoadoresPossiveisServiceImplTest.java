package com.bancoDeSangue.service.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bancoDeSangue.dtos.response.QuantidadeDeDoadoresPossiveisResponse;
import com.bancoDeSangue.model.TipoSanguineo;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.tipoSanguineo.TipoSanguineoExecutorService;
import com.bancoDeSangue.util.factory.TipoSanguineoFactory;

@ExtendWith(MockitoExtension.class)
class QuantidadeDeDoadoresPossiveisServiceImplTest {

	@InjectMocks
	private QuantidadeDeDoadoresPossiveisServiceImpl quantidadeDeDoadoresPossiveisService;

	@Mock
	private  TipoSanguineoExecutorService tipoSanguineoExecutorService;

	@Mock
	private  UsuarioRepository usuarioRepository;

	@Test
	@DisplayName("Deve retornar numero de doadores por tipo sanguineo")
	void consultar() {
		List<TipoSanguineo> listaDeTiposSanguineos = TipoSanguineoFactory.obterPossivelDoarAPositivo();
		long numeroDeDoadoresEsperado = 50L;

		Mockito.when(tipoSanguineoExecutorService.obterListaPossivelReceber(any())).thenReturn(listaDeTiposSanguineos);
		Mockito.when(usuarioRepository.contadorPorListaDeTipoSanguineo(listaDeTiposSanguineos,true)).thenReturn(numeroDeDoadoresEsperado);

		List<QuantidadeDeDoadoresPossiveisResponse> listaDeResultado = quantidadeDeDoadoresPossiveisService.consultar();

		Mockito.verify(tipoSanguineoExecutorService, Mockito.atMost(8)).obterListaPossivelReceber(any());
		Mockito.verify(usuarioRepository, Mockito.atMost(8)).contadorPorListaDeTipoSanguineo(listaDeTiposSanguineos,true);

		listaDeResultado.forEach(resultado-> assertEquals(numeroDeDoadoresEsperado, resultado.getNumeroDoadores()));
	}
}