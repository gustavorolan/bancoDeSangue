package com.BancoDeSangue.util.factory;

import java.util.List;

import com.BancoDeSangue.dtos.response.PercentualObesidadePorIdadeResponse;

public class PercentualObesidadePorIdadeResponseFactory {
	public static List<PercentualObesidadePorIdadeResponse> obter(){
		return List.of(
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("De 0 até 10").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("De 11 até 20").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("De 21 até 30").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("De 31 até 40").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("De 41 até 50").build()
				) ;
	}
}
