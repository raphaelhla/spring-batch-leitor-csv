package com.example.leitorclientes.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.leitorclientes.entity.Cliente;
import com.example.leitorclientes.reader.ClienteItemReader;
import com.example.leitorclientes.writer.ClienteItemWriter;

@Configuration
public class LeitorClientesStep {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
    private PlatformTransactionManager transactionManager;
	
	@Bean
    public Step leitorClientesStepp(ClienteItemReader clienteItemReader, ClienteItemWriter clienteItemWriter) {
        return new StepBuilder("leitorClientesStep", jobRepository)
        		.<Cliente, Cliente>chunk(10, transactionManager)
        		.reader(clienteItemReader.reader())
        		.writer(clienteItemWriter)
                .build();
    }
}
