package com.dev.helpdesk.resources;

import com.dev.helpdesk.domain.Tecnico;
import com.dev.helpdesk.domain.dtos.TecnicoDto;
import com.dev.helpdesk.services.TecnicoService;
import net.bytebuddy.asm.Advice;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {
    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDto> finfById(@PathVariable Integer id) {
        Tecnico obj = service.findById(id);
        return ResponseEntity.ok().body(new TecnicoDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDto>> FindAll() {
        List<Tecnico> list = service.findAll();
        List<TecnicoDto> ListDto = list.stream().map(obj -> new TecnicoDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(ListDto);

    }
    @PostMapping
    public ResponseEntity<TecnicoDto> create(@Validated @RequestBody TecnicoDto tcdto){
        Tecnico tecnico = service.create(tcdto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(tecnico.getId())
                .toUri();
        return  ResponseEntity.created(uri).build();
    }
     @PutMapping(value = "/{id}")
    public ResponseEntity<TecnicoDto> update(@PathVariable Integer id, @Validated @RequestBody TecnicoDto tcdto) {
         Tecnico tecObj = service.update(id, tcdto);
         return ResponseEntity.ok().body(new TecnicoDto(tecObj));
     }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TecnicoDto> delete(@PathVariable Integer id) {
       service.delete(id);
         return ResponseEntity.noContent().build();
    }

}
