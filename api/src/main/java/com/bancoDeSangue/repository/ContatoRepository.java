package com.bancoDeSangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoDeSangue.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
