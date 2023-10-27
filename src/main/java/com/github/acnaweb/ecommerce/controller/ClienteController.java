package com.github.acnaweb.ecommerce.controller;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.ecommerce.model.Cliente;
import com.github.acnaweb.ecommerce.model.Pedido;
import com.github.acnaweb.ecommerce.service.ClienteService;
import com.github.acnaweb.ecommerce.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
	private final ClienteService clienteService;
	private final PedidoService pedidoService;
	private final ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> getAll() {

		// mapear/converter cada Cliente -> ClienteDTO
		List<ClienteDTO> result = clienteService.getAll().stream().map(this::map).collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable long id) {
		if (!clienteService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		ClienteDTO dto = this.map(clienteService.findById(id));

		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("{id}/pedidos")
	public ResponseEntity<List<PedidoDTO>> findPedidosByClienteId(@PathVariable long id) {
		if (!clienteService.exists(id)) {
			return ResponseEntity.notFound().build();
		}

		List<PedidoDTO> dto = null; // this.map(clienteService.findById(id));

		List<Pedido> pedidos = pedidoService.findByCliente(id);
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteCreateDTO requestDto) {

		Cliente cliente = map(requestDto);

		Cliente clienteSaved = clienteService.save(cliente);

		ClienteDTO responseDto = this.map(clienteSaved);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}

	private Cliente map(ClienteCreateDTO dto) {
		Cliente cliente = modelMapper.map(dto, Cliente.class);
		cliente.setDataCadastro(Instant.now());
		return cliente;
	}

	private ClienteDTO map(Cliente cliente) {
		ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
		return dto;
	}

}
