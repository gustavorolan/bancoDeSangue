package com.bancoDeSangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancoDeSangue.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
