package com.bancoDeSangue.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.bancoDeSangue.dtos.response.UsuarioResponse;

public interface UsuariosPorEstadoService {
	 Page<List<UsuarioResponse>> obter(ObterTodosUsuariosPorEstadoRequest request);
}
