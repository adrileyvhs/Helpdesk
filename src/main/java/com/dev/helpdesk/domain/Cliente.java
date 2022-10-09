package com.dev.helpdesk.domain;

import com.dev.helpdesk.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{
    private static final long serialVersionUID =1l;

    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();
    public Cliente(){

        AddtPerfis(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String email, String senha, String cpf) {
        super(id, nome, email, senha, cpf);
        AddtPerfis(Perfil.CLIENTE);
    }
    public  List<Chamado> getChamandos(){
        return  chamados;
    }
    public void setChamandos(List<Chamado> chamandos)
    {
        this.chamados = chamandos;

    }
}
