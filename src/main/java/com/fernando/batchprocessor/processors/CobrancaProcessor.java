package com.fernando.batchprocessor.processors;

import com.fernando.batchprocessor.domain.Cobranca;
import com.fernando.batchprocessor.domain.CobrancaBuilder;
import com.fernando.batchprocessor.domain.Transacao;
import com.fernando.batchprocessor.writers.CobrancaDatabaseWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CobrancaProcessor implements ItemProcessor<Transacao, Cobranca> {

    @Override
    public Cobranca process(Transacao item) throws Exception {

        return new CobrancaBuilder()
                .setCodigoCobranca(item.getCodigoTransacao())
                .setValorCobranca(item.getValorTransacao())
                .setPagadorCpf(item.getPagadorCpf())
                .setRecebedorCpf(item.getRecebedorCpf())
                .setPagadorNome("Pagador " + item.getPagadorCpf())
                .setRecebedorNome("Recebedor " + item.getRecebedorCpf())
                .build();
    }
}
