package com.fernando.batchprocessor.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cobranca")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codId;

    @Column(name = "dta_criado", nullable = false, updatable = false)
    private LocalDateTime dataCriado;

    @Column(name = "dta_atualizado", nullable = false)
    private LocalDateTime dataAtualizado;

    @Column(name = "codigo_cobranca", length = 15, unique = true, nullable = false)
    private String codigoCobranca;

    @Column(name = "pagador_cpf", length = 11, nullable = false)
    private String pagadorCpf;

    @Column(name = "recebedor_cpf", length = 11, nullable = false)
    private String recebedorCpf;

    @Column(name = "valor_cobranca", precision = 15, scale = 2, nullable = false)
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

    public BigDecimal getValorCobranca() {
        return valorCobranca;
    }

    public void setValorCobranca(BigDecimal valorCobranca) {
        this.valorCobranca = valorCobranca;
    }
}