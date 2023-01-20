package com.bancoDeSangue.dtos.response;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UsuarioResponse {
	private String nome;
	private String email;
	private ContatoResponse contato;
	private EnderecoResponse enderecoResponse;
	private InformacoesPessoaisResponse informacoesPessoaisResponse;
	private boolean isObeso;
	private boolean isPermitidoDoar;
}
