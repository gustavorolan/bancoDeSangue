package com.BancoDeSangue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BancoDeSangue.model.Usuario;

@Repository
public interface UserAccountRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
