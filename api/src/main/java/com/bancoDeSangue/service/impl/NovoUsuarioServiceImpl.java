package com.BancoDeSangue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.request.CreateNewUserRequest;
import com.BancoDeSangue.mapper.UsuarioMapper;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.repository.UsuarioRepository;
import com.BancoDeSangue.service.CriarNovoUsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CriarNovoUsuarioServiceImpl implements CriarNovoUsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Long create(CreateNewUserRequest request) {

        String passwordEncoded = passwordEncoder.encode(request.getSenha());

        request.setSenha(passwordEncoded);

        Usuario usuario = usuarioMapper.toEntity(request);
        
        usuario.getInformacoesPessoais().setUsuario(usuario);
        usuario.getEndereco().setUsuario(usuario);
        usuario.getContato().setUsuario(usuario);

        usuarioRepository.save(usuario);

        return usuario.getId();
    }

    @Override
    public List<Long> create(List<CreateNewUserRequest> request) {
        return request.stream().map(this::create).collect(Collectors.toList());
    }
}