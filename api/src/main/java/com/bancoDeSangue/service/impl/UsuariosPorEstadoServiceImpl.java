package com.BancoDeSangue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.BancoDeSangue.dtos.response.UsuarioResponse;
import com.BancoDeSangue.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuariosPorEstadoServiceImpl implements UsuariosPorEstadoService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioResponse> obter(ObterTodosUsuariosPorEstadoRequest request) {
		return null;
	}
}
