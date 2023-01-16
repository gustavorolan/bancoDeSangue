package com.BancoDeSangue.service.impl;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.service.DoarService;

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
