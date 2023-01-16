package com.BancoDeSangue.dtos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.BancoDeSangue.model.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarNovoUsuarioRequest {
    @NotEmpty
    private String nome;

    @Email
    private String email;

    @NotEmpty
    private String  senha = "123456";

    @NotBlank
    private String Cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String data_nasc;

    @NotBlank
    private String sexo;

    @NotBlank
    private String mae;

    @NotBlank
    private String pai;

    @NotBlank
    private String cep;

    @NotBlank
    private String endereco;

    @NotNull
    private Integer numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotNull
    private Estado estado;

    @NotBlank
    private String telefone_fixo;

    @NotBlank
    private String celular;

    @NotBlank
    private String altura;

    @NotBlank
    private String peso;

    @NotBlank
    private String tipo_sanguineo;

}