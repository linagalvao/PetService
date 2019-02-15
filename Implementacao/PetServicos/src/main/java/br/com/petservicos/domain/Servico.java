/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.domain;

import br.com.petservicos.business.utilitarios.annotation.EntiteValidation;
import br.com.petservicos.business.utilitarios.enums.Action;
import br.com.petservicos.business.utilitarios.enums.TipoServicoEnum;
import java.util.Objects;

/**
 *  	id serial PRIMARY KEY,
 *	nome varchar (100) not null unique,
 *	tipo_servico char (1) not null,
 *	check (tipo_servico IN ('B', 'T')),
 *	descricao varchar (500)
 
 
/**
 *
 * @author Lina
 */

public class Servico extends GenericDomain {
    
    @EntiteValidation(action= Action.D_U ,nameField="id do serviço", message="O código do serviço não foi informado.")
    private Long id;
   
    @EntiteValidation (action = Action.I_U, message = "O nome do serviço não foi informado.", nameField = "Nome do serviço") 
    private String nome;
    
    @EntiteValidation (action = Action.I_U, message = "O tipo do serviço não foi informado.", nameField = "Tipo do serviço")
    private TipoServicoEnum tipoServico;
    
    private String descricao;

    public Servico() {
    }
    public Servico(Long id) {
        this.id = id;
    }

    public Servico(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", nome=" + nome + ", tipoServico=" + tipoServico + ", descricao=" + descricao + '}';
    }
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoServicoEnum getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServicoEnum tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.tipoServico);
        hash = 67 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.tipoServico != other.tipoServico) {
            return false;
        }
        return true;
    }
     
    
}
