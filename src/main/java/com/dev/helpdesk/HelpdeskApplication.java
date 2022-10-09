package com.dev.helpdesk;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication  implements CommandLineRunner {
  @Autowired
  private TecnicoRepository tecnicoRepository;
  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private ChamandoRepository chamandoRepository;


    public static void main(String[] args) {
        SpringApplication.run(HelpdeskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tecnico tec = new Tecnico(null,"ADRILEY","ADRILEYF@GMAIL.COM","123456","87969203191");
        tec.AddtPerfis(Perfil.ADMIN);
        Cliente cli = new Cliente(null,"Ana Luiza","Ana@gmail.com","123456","12345678912");
        Chamado chamado = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO,"chamndo 10","teste de chamando ",tec,cli);

         tecnicoRepository.saveAll(Arrays.asList(tec));
         clienteRepository.saveAll(Arrays.asList(cli));
         chamandoRepository.saveAll(Arrays.asList(chamado));




    }
}
