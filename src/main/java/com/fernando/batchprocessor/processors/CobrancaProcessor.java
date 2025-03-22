package com.fernando.batchprocessor.processors;

import com.fernando.batchprocessor.domain.Cobranca;
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
        var cobranca = new Cobranca();
        cobranca.setCodigoCobranca(item.getCodigoTransacao());
        cobranca.setPagadorCpf(item.getPagadorCpf());
        cobranca.setRecebedorCpf(item.getRecebedorCpf());
        cobranca.setValorCobranca(item.getValorTransacao());
        return cobranca;
    }
}
