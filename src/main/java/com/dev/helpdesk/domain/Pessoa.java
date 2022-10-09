package com.dev.helpdesk.domain;

import com.dev.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public  abstract class Pessoa implements Serializable {
     private static final long serialVersionUID =1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  Integer id;
    protected  String nome;
    @Column(unique = true)
    protected  String email;
    protected  String senha;
    @ElementCollection(fetch = FetchType.EAGER) 
    protected Set<Integer> perfis = new HashSet<>();
    @CollectionTable(name = "PERFIS")
    @JsonFormat(pattern = "dd//MM/yyyy")
    @Column(unique = true)
    protected  String cpf;

    protected LocalDate dataCriacao = LocalDate.now();


    public Pessoa() {
        AddtPerfis(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, String nome, String email, String senha, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        AddtPerfis(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x->Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void AddtPerfis(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(cpf, pessoa.cpf);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
