package com.bancoDeSangue.util.factory;

import com.bancoDeSangue.dtos.response.EnderecoResponse;
import com.bancoDeSangue.model.Endereco;
import com.bancoDeSangue.model.Estado;
import com.bancoDeSangue.model.Usuario;

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

	public static EnderecoResponse obterEnderecoResponse(Usuario usuario){
		Endereco endereco = obterEndereco(usuario);
		return EnderecoResponse.builder()
				.estado(endereco.getEstado())
				.cidade(endereco.getCidade())
				.build();
	}

}
