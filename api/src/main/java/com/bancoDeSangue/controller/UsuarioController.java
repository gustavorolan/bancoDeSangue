package com.bancoDeSangue.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoDeSangue.dtos.request.CriarNovoUsuarioRequest;
import com.bancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.bancoDeSangue.dtos.response.UsuarioResponse;
import com.bancoDeSangue.service.UsuarioAutenticadoResponseService;
import com.bancoDeSangue.service.UsuariosPorEstadoService;
import com.bancoDeSangue.service.impl.NovoUsuarioServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
	private final NovoUsuarioServiceImpl createNewUserService;

	private final UsuariosPorEstadoService usuariosPorEstadoService;

	private final UsuarioAutenticadoResponseService usuarioAutenticadoResponseService;

	@PostMapping("/criar")
	public ResponseEntity<Long> create(@Valid @RequestBody CriarNovoUsuarioRequest request) {
		Long idUsuario = createNewUserService.criar(request);
		return ResponseEntity.ok(idUsuario);
	}

	@PostMapping("/criarLista")
	public ResponseEntity<List<Long>> create(@Valid @RequestBody List<CriarNovoUsuarioRequest> request) {
		List<Long> idUsuarios = createNewUserService.criar(request);
		return ResponseEntity.ok(idUsuarios);
	}


	@PostMapping("/login")
	public ResponseEntity<Object> login() {
		return ResponseEntity.noContent().build();
	}


	@GetMapping("/usuarioAutenticado")
	public ResponseEntity<UsuarioResponse> obterTodosUsuariosPorEstado(){
		UsuarioResponse listaUsuarioResponse = usuarioAutenticadoResponseService.obter();
		return ResponseEntity.ok(listaUsuarioResponse);
	}

	@GetMapping("/estado")
	public ResponseEntity<Page<List<UsuarioResponse>>> obterTodosUsuariosPorEstado(@RequestBody ObterTodosUsuariosPorEstadoRequest request){
		Page<List<UsuarioResponse>> listaUsuarioResponse = usuariosPorEstadoService.obter(request);
		return ResponseEntity.ok(listaUsuarioResponse);
	}
}
