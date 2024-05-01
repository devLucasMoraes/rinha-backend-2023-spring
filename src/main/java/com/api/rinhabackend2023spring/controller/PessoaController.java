package com.api.rinhabackend2023spring.controller;

import com.api.rinhabackend2023spring.controller.dto.PessoaDto;
import com.api.rinhabackend2023spring.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin
public record PessoaController(PessoaService pessoaService) {

    @PostMapping("pessoas")
    public ResponseEntity<PessoaDto> create(@RequestBody @Valid PessoaDto pessoaDto) {
        var pessoa = pessoaService.create(pessoaDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/pessoas/{id}")
                .buildAndExpand(pessoa.getId())
                .toUri();
        return ResponseEntity.created(location).body(new PessoaDto(pessoa));
    }

    @GetMapping("pessoas/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable UUID id) {
        var pessoa = pessoaService.findById(id);
        return ResponseEntity.ok(new PessoaDto(pessoa));
    }

    @GetMapping("pessoas")
    public ResponseEntity<List<PessoaDto>> findAllBySearchTerm(@RequestParam(value = "t") String searchTerm) {
        var result = pessoaService.findAllBySearchTerm(searchTerm);
        var resultDto = result.stream().map(PessoaDto::new).toList();
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("contagem-pessoas")
    public ResponseEntity<String> countPeople() {
        return ResponseEntity.ok(pessoaService.countPeople().toString());
    }
}
