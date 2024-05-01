package com.api.rinhabackend2023spring.controller.dto;

import com.api.rinhabackend2023spring.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record PessoaDto(
        UUID id,
        @NotBlank
        @Size(max = 32)
        String apelido,
        @NotBlank
        @Size(max = 100)
        String nome,
        @NotNull
        @PastOrPresent
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt_BR")
        LocalDate nascimento,
        List<@NotBlank @Size(max = 32) String> stack
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
        model.setStack(this.stack);
        return model;
    }

}
