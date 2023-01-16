package com.BancoDeSangue.service.impl;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.response.UsuarioResponse;
import com.BancoDeSangue.mapper.UsuarioMapper;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.security.service.UsuarioAutenticadoService;
import com.BancoDeSangue.service.UsuarioAutenticadoResponseService;
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
