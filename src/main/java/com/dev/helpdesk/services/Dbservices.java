package com.dev.helpdesk.services;

import com.dev.helpdesk.Repository.ChamandoRepository;
import com.dev.helpdesk.Repository.ClienteRepository;
import com.dev.helpdesk.Repository.TecnicoRepository;
import com.dev.helpdesk.domain.Chamado;
import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.Tecnico;
import com.dev.helpdesk.domain.dtos.TecnicoDto;
import com.dev.helpdesk.domain.enums.Perfil;
import com.dev.helpdesk.domain.enums.Prioridade;
import com.dev.helpdesk.domain.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Dbservices {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamandoRepository chamandoRepository;

    public void instanciaDb(){
//       Tecnico tec = new Tecnico(null,"Usando DTO  tec","dd@1.COM","asdas","123");
//       Cliente cli = new Cliente(null,"eqwe","1@gmail.com","ww","22ee2");
//       Chamado chamado = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO,"chamndo 2ee5","teste de chaeemando 25  ",tec,cli);
//       tecnicoRepository.saveAll(Arrays.asList(tec));
//       clienteRepository.saveAll(Arrays.asList(cli));
//       chamandoRepository.saveAll(Arrays.asList(chamado));
    }
}
