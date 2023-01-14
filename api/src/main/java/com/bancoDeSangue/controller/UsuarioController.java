package com.BancoDeSangue.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BancoDeSangue.dtos.request.CreateNewUserRequest;
import com.BancoDeSangue.service.impl.CriarNovoUsuarioServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {
	private final CriarNovoUsuarioServiceImpl createNewUserService;

	@PostMapping("/criar")
	public ResponseEntity<Long> create(@Valid @RequestBody CreateNewUserRequest request) {
		Long idUsuario = createNewUserService.create(request);
		return ResponseEntity.ok(idUsuario);
	}

	@PostMapping("/criarLista")
	public ResponseEntity<List<Long>> create(@Valid @RequestBody List<CreateNewUserRequest> request) {
		List<Long> idUsuarios = createNewUserService.create(request);
		return ResponseEntity.ok(idUsuarios);
	}


	@PostMapping("/login")
	public ResponseEntity<Object> login() {
		return ResponseEntity.noContent().build();
	}
}
