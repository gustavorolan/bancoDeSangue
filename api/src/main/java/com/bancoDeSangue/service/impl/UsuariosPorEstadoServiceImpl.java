package com.BancoDeSangue.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.BancoDeSangue.dtos.response.UsuarioResponse;
import com.BancoDeSangue.mapper.UsuarioMapper;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.repository.UsuarioRepository;
import com.BancoDeSangue.service.UsuariosPorEstadoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuariosPorEstadoServiceImpl implements UsuariosPorEstadoService {

	private final UsuarioRepository usuarioRepository;

	private final UsuarioMapper usuarioMapper;

	@Override
	public List<UsuarioResponse> obter(ObterTodosUsuariosPorEstadoRequest request) {
		List<Usuario> usuarios = usuarioRepository.findByEstado(request.getEstado());
		return usuarioMapper.toResponse(usuarios);
	}
}
