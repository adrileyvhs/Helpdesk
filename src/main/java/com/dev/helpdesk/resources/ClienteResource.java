package com.dev.helpdesk.resources;

import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.dtos.ClienteDto;
import com.dev.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> finfById(@PathVariable Integer id) {
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(new ClienteDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> FindAll() {
        List<Cliente> list = service.findAll();
        List<ClienteDto> ListDto = list.stream().map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(ListDto);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> create(@RequestBody ClienteDto clidto) {
        Cliente cliente = service.create(clidto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
