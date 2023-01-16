package com.BancoDeSangue.service.tipoSanguineo.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.service.tipoSanguineo.TipoSanguineoExecutorService;
import com.BancoDeSangue.service.tipoSanguineo.TipoSanguineoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TipoSanguineoExecutorServiceImpl implements TipoSanguineoExecutorService {

	private final List<TipoSanguineoService> listatipoSanguineoService;

	@Override
	public List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo) {

		List<List<TipoSanguineo>> listaDeRetornosTiposSaguineosService = listatipoSanguineoService.stream()
				.map(tipoSanguineoService -> tipoSanguineoService.obterListaPossivelDoar(tipoSanguineo))
				.collect(Collectors.toList());

		return listaDeRetornosTiposSaguineosService.stream()
				.filter(retorno -> !retorno.isEmpty())
				.findFirst()
				.get();
	}

	@Override
	public List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo) {
		List<List<TipoSanguineo>> listaDeRetornosTiposSaguineosService = listatipoSanguineoService.stream()
				.map(tipoSanguineoService -> tipoSanguineoService.obterListaPossivelReceber(tipoSanguineo))
				.collect(Collectors.toList());

		return listaDeRetornosTiposSaguineosService.stream()
				.filter(retorno -> !retorno.isEmpty())
				.findFirst()
				.get();
	}
}
