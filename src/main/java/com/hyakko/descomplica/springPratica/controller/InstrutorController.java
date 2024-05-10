package com.hyakko.descomplica.springPratica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyakko.descomplica.springPratica.entity.Instrutor;
import com.hyakko.descomplica.springPratica.service.InstrutorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
    @Autowired
    InstrutorService instrutorService;

    @SuppressWarnings("null")
    @GetMapping
    public ResponseEntity<List<Instrutor>> getAll(){
        List<Instrutor> instrutores = instrutorService.getAll();

        if (instrutores.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(instrutores, HttpStatus.OK);
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> getById(@PathVariable Integer id) {
        Instrutor instrutor = instrutorService.getById(id);

        if (instrutor == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(instrutor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Instrutor> save(@RequestBody Instrutor instrutor) {
        return new ResponseEntity<>(instrutorService.save(instrutor), HttpStatus.CREATED);
    }
    
    @SuppressWarnings("null")
    @PutMapping("/{id}")
    public ResponseEntity<Instrutor> update(@PathVariable Integer id, @RequestBody Instrutor instrutor) {
        Instrutor newInstrutor = instrutorService.update(id, instrutor);

        if (newInstrutor == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(newInstrutor, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(instrutorService.delete(id), HttpStatus.OK);
    }

}
