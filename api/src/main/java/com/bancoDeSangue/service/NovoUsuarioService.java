package com.bancoDeSangue.service;

import java.util.List;

import com.bancoDeSangue.dtos.request.CriarNovoUsuarioRequest;

public interface NovoUsuarioService {
	Long criar(CriarNovoUsuarioRequest request);
	List<Long> criar(List<CriarNovoUsuarioRequest> request);
}
