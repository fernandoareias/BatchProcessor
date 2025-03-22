package com.fernando.batchprocessor.domain;

import java.math.BigDecimal;

public class CobrancaBuilder {

    private final Cobranca cobranca = new Cobranca();

    public CobrancaBuilder setCodigoCobranca(String codigo){
        cobranca.setCodigoCobranca(codigo);
        return this;
    }

    public CobrancaBuilder setValorCobranca(BigDecimal valorCobranca){
        cobranca.setValorCobranca(valorCobranca);
        return this;
    }

    public CobrancaBuilder setPagadorCpf(String cpf){
        if(cobranca.getPagador() == null)
            cobranca.setPagador(new Pagador());

        cobranca.getPagador().setCpf(cpf);
        return this;
    }

    public CobrancaBuilder setPagadorNome(String nome){
        if(cobranca.getPagador() == null)
            cobranca.setPagador(new Pagador());

        cobranca.getPagador().setNome(nome);
        return this;
    }

    public CobrancaBuilder setRecebedorCpf(String cpf){
        if(cobranca.getRecebedor() == null)
            cobranca.setRecebedor(new Recebedor());

        cobranca.getRecebedor().setCpf(cpf);
        return this;
    }

    public CobrancaBuilder setRecebedorNome(String nome){
        if(cobranca.getRecebedor() == null)
            cobranca.setRecebedor(new Recebedor());

        cobranca.getRecebedor().setNome(nome);
        return this;
    }



    public Cobranca build() {
        return cobranca;
    }
}
