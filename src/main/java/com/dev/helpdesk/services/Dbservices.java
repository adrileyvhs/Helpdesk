package com.dev.helpdesk.services;

import com.dev.helpdesk.Repository.ChamandoRepository;
import com.dev.helpdesk.Repository.ClienteRepository;
import com.dev.helpdesk.Repository.TecnicoRepository;
import com.dev.helpdesk.domain.Chamado;
import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.Tecnico;
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

    public void instaciaDb(){
        Tecnico tec = new Tecnico(null,"juca da silva","ADRILEYS@GMAIL.COM","123456","48784875894");
        tec.AddtPerfis(Perfil.ADMIN);
        Cliente cli = new Cliente(null,"jUSSARA","AnalUIZSA@gmail.com","123456","116125498745");
        Chamado chamado = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO,"chamndo 25","teste de chamando 25  ",tec,cli);

        tecnicoRepository.saveAll(Arrays.asList(tec));
        clienteRepository.saveAll(Arrays.asList(cli));
        chamandoRepository.saveAll(Arrays.asList(chamado));

    }
}
