package com.dev.helpdesk.services;

import com.dev.helpdesk.Repository.ClienteRepository;
import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.Tecnico;
import com.dev.helpdesk.domain.dtos.ClienteDto;
import com.dev.helpdesk.domain.dtos.TecnicoDto;
import com.dev.helpdesk.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado id:  " + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDto clidto) {
        clidto.setId(null);
        Cliente cliente = new Cliente(clidto);
        return  repository.save(cliente);
    }
}


