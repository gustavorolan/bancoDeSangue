package com.bancoDeSangue.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoDeSangue.dtos.response.EstadoResponse;
import com.bancoDeSangue.dtos.response.MediaIdadePorTipoSanguineoResponse;
import com.bancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;
import com.bancoDeSangue.dtos.response.PercentualObesidadePorIdadeResponse;
import com.bancoDeSangue.dtos.response.PercentualObesidadeResponse;
import com.bancoDeSangue.dtos.response.QuantidadeDeDoadoresPossiveisResponse;
import com.bancoDeSangue.service.EstadoService;
import com.bancoDeSangue.service.MediaIdadePorTipoSanguineoService;
import com.bancoDeSangue.service.PercentualObesidadePorIdadeService;
import com.bancoDeSangue.service.PercentualObesidadeService;
import com.bancoDeSangue.service.QuantidadeDeDoadoresPossiveisService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inicio")
@RequiredArgsConstructor
public class InicioController {
	private final EstadoService estadoService;
	private final PercentualObesidadeService percentualObesidadeService;

	private final MediaIdadePorTipoSanguineoService mediaIdadePorTipoSanguineoService;
	
	private final QuantidadeDeDoadoresPossiveisService quantidadeDeDoadoresPossiveisService;

	private final PercentualObesidadePorIdadeService percentualObesidadePorIdadeService;

	@GetMapping("/estados")
	public ResponseEntity<List<EstadoResponse>> obter(){
		List<EstadoResponse> estados = estadoService.obter();
		return ResponseEntity.ok(estados);
	}

	@GetMapping("/estados/numeroDeDoadores")
	public ResponseEntity<List<NumeroDeDoadoresPorEstadoResponse>> numeroDeDoadores(){
		List<NumeroDeDoadoresPorEstadoResponse> estados = estadoService.numeroDeDoadores();
		return ResponseEntity.ok(estados);
	}


	@GetMapping("/percentualObesidade")
	public ResponseEntity<List<PercentualObesidadeResponse>> percentualObesidade(){
		List<PercentualObesidadeResponse> percentualObesidade = percentualObesidadeService.consultar();
		return ResponseEntity.ok(percentualObesidade) ;
	}

	@GetMapping("/mediaIdadePorTipoSanguineo")
	public ResponseEntity<List<MediaIdadePorTipoSanguineoResponse>> mediaIdadePorTipoSanguineo(){
		List<MediaIdadePorTipoSanguineoResponse> listaDeMediaDasIdades = mediaIdadePorTipoSanguineoService.consultar();
		return ResponseEntity.ok(listaDeMediaDasIdades);
	}
	
	@GetMapping("/quantidadeDeDoadoresPossiveis")
	public ResponseEntity<List<QuantidadeDeDoadoresPossiveisResponse>> quantidadeDeDoadoresPossiveis(){
		List<QuantidadeDeDoadoresPossiveisResponse> listaResponseQuantidadeDeDoadoresPossiveis = quantidadeDeDoadoresPossiveisService.consultar();
		return ResponseEntity.ok(listaResponseQuantidadeDeDoadoresPossiveis);
	}

	@GetMapping("/percentualObesidadePorIdade")
	public ResponseEntity<List<PercentualObesidadePorIdadeResponse>> percentualObesidadePorIdade(){
		List<PercentualObesidadePorIdadeResponse> listaPercentualObesidade = percentualObesidadePorIdadeService.consultar();
		return ResponseEntity.ok(listaPercentualObesidade);
	}
}
