package com.hyakko.descomplica.springPratica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyakko.descomplica.springPratica.entity.Instrutor;
import com.hyakko.descomplica.springPratica.repository.InstrutorRepository;

@Service
public class InstrutorService {
    @Autowired
    InstrutorRepository instrutorRepository;

    public List<Instrutor> getAll(){
        return instrutorRepository.findAll();
    }

    public Instrutor getById(Integer id){
        return instrutorRepository.findById(id).orElse(null);
    }

    public Instrutor save(Instrutor instrutor){
        return instrutorRepository.save(instrutor);
    }

    public Instrutor update(Integer id, Instrutor newInstrutor){
        Instrutor upInstrutor = this.getById(id);
        
        if (upInstrutor == null){
            return null;
        }
    
        upInstrutor.setNome(newInstrutor.getNome());
        upInstrutor.setRG(newInstrutor.getRG());
        upInstrutor.setNascimento(newInstrutor.getNascimento());
        upInstrutor.setTitulacao(newInstrutor.getTitulacao());

        return instrutorRepository.save(upInstrutor);
    }

    public Boolean delete(Integer id){
        Instrutor instrutor = this.getById(id);

        if (instrutor == null){
            return false;
        }

        instrutorRepository.delete(instrutor);
        return true;
    }
}
