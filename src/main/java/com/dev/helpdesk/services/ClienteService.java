package com.dev.helpdesk.services;

import com.dev.helpdesk.Repository.ClienteRepository;
import com.dev.helpdesk.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return  obj.orElse(null);
    }
}
