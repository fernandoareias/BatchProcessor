package com.fernando.batchprocessor.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class Recebedor {

    private Long codId;

    private LocalDateTime dataCriado;

    private LocalDateTime dataAtualizado;

    private String cpf;

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