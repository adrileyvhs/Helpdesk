package com.dev.helpdesk.resources;

import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.Tecnico;
import com.dev.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
     @Autowired
     private ClienteService  service;
     @GetMapping(value = "/{id}")
     public ResponseEntity<Cliente>finfById(@PathVariable Integer id){
         Cliente obj = service.findById(id);
         return  ResponseEntity.ok().body(obj);
    }
}
