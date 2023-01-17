package com.BancoDeSangue.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
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

		Usuario usuario = Usuario.builder()
				.nome(request.getNome())
				.email(request.getEmail())
				.senha(request.getSenha())
				.permissaoList(List.of())
				.informacoesPessoais(informacoesPessoais)
				.endereco(endereco)
				.contato(contato)
				.idade(0)
				.imc(0)
				.isObeso(false)
				.isPermitidoDoar(false)
				.build();

		informacoesPessoais.setUsuario(usuario);
		endereco.setUsuario(usuario);
		contato.setUsuario(usuario);

		return usuario;
	}

	private Contato contactToEntity(CriarNovoUsuarioRequest request) {
		return Contato.builder()
				.telefone_fixo(request.getTelefone_fixo())
				.celular(request.getCelular())
				.build();
	}

	private Endereco addressToEntity(CriarNovoUsuarioRequest request) {
		return Endereco.builder()
				.endereco(request.getEndereco())
				.bairro(request.getBairro())
				.cidade(request.getCidade())
				.estado(request.getEstado())
				.numero(request.getNumero())
				.build();
	}

	private InformacoesPessoais personalInfoToEntity(CriarNovoUsuarioRequest request) {
		return InformacoesPessoais.builder()
				.mae(request.getMae())
				.pai(request.getPai())
				.Cpf(request.getCpf())
				.rg(request.getRg())
				.data_nasc(request.getData_nasc())
				.sexo(Sexo.obter(request.getSexo()))
				.altura(Double.parseDouble(request.getAltura()))
				.peso(Double.parseDouble(request.getPeso()))
				.tipoSanguineo(TipoSanguineo.obter(request.getTipo_sanguineo()))
				.build();
	}

	public List<UsuarioResponse> toResponse(Page<Usuario> usuarios) {
		return usuarios.stream()
				.map(this::toResponse)
				.collect(Collectors.toList());
	}

	public UsuarioResponse toResponse(Usuario entity) {
		ContatoResponse contatoResponse = contatoToResponse(entity);
		InformacoesPessoaisResponse informacoesPessoaisResponse = informacoesPessoaisToResponse(entity);
		EnderecoResponse enderecoResponse = enderecoToResponse(entity);
		return UsuarioResponse.builder()
				.nome(entity.getNome())
				.email(entity.getEmail())
				.contato(contatoResponse)
				.enderecoResponse(enderecoResponse)
				.informacoesPessoaisResponse(informacoesPessoaisResponse)
				.isObeso(entity.isObeso())
				.isPermitidoDoar(entity.isPermitidoDoar())
				.build();
	}

	private ContatoResponse contatoToResponse(Usuario entity) {
		Contato contato = entity.getContato();
		return ContatoResponse.builder()
				.celular(contato.getCelular())
				.telefone(contato.getTelefone_fixo())
				.build();
	}

	private EnderecoResponse enderecoToResponse(Usuario entity) {
		Endereco endereco = entity.getEndereco();
		return EnderecoResponse.builder()
				.cidade(endereco.getCidade())
				.estado(endereco.getEstado())
				.build();
	}

	private InformacoesPessoaisResponse informacoesPessoaisToResponse(Usuario entity) {
		InformacoesPessoais informacoesPessoais = entity.getInformacoesPessoais();

		return InformacoesPessoaisResponse.builder()
				.sexo(informacoesPessoais.getSexo())
				.tipoSanguineo(informacoesPessoais.getTipoSanguineo())
				.build();
	}
}
