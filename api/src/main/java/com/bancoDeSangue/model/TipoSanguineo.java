package com.BancoDeSangue.model;

import java.util.Arrays;
import java.util.HashMap;

public enum TipoSanguineo {
	A_POSITIVO("A+"),
	A_NEGATIVO("A-"),
	B_POSITIVO("B+"),
	B_NEGATIVO("B-"),
	A_B_POSITIVO("AB+"),
	A_B_NEGATIVO("AB-"),
	O_POSITIVO("O+"),
	O_NEGATIVO("O-");

	private final String sigla;
	TipoSanguineo(String sigla) {
		this.sigla = sigla;
	}

	public static TipoSanguineo obter(String sigla){
		HashMap<String, TipoSanguineo> tiposSanguineos = obterLitaDeTiposSanguineos();
		return tiposSanguineos.get(sigla);
	}

	public static HashMap<String, TipoSanguineo> obterLitaDeTiposSanguineos(){
		HashMap<String, TipoSanguineo> tipoSanguineos = new HashMap<>();
		 Arrays.stream(TipoSanguineo.values())
				 .forEach(tipoSanguineo ->
						 tipoSanguineos.put(tipoSanguineo.sigla,tipoSanguineo)
				 );
		return tipoSanguineos;
	}

	public String getSigla() {
		return sigla;
	}
}
