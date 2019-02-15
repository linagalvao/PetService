/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.domain;

import br.com.petservicos.business.utilitarios.annotation.EntiteValidation;
import br.com.petservicos.business.utilitarios.enums.Action;
import br.com.petservicos.business.utilitarios.enums.SexoEnum;
import java.util.Date;
import java.util.Objects;

/*
create table petservicos.animal(
	id varchar (25) PRIMARY KEY not null,
	nome varchar (50) not null,
	sexo varchar (1) not null,
	data_nasc date,
	id_raca INTEGER NOT NULL,
	id_cliente INTEGER NOT NULL,
	check (sexo IN ('F', 'M')),
	CONSTRAINT FK_RACA FOREIGN KEY (id_raca) REFERENCES raca(id),
	CONSTRAINT FK_CLIENTE FOREIGN KEY (id_cliente) REFERENCES cliente(id)
	
);
*/

/**
 *
 * @author Lina
 */
public class Animal extends GenericDomain{
    
    @EntiteValidation(action= Action.I_D_U ,nameField="id do animal", message= "O código do animal não foi informado.")
    private String id;
    @EntiteValidation (action = Action.I_U, message = "O nome do animal não foi informado.", nameField = "Nome do animal") 
    private String nome;
    @EntiteValidation (action = Action.I_U, message = "O sexo do animal não foi informado.", nameField = "Sexo")
    private SexoEnum sexo;
    private Date dataNasc;
    @EntiteValidation (action = Action.I_U, message = "A raça do animal não foi informada.", nameField = "Raça")
    private Raca raca;
    @EntiteValidation (action = Action.I_U, message = "O dono do animal não foi informado.", nameField = "Cliente")
    private Cliente cliente;
     
    public Animal(){
        
    }
    
    public Animal(String id){
        this.id = id;
    }
     
    @Override
    public String toString(){
        return "Animal{" + "id=" + getId() + ", nome = " + getNome() + ", sexo = " + getSexo() + ", data de nascimento = " 
                         + getDataNasc() + ", raca = " + getRaca() + ", cliente = " + getCliente() + "}";
    }     

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setData_nasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Raca getRaca() {
        return raca;
    }
    
    public Cliente getCliente(){
        return cliente;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.dataNasc);
        hash = 97 * hash + Objects.hashCode(this.raca);
        hash = 97 * hash + Objects.hashCode(this.cliente);
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.dataNasc, other.dataNasc)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }
    
    

}
