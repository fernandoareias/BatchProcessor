package com.fernando.batchprocessor.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codId;

    @Column(name = "dta_criado", nullable = false, updatable = false)
    private LocalDateTime dataCriado;

    @Column(name = "dta_atualizado", nullable = false)
    private LocalDateTime dataAtualizado;

    @Column(name = "codigo_transacao", length = 15, unique = true, nullable = false)
    private String codigoTransacao;

    @Column(name = "pagador_cpf", length = 11, nullable = false)
    private String pagadorCpf;

    @Column(name = "recebedor_cpf", length = 11, nullable = false)
    private String recebedorCpf;

    @Column(name = "valor_transacao", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorTransacao;

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

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void setCodigoTransacao(String codigoTransacao) {
        this.codigoTransacao = codigoTransacao;
    }

    public String getPagadorCpf() {
        return pagadorCpf;
    }

    public void setPagadorCpf(String pagadorCpf) {
        this.pagadorCpf = pagadorCpf;
    }

    public String getRecebedorCpf() {
        return recebedorCpf;
    }

    public void setRecebedorCpf(String recebedorCpf) {
        this.recebedorCpf = recebedorCpf;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }
}