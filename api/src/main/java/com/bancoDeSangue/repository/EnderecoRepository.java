package com.BancoDeSangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BancoDeSangue.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
