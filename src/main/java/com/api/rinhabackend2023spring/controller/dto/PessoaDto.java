package com.api.rinhabackend2023spring.controller.dto;

import com.api.rinhabackend2023spring.model.Pessoa;

import java.time.LocalDate;
import java.util.List;

public record PessoaDto(
        String id,
        String apelido,
        String nome,
        LocalDate nascimento,
        List<String> stack
) {
    public PessoaDto(Pessoa model) {
        this(
                model.getId(),
                model.getApelido(),
                model.getNome(),
                model.getNascimento(),
                model.getStack()
        );
    }
    public Pessoa toModel() {
        Pessoa model = new Pessoa();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setApelido(this.apelido);
        model.setNascimento(this.nascimento);

        return model;
    }

}
