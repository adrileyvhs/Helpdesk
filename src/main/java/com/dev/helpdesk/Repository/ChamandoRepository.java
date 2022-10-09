package com.dev.helpdesk.Repository;

import com.dev.helpdesk.domain.Chamado;
import com.dev.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamandoRepository extends JpaRepository<Chamado,Integer> {
}
