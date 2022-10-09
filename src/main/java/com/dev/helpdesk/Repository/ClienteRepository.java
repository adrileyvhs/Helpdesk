package com.dev.helpdesk.Repository;

import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
