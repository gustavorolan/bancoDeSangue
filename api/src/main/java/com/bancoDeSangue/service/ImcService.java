package com.BancoDeSangue.service.imc;

public interface ImcService {
	double calcular(String peso, String altura);

	boolean isObeso(String peso, String altura);
}
