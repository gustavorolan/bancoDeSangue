package com.BancoDeSangue.utils.factory;

import java.util.List;

import com.BancoDeSangue.model.Contato;
import com.BancoDeSangue.model.Endereco;
import com.BancoDeSangue.model.InformacoesPessoais;
import com.BancoDeSangue.model.Usuario;

public class UsuarioFactory {
	public static Usuario.UsuarioBuilder obterUsuarioBuilder(InformacoesPessoais informacoesPessoais, Endereco endereco, Contato contato) {
		return Usuario.builder()
				.id(1L)
				.nome("Milena Analu Pires")
				.email("mmilenaanalupires@keffin.com.br")
				.senha("123456")
				.permissaoList(List.of())
				.informacoesPessoais(informacoesPessoais)
				.contato(contato)
				.endereco(endereco)
				.idade(64)
				.imc(34.17)
				.permitidoDoar(true)
				.obeso(true);

	}

	public static Usuario obterUsuario(InformacoesPessoais informacoesPessoais, Endereco endereco, Contato contato) {
		return obterUsuarioBuilder(informacoesPessoais, endereco, contato).build();
	}

	public static Usuario obterUsuario() {
		Usuario usuario = obterUsuarioBuilder(null, null, null).build();
		InformacoesPessoais informacoesPessoais = InformacoesPessoaisFactory.obterInformacoesPessoais(usuario);
		Contato contato = ContatoFactory.obterContato(usuario);
		Endereco endereco = EnderecoFactory.obterEndereco(usuario);
		usuario.setInformacoesPessoais(informacoesPessoais);
		usuario.setContato(contato);
		usuario.setEndereco(endereco);
		return usuario;
	}
}
