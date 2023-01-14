package com.BancoDeSangue.service.imc.impl;

import com.BancoDeSangue.service.imc.ImcService;

public class ImcServiceImpl implements ImcService {
	@Override
	public double calcular(String peso, String altura) {
		return Double.parseDouble(peso) / Math.pow(Double.parseDouble(altura), 2);
	}

	@Override
	public boolean isObeso(String peso, String altura) {
		double imc = calcular(peso, altura);
		return imc > 30;
	}
}
