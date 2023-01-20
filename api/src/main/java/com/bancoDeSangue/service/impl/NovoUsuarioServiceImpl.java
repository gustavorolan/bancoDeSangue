package com.bancoDeSangue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bancoDeSangue.dtos.request.CriarNovoUsuarioRequest;
import com.bancoDeSangue.mapper.UsuarioMapper;
import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.repository.UsuarioRepository;
import com.bancoDeSangue.service.DoarService;
import com.bancoDeSangue.service.IdadeService;
import com.bancoDeSangue.service.NovoUsuarioService;
import com.bancoDeSangue.service.ImcService;
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

		String passwordEncoded = passwordEncoder(request.getSenha());

		request.setSenha(passwordEncoded);

		Usuario usuario = usuarioMapper.toEntity(request);

		Usuario usuarioComIdade = idadeService.preencher(usuario);

		Usuario usuarioComImc = imcService.preencher(usuarioComIdade);

		Usuario usuarioComIsPermitidoDoar = doarService.preencher(usuarioComImc);

		Usuario save = usuarioRepository.save(usuarioComIsPermitidoDoar);

		return save.getId();
	}

	private String passwordEncoder(String senha) {
		String senhaGenerica = passwordEncoder.encode("123456");
		return senha == null ? senhaGenerica : passwordEncoder.encode(senha);
	}

	@Override
	public List<Long> criar(List<CriarNovoUsuarioRequest> request) {
		return request.stream()
				.map(this::criar)
				.collect(Collectors.toList());
	}
}