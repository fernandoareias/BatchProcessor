package com.fernando.batchprocessor.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recebedores")
public class Recebedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codId;

    @Column(name = "dta_criado", nullable = false, updatable = false)
    private LocalDateTime dataCriado;

    @Column(name = "dta_atualizado", nullable = false)
    private LocalDateTime dataAtualizado;

    @Column(name = "cpf", length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "nome", length = 255)
    private String nome;

    // Getters e Setters
    public Long getCodId() {
        return codId;
    }

    public void setCodId(Long codId) {
        this.codId = codId;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(LocalDateTime dataCriado) {
        this.dataCriado = dataCriado;
    }

    public LocalDateTime getDataAtualizado() {
        return dataAtualizado;
    }

    public void setDataAtualizado(LocalDateTime dataAtualizado) {
        this.dataAtualizado = dataAtualizado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}