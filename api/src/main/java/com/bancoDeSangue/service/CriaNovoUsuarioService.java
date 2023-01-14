package com.BancoDeSangue.service;

import java.util.List;

import com.BancoDeSangue.dtos.request.CreateNewUserRequest;

public interface CriarNovoUsuarioService {
	Long create(CreateNewUserRequest request);
	List<Long> create(List<CreateNewUserRequest> request);
}
