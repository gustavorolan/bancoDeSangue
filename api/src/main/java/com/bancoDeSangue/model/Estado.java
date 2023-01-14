package com.BancoDeSangue.model;

import java.util.Arrays;
import java.util.List;

public enum Estados {
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

	Estados(String nome) {
		this.nome = nome;
	}

	static List<TipoSanguineo> obterLitaDeEstados(){
		return Arrays.asList(TipoSanguineo.values());
	}
}
