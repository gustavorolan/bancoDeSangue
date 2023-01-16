package com.BancoDeSangue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.request.CriarNovoUsuarioRequest;
import com.BancoDeSangue.mapper.UsuarioMapper;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.repository.UsuarioRepository;
import com.BancoDeSangue.service.DoarService;
import com.BancoDeSangue.service.IdadeService;
import com.BancoDeSangue.service.NovoUsuarioService;
import com.BancoDeSangue.service.ImcService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NovoUsuarioServiceImpl implements NovoUsuarioService {

	private final UsuarioMapper usuarioMapper;
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;
	private final IdadeService idadeService;

	private final DoarService doarService;
	private final ImcService imcService;

	public Long criar(CriarNovoUsuarioRequest request) {

		String passwordEncoded = passwordEncoder.encode(request.getSenha());

		request.setSenha(passwordEncoded);

		Usuario usuario = usuarioMapper.toEntity(request);

		Usuario usuarioComIdade = idadeService.preencher(usuario);

		Usuario usuarioComImc = imcService.preencher(usuarioComIdade);

		Usuario usuarioComIsPermitidoDoar = doarService.preencher(usuarioComImc);

		usuarioRepository.save(usuarioComIsPermitidoDoar);

		return usuario.getId();
	}


	@Override
	public List<Long> criar(List<CriarNovoUsuarioRequest> request) {
		return request.stream()
				.map(this::criar)
				.collect(Collectors.toList());
	}
}