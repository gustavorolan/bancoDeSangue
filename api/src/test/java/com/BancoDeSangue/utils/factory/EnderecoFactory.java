package com.BancoDeSangue.utils.factory;

import com.BancoDeSangue.model.Endereco;
import com.BancoDeSangue.model.Estado;
import com.BancoDeSangue.model.Usuario;

public class EnderecoFactory {
	public static Endereco.EnderecoBuilder obterEnderecoBuilder(Usuario usuario){
		return Endereco.builder()
				.id(1L)
				.endereco("Rua Kurt W. Rothe")
				.cidade("Teófilo Otoni")
				.bairro("Castro Pires")
				.estado(Estado.MG)
				.usuario(usuario);
	}

	public static Endereco obterEndereco(Usuario usuario){
		return obterEnderecoBuilder(usuario).build();
	}
}
