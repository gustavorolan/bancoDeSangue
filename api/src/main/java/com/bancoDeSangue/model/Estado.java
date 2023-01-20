package com.bancoDeSangue.model;

import java.util.Arrays;
import java.util.List;

public enum Estado {
	AC("Acre"),

	AL("Alagoas"),

	AP("Amapá"),

	AM("Amazonas"),

	BA("Bahia"),

	CE("Ceará"),

	ES("Espírito Santo"),

	GO("Goiás"),

	MA("Maranhão"),

	MT("Mato Grosso"),

	MS("Mato Grosso do Sul"),

	MG("Minas Gerais"),

	PA("Pará"), PB("Paraíba"),

	PR("Paraná"),

	PE("Pernambuco"),

	PI("Piauí"),

	RJ("Rio de Janeiro"),

	RN("Rio Grande do Norte"),

	RS("Rio Grande do Sul"),

	RO("Rondônia"),

	RR("Roraima"),

	SC("Santa Catarina"),

	SP("São Paulo"),

	SE("Sergipe"),

	TO("Tocantins"),

	DF("Distrito Federal");

	private String nome;

	Estado(String nome) {
		this.nome = nome;
	}

	public static List<Estado> obterLitaDeEstados(){
		return Arrays.asList(Estado.values());
	}

	public String getNome() {
		return nome;
	}
}
