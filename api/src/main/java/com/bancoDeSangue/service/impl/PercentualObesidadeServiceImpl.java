package com.bancoDeSangue.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.response.PercentualObesidadeResponse;
import com.bancoDeSangue.model.Sexo;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.PercentualObesidadeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PercentualObesidadeServiceImpl implements PercentualObesidadeService {
	private final UsuarioRepository usuarioRepository;

	@Override
	public List<PercentualObesidadeResponse> consultar() {
		List<PercentualObesidadeResponse> listaPercentualObesidadeResponse = new ArrayList<>();
		Sexo.obterLista().forEach((s, sexo) -> listaPercentualObesidadeResponse.add(obterPercentualObesidadeResponse(sexo)));
		return listaPercentualObesidadeResponse;
	}

	private PercentualObesidadeResponse obterPercentualObesidadeResponse(Sexo sexo) {
		Double numeroDeObesos = (double) usuarioRepository.contadorPorSexoAndObesidade(sexo, true);
		Double numeroDePessoas = (double) usuarioRepository.contadorPorSexo(sexo);
		double percentual = (numeroDeObesos / numeroDePessoas) * 100;

		return PercentualObesidadeResponse.builder()
				.percentual((float) percentual)
				.sexo(sexo.getDescricao())
				.build();
	}
}
