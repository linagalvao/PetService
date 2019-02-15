/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.domain;

import br.com.petservicos.business.utilitarios.annotation.EntiteValidation;
import br.com.petservicos.business.utilitarios.enums.Action;
import br.com.petservicos.business.utilitarios.enums.EspecieEnum;
import java.util.Objects;


/*
create table petservicos.raca (
*	id serial PRIMARY KEY,
*	nome varchar (50) not null unique,
*	especie varchar (1) not null,
*	check (especie IN ('F', 'C'))

);
**/

/**
 *
 * @author Lina
 */

public class Raca extends GenericDomain {
    
    @EntiteValidation(action= Action.D_U ,nameField="id da raça", message= "O código da raça não foi informado.")
    private Long id;
    
    @EntiteValidation (action = Action.I_U, message = "O nome da raça não foi informado.", nameField = "Nome da raça") 
    private String nome;
    
    @EntiteValidation (action = Action.I_U, message = "A espécie não foi informada.", nameField = "Espécie")
    private EspecieEnum especie;


    public Raca (){
        
    }
    
    public Raca (Long id){
        this.id = id;
    }
    
    public Raca (String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Raca{" + "id=" + getId() + ", nome=" + getNome() + ", especie=" + getEspecie() + '}';
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

    public EspecieEnum getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieEnum especie) {
        this.especie = especie;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.especie);
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
        final Raca other = (Raca) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.especie != other.especie) {
            return false;
        }
        return true;
    }
}
