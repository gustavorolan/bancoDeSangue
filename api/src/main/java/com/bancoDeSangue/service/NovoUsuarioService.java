package com.BancoDeSangue.service;

import java.util.List;

import com.BancoDeSangue.dtos.request.CriarNovoUsuarioRequest;

public interface NovoUsuarioService {
	Long criar(CriarNovoUsuarioRequest request);
	List<Long> criar(List<CriarNovoUsuarioRequest> request);
}
