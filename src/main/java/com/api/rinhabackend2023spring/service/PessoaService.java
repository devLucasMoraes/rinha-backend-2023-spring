package com.api.rinhabackend2023spring.service;

import com.api.rinhabackend2023spring.model.Pessoa;

import java.util.List;
import java.util.UUID;

public interface PessoaService {
    Pessoa create(Pessoa pessoa);
    Pessoa findById(UUID id);
    List<Pessoa> findAllBySearchTerm(String searchTerm);
    Long countPeople();
}
