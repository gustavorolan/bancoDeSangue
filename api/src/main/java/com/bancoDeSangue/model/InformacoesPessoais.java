package com.BancoDeSangue.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class InformacoesPessoais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userAccount")
	@JsonIgnore
	private Usuario usuario;

	@Column(nullable = false)
	private String mae;

	@Column(nullable = false)
	private String pai;

	@Column(nullable = false)
	private String Cpf;

	@Column(nullable = false)
	private String rg;

	@Column(nullable = false)
	private String data_nasc;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(nullable = false)
	private Double altura;

	@Column(nullable = false)
	private Double peso;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipoSanguineo;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		InformacoesPessoais that = (InformacoesPessoais) o;
		return id != null && Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
