package com.dev.helpdesk.services;

import com.dev.helpdesk.Repository.ClienteRepository;
import com.dev.helpdesk.Repository.PessoaRepository;
import com.dev.helpdesk.domain.Cliente;
import com.dev.helpdesk.domain.Pessoa;
import com.dev.helpdesk.domain.Tecnico;
import com.dev.helpdesk.domain.dtos.ClienteDto;
import com.dev.helpdesk.domain.dtos.TecnicoDto;
import com.dev.helpdesk.services.Exception.ErroDataIntegrity;
import com.dev.helpdesk.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

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
    public Cliente update(Integer id, @Validated ClienteDto Clidto) {
        Clidto.setId(id);
        Cliente OldCliente = findById(id);
        //validaCpfEmail(Clidto);
        OldCliente = new Cliente(Clidto);
        return repository.save(OldCliente);
    }
    public void delete(Integer id) {
        Cliente CliObj = findById(id);
        if(CliObj.getChamados().size()>0) {
            throw new ErroDataIntegrity("Cliente Possui Ordens de Serviços é não pode ser deletado");
        }
        repository.deleteById(id);
    }
    private void validaCpfEmail(ClienteDto Clidto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(Clidto.getCpf());
        if(obj.isPresent() && obj.get().getId() !=Clidto.getId()){
            throw new ErroDataIntegrity("Cpf já cadastrado no sistema ");
        }
        obj = pessoaRepository.findByEmail(Clidto.getEmail());
        if(obj.isPresent() && obj.get().getId() !=Clidto.getId()){
            throw new ErroDataIntegrity("Email já cadastrado no sistema ");
        }
    }
}


