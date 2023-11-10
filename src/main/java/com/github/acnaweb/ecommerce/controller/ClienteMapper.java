package com.github.acnaweb.ecommerce.controller;

import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.github.acnaweb.ecommerce.model.Cliente;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteMapper {

	private final ModelMapper modelMapper;

	public Cliente map(ClienteCreateDTO dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setDataCadastro(Instant.now());
		return cliente;
	}

	public ClienteDTO map(Cliente cliente) {
		ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
		return dto;
	}
}
