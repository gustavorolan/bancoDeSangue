package com.bancoDeSangue.util.factory;

import java.util.List;

import com.bancoDeSangue.dtos.request.CriarNovoUsuarioRequest;
import com.bancoDeSangue.dtos.response.ContatoResponse;
import com.bancoDeSangue.dtos.response.EnderecoResponse;
import com.bancoDeSangue.dtos.response.InformacoesPessoaisResponse;
import com.bancoDeSangue.dtos.response.UsuarioResponse;
import com.bancoDeSangue.model.Contato;
import com.bancoDeSangue.model.Endereco;
import com.bancoDeSangue.model.Estado;
import com.bancoDeSangue.model.InformacoesPessoais;
import com.bancoDeSangue.model.Usuario;

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
				.imc(34.17488999957281)
				.isPermitidoDoar(true)
				.isObeso(true);

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

	public static UsuarioResponse obterUsuarioResponse(){
		Usuario usuario = obterUsuario();
		EnderecoResponse enderecoResponse = EnderecoFactory.obterEnderecoResponse(usuario);
		ContatoResponse contatoResponse = ContatoFactory.obterContatoResponse(usuario);
		InformacoesPessoaisResponse informacoesPessoaisResponse = InformacoesPessoaisFactory.obterInformacoesPessoaisResponse(usuario);
		return UsuarioResponse.builder()
				.nome(usuario.getNome())
				.email(usuario.getEmail())
				.isObeso(usuario.isObeso())
				.isPermitidoDoar(usuario.isPermitidoDoar())
				.enderecoResponse(enderecoResponse)
				.informacoesPessoaisResponse(informacoesPessoaisResponse)
				.contato(contatoResponse)
				.build();
	}
	public static CriarNovoUsuarioRequest obterCriarNovoUsuarioRequest(){
		return CriarNovoUsuarioRequest.builder()
				.nome("Milena Analu Pires")
				.Cpf("775.256.099-50")
				.rg("44.084.541-5")
				.data_nasc("23/05/1964")
				.sexo("Feminino")
				.mae("Isadora Marli")
				.pai("Noah Severino César Pires")
				.email("mmilenaanalupires@keffin.com.br")
				.cep("39801-678")
				.endereco("Rua Kurt W. Rothe")
				.numero(675)
				.bairro("Castro Pires")
				.cidade("Teófilo Otoni")
				.estado(Estado.MG)
				.celular("(33) 98481-0191")
				.altura("1.53")
				.peso("80")
				.tipo_sanguineo("O-")
				.build();
	}
}
