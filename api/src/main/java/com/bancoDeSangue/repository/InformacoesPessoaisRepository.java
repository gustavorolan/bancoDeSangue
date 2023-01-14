package com.BancoDeSangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BancoDeSangue.model.Contato;
import com.BancoDeSangue.model.Usuario;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {}