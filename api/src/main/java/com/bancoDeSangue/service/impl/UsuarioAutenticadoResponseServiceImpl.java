package com.bancoDeSangue.service.impl;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.response.UsuarioResponse;
import com.bancoDeSangue.mapper.UsuarioMapper;
import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.security.service.UsuarioAutenticadoService;
import com.bancoDeSangue.service.UsuarioAutenticadoResponseService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioAutenticadoResponseServiceImpl implements UsuarioAutenticadoResponseService {

	private final UsuarioAutenticadoService usuarioAutenticadoService;

	private final UsuarioMapper usuarioMapper;

	@Override
	public UsuarioResponse obter() {
		Usuario obter = usuarioAutenticadoService.obter();
		return usuarioMapper.toResponse(obter);
	}
}
