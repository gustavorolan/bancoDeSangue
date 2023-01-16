package com.BancoDeSangue.service;

import java.util.List;

import com.BancoDeSangue.dtos.response.EstadoResponse;
import com.BancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;

public interface EstadoService {
	List<EstadoResponse> obter();

	List<NumeroDeDoadoresPorEstadoResponse> numeroDeDoadores();
}
