package com.dev.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
