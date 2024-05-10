package com.hyakko.descomplica.springPratica.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrutor")
public class Instrutor {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idinstrutor")
	private Integer idinstrutor;

    @Column(name = "RG")
	private Integer RG;
    
	@Column(name = "nome")
	private String nome;

	@Column(name = "nascimento")
	private LocalDate nascimento;
    
    @Column(name = "titulacao")
	private Integer titulacao;

    @OneToMany(mappedBy = "instrutor")
	@JsonManagedReference
	private List<Turma> turmasList;

    public Integer getId() {
        return this.idinstrutor;
    }

    public void setId(Integer idinstrutor) {
        this.idinstrutor = idinstrutor;
    }

    public Integer getRG() {
        return this.RG;
    }

    public void setRG(Integer rG) {
        this.RG = rG;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return this.nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getTitulacao() {
        return this.titulacao;
    }

    public void setTitulacao(Integer titulacao) {
        this.titulacao = titulacao;
    }

    public List<Turma> getTurmasList() {
        return this.turmasList;
    }

    public void setTurmasList(List<Turma> turmasList) {
        this.turmasList = turmasList;
    }
}
