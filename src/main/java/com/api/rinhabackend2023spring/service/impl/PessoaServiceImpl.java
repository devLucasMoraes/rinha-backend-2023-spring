package com.api.rinhabackend2023spring.service.impl;

import com.api.rinhabackend2023spring.model.Pessoa;
import com.api.rinhabackend2023spring.service.PessoaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Override
    public Pessoa create(Pessoa pessoa) {
        //to do
        return null;
    }

    @Override
    public Pessoa findById(UUID id) {
        //to do
        return null;
    }

    @Override
    public List<Pessoa> findAllBySearchTerm(String searchTerm) {
        //to do
        return List.of();
    }

    @Override
    public Long countPeople() {
        //to do
        return 0L;
    }
}
