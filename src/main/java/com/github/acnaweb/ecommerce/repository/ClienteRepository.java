package com.github.acnaweb.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.acnaweb.ecommerce.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	<T> List<T> findByUf(String uf, Class<T> type);
}
