package com.BancoDeSangue.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String  senha;

    @OneToMany(fetch = FetchType.EAGER )
    @JoinColumn(name = "userIdPermission")
    private List<Permissao> permissaoList;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private InformacoesPessoais informacoesPessoais;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Contato contato;

    private int idade = 0;

    private double imc = 0;

    private boolean isObeso=false;

    private boolean isPermitidoDoar=false;
}
