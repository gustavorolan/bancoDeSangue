package com.bancoDeSangue.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioAutenticadoService {
    private final UsuarioRepository usuarioRepository;

    public Usuario obter(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioSecurity usuarioSecurity = (UsuarioSecurity) authentication.getPrincipal();
        return  usuarioRepository.findById(usuarioSecurity.getId()).get();
    }


}
