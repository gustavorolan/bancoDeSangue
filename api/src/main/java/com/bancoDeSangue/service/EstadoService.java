package com.bancoDeSangue.service;

import java.util.List;

import com.bancoDeSangue.dtos.response.EstadoResponse;
import com.bancoDeSangue.dtos.response.NumeroDeDoadoresPorEstadoResponse;

public interface EstadoService {
	List<EstadoResponse> obter();

	List<NumeroDeDoadoresPorEstadoResponse> numeroDeDoadores();
}
