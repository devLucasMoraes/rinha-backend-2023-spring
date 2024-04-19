package com.api.rinhabackend2023spring.controller;

import com.api.rinhabackend2023spring.controller.dto.PessoaDto;
import com.api.rinhabackend2023spring.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/")
@CrossOrigin
public record PessoaController(PessoaService pessoaService) {

    @PostMapping("pessoas")
    public ResponseEntity<PessoaDto> create(@RequestBody @Valid PessoaDto pessoaDto) {
        var pessoa = pessoaService.create(pessoaDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(location).body(new PessoaDto(pessoa));
    }
}
