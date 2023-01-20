package com.bancoDeSangue.security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bancoDeSangue.model.Usuario;

public class UsuarioSecurity implements UserDetails {
    private  Long id;
    private  String password;
    private  String email;
    private List<SimpleGrantedAuthority> permissions;

    public UsuarioSecurity(Usuario user){
        this.id= user.getId();
        this.email=user.getEmail();
        this.password= user.getSenha();
        this.permissions = user.getPermissaoList()
                .stream()
                .map(permission -> new SimpleGrantedAuthority("ROLE_"+ permission.getPermissionName()))
                .collect(Collectors.toList());
    }

    public Long getId (){
        return this.id;
    }
    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return this.permissions;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
