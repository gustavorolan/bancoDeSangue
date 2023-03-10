package com.bancoDeSangue.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.response.MediaIdadePorTipoSanguineoResponse;
import com.bancoDeSangue.model.TipoSanguineo;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.MediaIdadePorTipoSanguineoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MediaIdadePorTipoSanguineoServiceImpl implements MediaIdadePorTipoSanguineoService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<MediaIdadePorTipoSanguineoResponse> consultar() {
		Collection<TipoSanguineo> tipoSanguineos = TipoSanguineo.obterLitaDeTiposSanguineos()
				.values();

		return tipoSanguineos.stream()
				.map(this::obterMediaIdadePorTipoSanguineoResponse)
				.collect(Collectors.toList());
	}

	private MediaIdadePorTipoSanguineoResponse obterMediaIdadePorTipoSanguineoResponse(TipoSanguineo tipoSanguineo) {
		List<Integer> listaDeIdades = usuarioRepository.listaDeIdadePorTipoSanguineo(tipoSanguineo);
		Integer somaDasIdades = listaDeIdades.stream()
				.reduce(0, Integer::sum);
		double media = Double.valueOf(somaDasIdades) / (double) listaDeIdades.size();

		return MediaIdadePorTipoSanguineoResponse.builder()
				.media((float) media)
				.tipoSanguineo(tipoSanguineo.getSigla())
				.build();
	}
}
