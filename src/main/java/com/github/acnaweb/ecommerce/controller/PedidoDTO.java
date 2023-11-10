package com.github.acnaweb.ecommerce.controller;

import java.math.BigDecimal;
import java.time.Instant;

import com.github.acnaweb.ecommerce.model.SituacaoPedidoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {
	private Long id;
	private Long cliente_id;
	private Instant dataPedido;
	private Instant dataEntrega;
	private BigDecimal valorTotal;
	private SituacaoPedidoEnum situacao;
}
