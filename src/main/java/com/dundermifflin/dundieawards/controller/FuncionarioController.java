package com.dundermifflin.dundieawards.controller;

import com.dundermifflin.dundieawards.domain.model.Funcionario;
import com.dundermifflin.dundieawards.domain.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@Valid @RequestBody Funcionario funcionario) {
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return ResponseEntity.status(201).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        funcionarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Funcionario dadosNovos) {
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);

        if (funcionarioExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Funcionario funcionario = funcionarioExistente.get();

        funcionario.setNome(dadosNovos.getNome());
        funcionario.setEmail(dadosNovos.getEmail());
        funcionario.setCargo(dadosNovos.getCargo());

        Funcionario atualizado = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(atualizado);
    }
}