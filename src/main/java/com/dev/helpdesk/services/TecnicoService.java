package com.dev.helpdesk.services;

import com.dev.helpdesk.Repository.TecnicoRepository;
import com.dev.helpdesk.domain.Tecnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository repository;
    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = repository.findById(id);
        return obj.orElse(null);/// Por Enquanto
    }

}
