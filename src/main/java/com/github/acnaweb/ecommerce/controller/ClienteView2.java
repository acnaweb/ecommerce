package com.github.acnaweb.ecommerce.controller;

import org.springframework.beans.factory.annotation.Value;

public interface ClienteView2 {
	Long getId();

	String getNome();
		
	@Value("#{target.municipio + '/' + target.uf}")
    String getEnderecoCompleto();
}
