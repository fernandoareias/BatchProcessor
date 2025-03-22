package com.fernando.batchprocessor.jobs;

import com.fernando.batchprocessor.domain.Cobranca;
import com.fernando.batchprocessor.domain.Transacao;
import com.fernando.batchprocessor.processors.CobrancaProcessor;
import com.fernando.batchprocessor.writers.CobrancaDatabaseWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class GerarCobrancaJob {

    @Bean
    public Step step(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            TaskExecutor taskExecutor,
            JdbcPagingItemReader<Transacao> itemReader,
            CobrancaProcessor processor,
            CobrancaDatabaseWriter writer)
    {
        return new StepBuilder("step", jobRepository)
                .<Transacao, Cobranca>chunk(5000, transactionManager)
                .reader(itemReader)
                .processor(processor)
                .writer(writer)
                .build();

    }

    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("myJob", jobRepository)
                .preventRestart()
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
