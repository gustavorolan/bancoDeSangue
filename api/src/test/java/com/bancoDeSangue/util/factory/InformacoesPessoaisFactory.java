package com.bancoDeSangue.util.factory;

import com.bancoDeSangue.dtos.response.InformacoesPessoaisResponse;
import com.bancoDeSangue.model.InformacoesPessoais;
import com.bancoDeSangue.model.Sexo;
import com.bancoDeSangue.model.TipoSanguineo;
import com.bancoDeSangue.model.Usuario;

public class InformacoesPessoaisFactory {
	public static InformacoesPessoais.InformacoesPessoaisBuilder obterInformacoesPessoaisBuilder(Usuario usuario){
		return InformacoesPessoais.builder()
				.id(1L)
				.mae("Isadora Marli")
				.pai("Noah Severino César Pires")
				.Cpf("775.256.099-50")
				.rg( "44.084.541-5")
				.data_nasc("23/05/1964")
				.sexo(Sexo.F)
				.altura(1.53)
				.usuario(usuario)
				.peso(80.0)
				.tipoSanguineo(TipoSanguineo.O_NEGATIVO);
	}

	public static InformacoesPessoais obterInformacoesPessoais(Usuario usuario){
		return obterInformacoesPessoaisBuilder(usuario).build();
	}

	public static InformacoesPessoaisResponse obterInformacoesPessoaisResponse(Usuario usuario){
		InformacoesPessoais informacoesPessoais = obterInformacoesPessoais(usuario);
		return InformacoesPessoaisResponse.builder()
				.sexo(informacoesPessoais.getSexo())
				.tipoSanguineo(informacoesPessoais.getTipoSanguineo().getSigla())
				.build();
	}

}
