package com.hyakko.descomplica.springPratica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyakko.descomplica.springPratica.entity.Turma;
import com.hyakko.descomplica.springPratica.service.TurmaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    TurmaService turmaService;

    @SuppressWarnings("null")
    @GetMapping
    @Operation(summary = "Listar todas as Turmas", description = "Listagem completa de Turmas")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<List<Turma>> getAll(){
        List<Turma> trumas = turmaService.getAll();

        if (trumas.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(trumas, HttpStatus.OK);
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    @Operation(summary = "Buscar Turma por ID", description = "Turma com ID requisitada")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Turma> getById(@PathVariable Integer id) {
        Turma turma = turmaService.getById(id);

        if (turma == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(turma, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Adicionar Turma", description = "Inclui Turma e retorna a mesma")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "O objeto foi criado com sucesso.")})
    public ResponseEntity<Turma> save(@RequestBody Turma turma) {
        return new ResponseEntity<>(turmaService.save(turma), HttpStatus.CREATED);
    }
    
    @SuppressWarnings("null")
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dados da Turma via ID", description = "Atualiza dados da Turma e retorna a mesma atualizada")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso."),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado.")})
    public ResponseEntity<Turma> update(@PathVariable Integer id, @RequestBody Turma turma) {
        Turma newTurma = turmaService.update(id, turma);

        if (newTurma == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(newTurma, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover Turma via ID", description = "Remove Turma e envia confirmação de exclusão")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A requisição foi executada com sucesso.")})
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(turmaService.delete(id), HttpStatus.OK);
    }

}
