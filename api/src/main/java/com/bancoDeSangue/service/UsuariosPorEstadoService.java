package com.BancoDeSangue.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.BancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.BancoDeSangue.dtos.response.UsuarioResponse;

public interface UsuariosPorEstadoService {
	 Page<List<UsuarioResponse>> obter(ObterTodosUsuariosPorEstadoRequest request);
}
