package com.BancoDeSangue.util.factory;

import com.BancoDeSangue.dtos.response.ContatoResponse;
import com.BancoDeSangue.model.Contato;
import com.BancoDeSangue.model.Usuario;

public class ContatoFactory {
	public static Contato.ContatoBuilder obterContatoBuilder(Usuario usuario) {
		return Contato.builder()
				.id(1L)
				.usuario(usuario)
				.telefone_fixo("(33) 3611-4613")
				.celular("(33) 98481-0191");
	}

	public static Contato obterContato(Usuario usuario) {
		return obterContatoBuilder(usuario).build();
	}

	public static ContatoResponse obterContatoResponse(Usuario usuario) {
		Contato contato = obterContato(usuario);
		return ContatoResponse.builder()
				.telefone(contato.getTelefone_fixo())
				.celular(contato.getCelular())
				.build();
	}

}
