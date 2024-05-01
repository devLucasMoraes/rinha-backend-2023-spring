package com.api.rinhabackend2023spring.service.impl;

import com.api.rinhabackend2023spring.model.Pessoa;
import com.api.rinhabackend2023spring.repository.PessoaRepository;
import com.api.rinhabackend2023spring.service.PessoaService;
import com.api.rinhabackend2023spring.service.exception.NotFoundException;
import com.api.rinhabackend2023spring.service.exception.UnprocessableEntityException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public Pessoa create(Pessoa pessoaToCreate) {
        if(pessoaRepository.existsByApelido(pessoaToCreate.getApelido())) {
            throw new UnprocessableEntityException("Apelido '%s' já está em uso.".formatted(pessoaToCreate.getApelido()));
        }

        return pessoaRepository.save(pessoaToCreate);
    }

    @Override
    public Pessoa findById(UUID id) {
        return this.pessoaRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Pessoa> findAllBySearchTerm(String searchTerm) {
        return pessoaRepository.findAllBySearchTerm(searchTerm);
    }

    @Override
    public Long countPeople() {
        return pessoaRepository.count();
    }
}
