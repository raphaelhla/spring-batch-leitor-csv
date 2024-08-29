package com.example.leitorclientes.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.leitorclientes.entity.Cliente;
import com.example.leitorclientes.repository.ClienteRepository;

@Component
public class ClienteItemWriter implements ItemWriter<Cliente> {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void write(Chunk<? extends Cliente> clientes) throws Exception {
		clienteRepository.saveAll(clientes);
		clientes.forEach(System.out::println);
	}

}
