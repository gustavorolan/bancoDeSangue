package com.BancoDeSangue.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BancoDeSangue.dtos.response.EstadoResponse;
import com.BancoDeSangue.dtos.response.MediaIdadePorTipoSanguineoResponse;
import com.BancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;
import com.BancoDeSangue.dtos.response.PercentualObesidadePorIdadeResponse;
import com.BancoDeSangue.dtos.response.PercentualObesidadeResponse;
import com.BancoDeSangue.dtos.response.QuantidadeDeDoadoresPossiveisResponse;
import com.BancoDeSangue.service.EstadoService;
import com.BancoDeSangue.service.MediaIdadePorTipoSanguineoService;
import com.BancoDeSangue.service.PercentualObesidadePorIdadeService;
import com.BancoDeSangue.service.PercentualObesidadeService;
import com.BancoDeSangue.service.QuantidadeDeDoadoresPossiveisService;
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
