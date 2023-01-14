package com.BancoDeSangue.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.request.CreateNewUserRequest;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CriarNovoUsuarioService {
    private final UserAccountRepository userAccountRepository;

    private final PasswordEncoder passwordEncoder;

    public Long create(CreateNewUserRequest request) {

        String passwordEncoded = passwordEncoder.encode(request.getSenha());
        Usuario usuario = Usuario.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoded)
                .build();

        userAccountRepository.save(usuario);

        return usuario.getId();
    }
}