package com.BancoDeSangue.mapper;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.dtos.request.CreateNewUserRequest;
import com.BancoDeSangue.model.Endereco;
import com.BancoDeSangue.model.Contato;
import com.BancoDeSangue.model.InformacoesPessoais;
import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.model.Usuario;

@Service
public class UserAccountMapper {
	Usuario toEntity(CreateNewUserRequest request){
		InformacoesPessoais informacoesPessoais = personalInfoToEntity(request);
		Endereco endereco = addressToEntity(request);
		Contato contato = contactToEntity(request);

		Usuario usuario = new Usuario(
				null,
				request.getNome(),
				request.getEmail(),
				request.getSenha(),
				null, informacoesPessoais, endereco, contato);

		informacoesPessoais.setUsuario(usuario);
		endereco.setUsuario(usuario);
		contato.setUsuario(usuario);

		return usuario;
	}

	private Contato contactToEntity(CreateNewUserRequest request) {
		return new Contato(
				null,
				null,
				request.getTelefone_fixo(),
				request.getCelular()
		);
	}

	private Endereco addressToEntity(CreateNewUserRequest request) {
		return new Endereco(
				null,
				request.getEndereco(),
				request.getBairro(),
				request.getCidade(),
				request.getEstado(),
				null
		) ;
	}

	private InformacoesPessoais personalInfoToEntity(CreateNewUserRequest request) {
		return new InformacoesPessoais(
				null,
				null,
				request.getMae(),
				request.getPai(),
				request.getCpf(),
				request.getData_nasc(),
				request.getSexo(),
				request.getAltura(),
				request.getPeso(),
				TipoSanguineo.obter(request.getTipo_sanguineo())
		);
	}
}
