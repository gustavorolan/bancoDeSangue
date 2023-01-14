package com.BancoDeSangue.dtos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class CreateNewUserRequest {
    @NotEmpty
    private String nome;

    @Email
    private String email;

    @NotEmpty
    private String  senha = "123456";

    @NotBlank
    @Size(max = 11, min = 14)
    private String Cpf;

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

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

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