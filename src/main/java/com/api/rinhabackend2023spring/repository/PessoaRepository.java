package com.api.rinhabackend2023spring.repository;

import com.api.rinhabackend2023spring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {
}
