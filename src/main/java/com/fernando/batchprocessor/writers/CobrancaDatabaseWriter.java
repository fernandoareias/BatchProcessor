package com.fernando.batchprocessor.writers;

import com.fernando.batchprocessor.domain.Cobranca;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CobrancaDatabaseWriter implements ItemWriter<Cobranca> {

    private Logger logger = LoggerFactory.getLogger(CobrancaDatabaseWriter.class);

    @Override
    public void write(Chunk<? extends Cobranca> chunk) throws Exception {

        logger.info("Escrevendo chunk");
    }

}
