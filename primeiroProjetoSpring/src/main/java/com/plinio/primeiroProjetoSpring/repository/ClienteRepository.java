package com.plinio.primeiroProjetoSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.plinio.primeiroProjetoSpring.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
