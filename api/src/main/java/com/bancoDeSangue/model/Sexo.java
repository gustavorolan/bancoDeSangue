package com.bancoDeSangue.model;

import java.util.Arrays;
import java.util.HashMap;

public enum Sexo {
	F("Feminino"), M("Masculino");

	private final String descricao;

	Sexo(String descricao) {
		this.descricao=descricao;
	}

	public static Sexo obter(String descricao){
		HashMap<String, Sexo> lista = obterLista();
		return lista.get(descricao);
	}

	public static HashMap<String, Sexo> obterLista(){
		HashMap<String, Sexo> lista = new HashMap<>();
		Arrays.stream(Sexo.values())
				.forEach(sexo ->
						lista.put(sexo.descricao, sexo)
				);
		return lista;
	}

	public String getDescricao(){
		return this.descricao;
	}
}
