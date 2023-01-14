package com.BancoDeSangue.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BancoDeSangue.dtos.response.EstadoResponse;
import com.BancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;
import com.BancoDeSangue.dtos.response.PercentualObesidadeResponse;
import com.BancoDeSangue.service.EstadoService;
import com.BancoDeSangue.service.PercentualObesidadeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/publico")
@RequiredArgsConstructor
public class EstadoController {
	private final EstadoService estadoService;
	private final PercentualObesidadeService percentualObesidadeService;

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
}
