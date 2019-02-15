/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.domain;

import br.com.petservicos.business.utilitarios.annotation.EntiteValidation;
import br.com.petservicos.business.utilitarios.enums.Action;
import java.util.Objects;

/*
create table petservicos.cliente(
	id serial PRIMARY KEY,
	nome varchar (150) not null unique,
	email varchar (150),
	telefone1 varchar (20),
	telefone2 varchar (20)

);
*/

/**
 *
 * @author Lina
 */
public class Cliente extends GenericDomain{
    @EntiteValidation(action= Action.D_U ,nameField="id do cliente", message= "O código do cliente não foi informado.")
    private Long id;
    @EntiteValidation (action = Action.I_U, message = "O nome do cliente não foi informado.", nameField = "Nome do cliente") 
    private String nome;
    private String email;
    private String telefone1;
    private String telefone2;
    
    public Cliente(){
        
    }
    
    public Cliente(Long id){
        this.id = id;
    }
   
    public Cliente(String nome){
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + getId() + ", nome=" + getNome() + ", email=" + getEmail() + ", telefone1=" + getTelefone1() 
                        + ", telefone2=" + getTelefone2() + '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.telefone1);
        hash = 47 * hash + Objects.hashCode(this.telefone2);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone1, other.telefone1)) {
            return false;
        }
        if (!Objects.equals(this.telefone2, other.telefone2)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
