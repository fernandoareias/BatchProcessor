package com.fernando.batchprocessor.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Cobranca {

    private Long codId;

    private LocalDateTime dataCriado;

    private LocalDateTime dataAtualizado;

    private String codigoCobranca;

    private Pagador pagador;

    private Recebedor recebedor;

    private BigDecimal valorCobranca;

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

    public String getCodigoCobranca() {
        return codigoCobranca;
    }

    public void setCodigoCobranca(String codigoCobranca) {
        this.codigoCobranca = codigoCobranca;
    }

    public BigDecimal getValorCobranca() {
        return valorCobranca;
    }

    public void setValorCobranca(BigDecimal valorCobranca) {
        this.valorCobranca = valorCobranca;
    }

    public Pagador getPagador() {
        return pagador;
    }

    public Recebedor getRecebedor() {
        return recebedor;
    }

    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }

    public void setRecebedor(Recebedor recebedor) {
        this.recebedor = recebedor;
    }
}