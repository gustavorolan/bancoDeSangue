package com.bancoDeSangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoDeSangue.model.InformacoesPessoais;

@Repository
public interface InformacoesPessoaisRepository extends JpaRepository<InformacoesPessoais, Long> {

}
