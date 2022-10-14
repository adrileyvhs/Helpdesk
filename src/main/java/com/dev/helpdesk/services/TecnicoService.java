package com.dev.helpdesk.services;
import com.dev.helpdesk.Repository.PessoaRepository;
import com.dev.helpdesk.Repository.TecnicoRepository;
import com.dev.helpdesk.domain.Pessoa;
import com.dev.helpdesk.domain.Tecnico;
import com.dev.helpdesk.domain.dtos.TecnicoDto;
import com.dev.helpdesk.services.Exception.ErroDataIntegrity;
import com.dev.helpdesk.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado id:  " + id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDto tcdto) {
        tcdto.setId(null);
        validaCpfEmail(tcdto);
        Tecnico tecnico = new Tecnico(tcdto);
        return  repository.save(tecnico);
    }

    private void validaCpfEmail(TecnicoDto tcdto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(tcdto.getCpf());
        if(obj.isPresent() && obj.get().getId() !=tcdto.getId()){
            throw new ErroDataIntegrity("Cpf já cadastrado no sistema ");
        }
         obj = pessoaRepository.findByEmail(tcdto.getEmail());
        if(obj.isPresent() && obj.get().getId() !=tcdto.getId()){
            throw new ErroDataIntegrity("Email já cadastrado no sistema ");
        }
    }
}
