package com.BancoDeSangue.utils.factory;

import com.BancoDeSangue.model.InformacoesPessoais;
import com.BancoDeSangue.model.Sexo;
import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.model.Usuario;

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
}
