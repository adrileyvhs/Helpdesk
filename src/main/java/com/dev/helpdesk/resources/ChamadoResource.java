package com.dev.helpdesk.resources;

import com.dev.helpdesk.domain.Chamado;
import com.dev.helpdesk.domain.dtos.ChamadoDto;
import com.dev.helpdesk.services.ChamandoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/chamado")
public class ChamadoResource {
    @Autowired
    private ChamandoServices services;
    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDto> findbyid(@PathVariable Integer id){
        Chamado obj = services.findByid(id);
        return  ResponseEntity.ok().body(new ChamadoDto(obj));

    }

   @PostMapping
    public ResponseEntity<ChamadoDto> create(@Valid @RequestBody ChamadoDto chmDto){
       Chamado obj = services.create(chmDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
               .buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).build();

    }


}
