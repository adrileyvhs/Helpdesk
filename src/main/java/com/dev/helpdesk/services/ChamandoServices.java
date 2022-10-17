package com.dev.helpdesk.services;
import com.dev.helpdesk.Repository.ChamandoRepository;
import com.dev.helpdesk.domain.Chamado;
import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.Tecnico;
import com.dev.helpdesk.domain.dtos.ChamadoDto;
import com.dev.helpdesk.domain.enums.Prioridade;
import com.dev.helpdesk.domain.enums.Status;
import com.dev.helpdesk.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class ChamandoServices {
    @Autowired
    private ChamandoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado findByid(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found " + id));
    }
    public Chamado create(ChamadoDto chmDto) {
        return  repository.save(novoChamado(chmDto));
    }


    private Chamado novoChamado(ChamadoDto obj) {
       Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
       Cliente cliente = clienteService.findById(obj.getCliente());
       Chamado chamado = new Chamado();
        if(obj.getId()!=null){
            chamado.setId(obj.getId());
        }
        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getPrioridade())) ;
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return  chamado;
        
    }
}
