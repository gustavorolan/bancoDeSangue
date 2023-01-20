package com.bancoDeSangue.service.impl;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.bancoDeSangue.dtos.response.UsuarioResponse;
import com.bancoDeSangue.mapper.UsuarioMapper;
import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.UsuariosPorEstadoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuariosPorEstadoServiceImpl implements UsuariosPorEstadoService {

	private final Integer quantidadePageAble = 10;

	private final UsuarioRepository usuarioRepository;

	private final UsuarioMapper usuarioMapper;

	@Override
	public Page<List<UsuarioResponse>> obter(ObterTodosUsuariosPorEstadoRequest request) {
		PageRequest pagRequest = PageRequest.of(request.getPagina(), quantidadePageAble);
		Page<Usuario> usuarios = usuarioRepository.findByEstado(request.getEstado(), pagRequest);


		return usuarios.map(usuario -> usuarioMapper.toResponse(usuarios));
	}
}
