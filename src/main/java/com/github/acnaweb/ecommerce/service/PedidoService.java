package com.github.acnaweb.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.acnaweb.ecommerce.model.Pedido;
import com.github.acnaweb.ecommerce.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	public List<Pedido> findByCliente(long id) {

		return pedidoRepository.findByCliente(id);
	}

}
