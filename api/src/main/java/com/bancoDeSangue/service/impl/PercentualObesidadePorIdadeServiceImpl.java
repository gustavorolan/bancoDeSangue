package com.bancoDeSangue.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.response.PercentualObesidadePorIdadeResponse;
import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.PercentualObesidadePorIdadeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PercentualObesidadePorIdadeServiceImpl implements PercentualObesidadePorIdadeService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<PercentualObesidadePorIdadeResponse> consultar() {
		List<List<Integer>> listaDeFaixasEtarias = criarRange();

		return listaDeFaixasEtarias.stream()
				.map(this::calcularMediaDasFaixasEtarias)
				.collect(Collectors.toList());
	}

	private PercentualObesidadePorIdadeResponse calcularMediaDasFaixasEtarias(List<Integer> faixaEtaria) {
		List<Usuario> usuarios = usuarioRepository.listaDeUsuariosPorIdade(faixaEtaria.get(0), faixaEtaria.get(1));

		Double somaImcs = usuarios.stream().map(Usuario::getImc).reduce((double) 0, Double::sum);

		double media = calcularMedia(usuarios, somaImcs);

		return PercentualObesidadePorIdadeResponse.builder()
				.faixaEtaria("De "+faixaEtaria.get(0)+" até " + faixaEtaria.get(1))
				.media(media)
				.build();
	}

	private static double calcularMedia(List<Usuario> usuarios, Double somaImcs) {
		double media = somaImcs / usuarios.size();

		if (usuarios.isEmpty())
			media = 0;
		return media;
	}

	public List<List<Integer>> criarRange() {
		List<List<Integer>> faixasEtarias = new ArrayList<>();
		int maiorIdade = usuarioRepository.findFirstByOrderByIdadeDesc()
				.getIdade();
		int numeroDeFaixasEtarias = maiorIdade / 10;
		for (int i = 0; i <= numeroDeFaixasEtarias; i++) {
			if (i == 0)
				faixasEtarias.add(List.of(0, 10));
			else
				faixasEtarias.add(List.of(((i * 10) + 1), (i + 1) * 10));
		}
		return faixasEtarias;
	}
}
