package com.BancoDeSangue.util.factory;

import java.util.List;

import com.BancoDeSangue.dtos.response.PercentualObesidadePorIdadeResponse;

public class PercentualObesidadePorIdadeResponseFactory {
	public static List<PercentualObesidadePorIdadeResponse> obter(){
		return List.of(
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("[0, 10]").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("[11, 20]").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("[21, 30]").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("[31, 40]").build(),
				PercentualObesidadePorIdadeResponse.builder().media(35.0).faixaEtaria("[41, 50]").build()
				) ;
	}
}
