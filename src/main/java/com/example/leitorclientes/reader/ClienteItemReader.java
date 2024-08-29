package com.example.leitorclientes.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.example.leitorclientes.entity.Cliente;

@Configuration
public class ClienteItemReader {

	@Bean
    public FlatFileItemReader<Cliente> reader() {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("clienteItemReader")
                .resource(new ClassPathResource("input/clientes.csv"))
                .delimited()
                .names(new String[]{"nome", "sobrenome", "idade", "email"})
                .targetType(Cliente.class)
                .build();
    }
}
