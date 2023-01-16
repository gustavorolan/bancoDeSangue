package com.BancoDeSangue.service;

import java.util.List;

import com.BancoDeSangue.dtos.request.ObterTodosUsuariosPorEstadoRequest;
import com.BancoDeSangue.dtos.response.UsuarioResponse;

public interface UsuariosPorEstadoService {
	 List<UsuarioResponse> obter(ObterTodosUsuariosPorEstadoRequest request);
}
