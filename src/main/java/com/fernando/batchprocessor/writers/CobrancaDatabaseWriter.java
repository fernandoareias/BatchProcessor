package com.fernando.batchprocessor.writers;

import com.fernando.batchprocessor.domain.Cobranca;
import com.fernando.batchprocessor.domain.Pagador;
import com.fernando.batchprocessor.domain.Recebedor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CobrancaDatabaseWriter implements ItemWriter<Cobranca> {

    private final Logger logger = LoggerFactory.getLogger(CobrancaDatabaseWriter.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // Query SQL para inserção
    private static final String INSERT_COBRANCA = new StringBuilder()
            .append("INSERT INTO public.cobranca (")
            .append("    codigo_cobranca, ")
            .append("    pagador_cpf, ")
            .append("    recebedor_cpf, ")
            .append("    valor_cobranca ")
            .append(") VALUES (")
            .append("    :codigoCobranca, ")
            .append("    :pagadorCpf, ")
            .append("    :recebedorCpf, ")
            .append("    :valorCobranca ")
            .append(")")
            .toString();

    private static final String INSERT_RECEBEDOR = new StringBuilder()
            .append("INSERT INTO public.recebedores (")
            .append("    cpf, ")
            .append("    nome ")
            .append(") VALUES (")
            .append("    :cpf, ")
            .append("    :nome ")
            .append(")")
            .toString();

    private static final String INSERT_PAGADOR = new StringBuilder()
            .append("INSERT INTO public.pagadores (")
            .append("    cpf, ")
            .append("    nome ")
            .append(") VALUES (")
            .append("    :cpf, ")
            .append("    :nome ")
            .append(")")
            .toString();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(Chunk<? extends Cobranca> chunk) throws Exception {
        List<? extends Cobranca> items = chunk.getItems();
        logger.info("Escrevendo chunk com {} itens", items.size());

        List<Pagador> pagadores = items.stream().filter(x -> x.getPagador() != null)
                                                .map(x -> x.getPagador())
                                                .collect(Collectors.toUnmodifiableList());

        List<Recebedor> recebedores = items.stream().filter(x -> x.getRecebedor() != null)
                                                    .map(x -> x.getRecebedor())
                                                    .collect(Collectors.toUnmodifiableList());

        Map<String, Object>[] batchValues = items.stream()
                .map(this::toParameterMap)
                .toArray(Map[]::new);

        int[] updateCounts = jdbcTemplate.batchUpdate(INSERT_COBRANCA, batchValues);
        logger.info("Bulk insert cobranca realizado com sucesso. Registros afetados: {}", updateCounts.length);

        Map<String, Object>[] recebedoresBatchValues = recebedores.stream()
                .map(this::toParameterMap)
                .toArray(Map[]::new);

        updateCounts = jdbcTemplate.batchUpdate(INSERT_RECEBEDOR, recebedoresBatchValues);
        logger.info("Bulk insert de recebedores realizado com sucesso. Registros afetados: {}", updateCounts.length);

        Map<String, Object>[] pagadorBatchValues = pagadores.stream()
                .map(this::toParameterMap)
                .toArray(Map[]::new);

        updateCounts = jdbcTemplate.batchUpdate(INSERT_PAGADOR, pagadorBatchValues);
        logger.info("Bulk insert de pagadores realizado com sucesso. Registros afetados: {}", updateCounts.length);


    }

    private Map<String, Object> toParameterMap(Pagador pagador) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cpf", pagador.getCpf());
        parameters.put("nome", pagador.getNome());
        return parameters;
    }

    private Map<String, Object> toParameterMap(Cobranca cobranca) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("codigoCobranca", cobranca.getCodigoCobranca());
        parameters.put("pagadorCpf", cobranca.getPagador().getCpf());
        parameters.put("recebedorCpf", cobranca.getRecebedor().getCpf());
        parameters.put("valorCobranca", cobranca.getValorCobranca());
        return parameters;
    }

    private Map<String, Object> toParameterMap(Recebedor recebedor) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("cpf", recebedor.getCpf());
        parameters.put("nome", recebedor.getNome());
        return parameters;
    }
}