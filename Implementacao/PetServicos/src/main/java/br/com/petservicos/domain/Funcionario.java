/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.domain;

import br.com.petservicos.business.utilitarios.annotation.EntiteValidation;
import br.com.petservicos.business.utilitarios.enums.Action;
import java.util.Objects;

/**
 *
 * @author Lina
 */
public class Funcionario extends GenericDomain {
    
    @EntiteValidation(action= Action.D_U ,nameField="id do funcionário", message="O código do funcionário não foi informado.")
    protected Long id;

    @EntiteValidation(action= Action.I_U ,nameField="nome do funcionário", message="O nome do funcionário não foi informado.")
    private String nome;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Funcionario(Long id) {
        this.id = id;
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nome);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
}
