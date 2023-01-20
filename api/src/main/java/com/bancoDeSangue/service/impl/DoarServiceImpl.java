package com.bancoDeSangue.service.impl;

import org.springframework.stereotype.Service;

import com.bancoDeSangue.model.Usuario;
import com.bancoDeSangue.service.DoarService;

@Service
public class DoarServiceImpl implements DoarService {
	@Override
	public Usuario preencher(Usuario usuario) {
		boolean isDoar = (usuario.getIdade() <= 69 && usuario.getIdade() >= 16) && (usuario.getInformacoesPessoais()
				.getPeso() > 50);
		usuario.setPermitidoDoar(isDoar);
		return usuario ;
	}
}
