package com.hyakko.descomplica.springPratica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyakko.descomplica.springPratica.entity.Turma;
import com.hyakko.descomplica.springPratica.repository.TurmaRepository;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> getAll(){
        return turmaRepository.findAll();
    }

    public Turma getById(Integer id){
        return turmaRepository.findById(id).orElse(null);
    }

    public Turma save(Turma turma){
        return turmaRepository.save(turma);
    }

    public Turma update(Integer id, Turma newTurma){
        Turma upTurma = this.getById(id);
        
        if (upTurma == null){
            return null;
        }

        upTurma.setInstrutor(newTurma.getInstrutor());
        upTurma.setHorario(newTurma.getHorario());
        upTurma.setDuracao(newTurma.getDuracao());
        upTurma.setDataInicio(newTurma.getDataInicio());
        upTurma.setDataFim(newTurma.getDataFim());

        return turmaRepository.save(upTurma);
    }

    public Boolean delete(Integer id){
        Turma turma = this.getById(id);

        if (turma == null){
            return false;
        }

        turmaRepository.delete(turma);
        return true;
    }
}

