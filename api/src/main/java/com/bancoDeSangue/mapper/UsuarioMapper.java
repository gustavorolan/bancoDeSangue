package com.BancoDeSangue.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.request.CriarNovoUsuarioRequest;
import com.BancoDeSangue.dtos.response.ContatoResponse;
import com.BancoDeSangue.dtos.response.EnderecoResponse;
import com.BancoDeSangue.dtos.response.InformacoesPessoaisResponse;
import com.BancoDeSangue.dtos.response.UsuarioResponse;
import com.BancoDeSangue.model.Endereco;
import com.BancoDeSangue.model.Contato;
import com.BancoDeSangue.model.InformacoesPessoais;
import com.BancoDeSangue.model.Sexo;
import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.model.Usuario;

@Service
public class UsuarioMapper {
	public Usuario toEntity(CriarNovoUsuarioRequest request) {
		InformacoesPessoais informacoesPessoais = personalInfoToEntity(request);
		Endereco endereco = addressToEntity(request);
		Contato contato = contactToEntity(request);

		Usuario usuario = new Usuario(null, request.getNome(), request.getEmail(), request.getSenha(), null, informacoesPessoais, endereco, contato, 0, 0, false, false);

		informacoesPessoais.setUsuario(usuario);
		endereco.setUsuario(usuario);
		contato.setUsuario(usuario);

		return usuario;
	}

	private Contato contactToEntity(CriarNovoUsuarioRequest request) {
		return new Contato(null, null, request.getTelefone_fixo(), request.getCelular());
	}

	private Endereco addressToEntity(CriarNovoUsuarioRequest request) {
		return new Endereco(null, request.getEndereco(), request.getBairro(), request.getCidade(), request.getEstado(), null);
	}

	private InformacoesPessoais personalInfoToEntity(CriarNovoUsuarioRequest request) {
		return new InformacoesPessoais(null, null, request.getMae(), request.getPai(), request.getCpf(), request.getRg(), request.getData_nasc(), Sexo.obter(request.getSexo()), Double.parseDouble(request.getAltura()), Double.parseDouble(request.getPeso()), TipoSanguineo.obter(request.getTipo_sanguineo()));
	}

	public List<UsuarioResponse> toResponse(List<Usuario> usuarios) {
		return usuarios.stream()
				.map(this::toResponse)
				.collect(Collectors.toList());
	}

	public UsuarioResponse toResponse(Usuario entity) {
		ContatoResponse contatoResponse = contatoToResponse(entity);
		InformacoesPessoaisResponse informacoesPessoaisResponse = informacoesPessoaisToResponse(entity);
		EnderecoResponse enderecoResponse = enderecoToResponse(entity);
		return new UsuarioResponse(entity.getNome(), entity.getEmail(), contatoResponse, enderecoResponse, informacoesPessoaisResponse, entity.isObeso(), entity.isPermitidoDoar());
	}

	private ContatoResponse contatoToResponse(Usuario entity) {
		Contato contato = entity.getContato();
		return new ContatoResponse(contato.getCelular(), contato.getTelefone_fixo());
	}

	private EnderecoResponse enderecoToResponse(Usuario entity) {
		Endereco endereco = entity.getEndereco();
		return new EnderecoResponse(endereco.getCidade(), endereco.getEstado());
	}

	private InformacoesPessoaisResponse informacoesPessoaisToResponse(Usuario entity) {
		InformacoesPessoais informacoesPessoais = entity.getInformacoesPessoais();
		return new InformacoesPessoaisResponse(informacoesPessoais.getSexo(), informacoesPessoais.getTipoSanguineo());
	}
}
