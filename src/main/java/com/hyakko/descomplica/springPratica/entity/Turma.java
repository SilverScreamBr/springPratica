package com.hyakko.descomplica.springPratica.entity;

import java.time.LocalTime;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idturma")
	private Integer idturma;

    @Column(name = "horario")
    private LocalTime horario;

    @Column(name = "duracao")
	private Integer duracao;

	@Column(name = "dataInicio")
	private LocalDate dataInicio;
    
	@Column(name = "dataFim")
	private LocalDate dataFim;

    @ManyToOne
	@JoinColumn(name = "idinstrutor", referencedColumnName = "idinstrutor")
	@JsonBackReference
	private Instrutor instrutor;

    public Integer getId() {
        return this.idturma;
    }

    public void setId(Integer idturma) {
        this.idturma = idturma;
    }

    public LocalTime getHorario() {
        return this.horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Integer getDuracao() {
        return this.duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Instrutor getInstrutor() {
        return this.instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

}
