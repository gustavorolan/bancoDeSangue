package com.BancoDeSangue.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
	private String nome;
	private String email;
	private ContatoResponse contato;
	private EnderecoResponse enderecoResponse;
	private InformacoesPessoaisResponse informacoesPessoaisResponse;
	private boolean isObeso;
	private boolean isPermitidoDoar;
}
