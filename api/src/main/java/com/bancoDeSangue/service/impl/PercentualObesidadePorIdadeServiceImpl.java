package com.BancoDeSangue.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.response.PercentualObesidadePorIdadeResponse;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.repository.UsuarioRepository;
import com.BancoDeSangue.service.PercentualObesidadePorIdadeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PercentualObesidadePorIdadeServiceImpl implements PercentualObesidadePorIdadeService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<PercentualObesidadePorIdadeResponse> consultar() {
		List<List<Integer>> listaDeFaixasEtarias = criarRange();

		return listaDeFaixasEtarias.stream().map(faixaEtaria->{
			List<Usuario> usuarios = usuarioRepository.listaDeUsuariosPorIdade(faixaEtaria.get(0), faixaEtaria.get(1));

			Double somaImcs = usuarios.stream()
					.map(Usuario::getImc)
					.reduce((double) 0,Double::sum);

			double media = somaImcs / usuarios.size();
			if (usuarios.isEmpty())media=0;
			return new PercentualObesidadePorIdadeResponse(
					String.valueOf(faixaEtaria),
					media
			);
		}).collect(Collectors.toList());
	}

	public List<List<Integer>> criarRange(){
		List<List<Integer>> faixasEtarias = new ArrayList<>();
		int maiorIdade = usuarioRepository.findFirstByOrderByIdadeDesc().getIdade();
		int numeroDeFaixasEtarias = maiorIdade / 10;
		for (int i = 0; i <= numeroDeFaixasEtarias; i++) {
			if (i==0)faixasEtarias.add(List.of(0,10));
			else faixasEtarias.add(List.of(((i*10)+1),(i+1)*10));
		}
		return faixasEtarias;
	}
}
