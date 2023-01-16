package com.BancoDeSangue.service.impl;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.model.InformacoesPessoais;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.service.ImcService;

@Service
public class ImcServiceImpl implements ImcService {
	@Override
	public Usuario preencher(Usuario usuario){
		InformacoesPessoais informacoesPessoais = usuario.getInformacoesPessoais();
		double imc = calcular(informacoesPessoais.getPeso(), informacoesPessoais.getAltura());
		usuario.setImc(imc);
		usuario.setObeso(isObeso(imc));
		return usuario;
	}

	private double calcular(Double peso, Double altura) {
		return peso / Math.pow(altura, 2);
	}

	private boolean isObeso(double imc) {
		return imc > 30;
	}
}
