package com.fernando.batchprocessor.readers;

import com.fernando.batchprocessor.domain.Transacao;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TransactionDbReaders {

    @Bean
    public JdbcPagingItemReader<Transacao> transacoesReaders(
            @Qualifier("appDataSource") DataSource dataSource,
            PagingQueryProvider queryProvider) throws Exception {
        return new JdbcPagingItemReaderBuilder<Transacao>()
                .name("transacoesReaders")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .rowMapper(new BeanPropertyRowMapper<>(Transacao.class))
                .pageSize(5000)
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();

        provider.setDataSource(dataSource);
        provider.setSelectClause("SELECT cod_id, dta_criado, dta_atualizado, codigo_transacao, pagador_cpf, recebedor_cpf, valor_transacao");
        provider.setFromClause("FROM public.transacao");
        provider.setSortKey("cod_id");

        return provider;
    }

}