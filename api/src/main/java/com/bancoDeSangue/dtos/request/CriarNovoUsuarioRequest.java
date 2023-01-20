package com.bancoDeSangue.dtos.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bancoDeSangue.model.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CriarNovoUsuarioRequest {
    @NotEmpty(message = "Nome deve ser preenchido")
    private String nome;

    @Email(message = "Email deve ser preenchido")
    private String email;

    private String  senha;

    @NotBlank(message = "Cpf deve ser preenchido")
    private String Cpf;

    @NotBlank(message = "Rg deve ser preenchido")
    private String rg;

    @NotBlank(message = "Data nascimento deve ser preenchido")
    private String data_nasc;

    @NotBlank(message = "Sexo deve ser preenchido")
    private String sexo;

    @NotBlank(message = "Mae deve ser preenchido")
    private String mae;

    @NotBlank(message = "Pai deve ser preenchido")
    private String pai;

    @NotBlank(message = "Cep deve ser preenchido")
    private String cep;

    @NotBlank(message = "Endereco deve ser preenchido")
    private String endereco;

    @NotNull(message = "Numero deve ser preenchido")
    private Integer numero;

    @NotBlank(message = "Bairro deve ser preenchido")
    private String bairro;

    @NotBlank(message = "Cidade deve ser preenchido")
    private String cidade;

    @NotNull(message = "Estado deve ser preenchido")
    private Estado estado;

    @NotBlank(message = "Telefone fixo deve ser preenchido")
    private String telefone_fixo;

    @NotBlank(message = "Celular deve ser preenchido")
    private String celular;

    @NotBlank(message = "Altura deve ser preenchido")
    private String altura;

    @NotBlank(message = "Peso deve ser preenchido")
    private String peso;

    @NotBlank(message = "Tipo sanguineo deve ser preenchido")
    private String tipo_sanguineo;

}