/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.domain;

import br.com.petservicos.business.utilitarios.annotation.EntiteValidation;
import br.com.petservicos.business.utilitarios.enums.Action;
import br.com.petservicos.business.utilitarios.enums.StatusEnum;
import java.util.Objects;

/*
create table petservicos.fila(
	id serial PRIMARY KEY,
	id_animal varchar (50) NOT NULL,
	id_servico INTEGER NOT NULL,
	id_funcionario INTEGER,
	observacao varchar (500),
	status varchar (1) NOT NULL,
	numero_coleira INTEGER NOT NULL,
	ordem INTEGER NOT NULL,
	check (status IN ('A', 'C', 'I', 'P', 'F', 'E')),
	CONSTRAINT FK_ANIMAL FOREIGN KEY (id_animal) REFERENCES animal(id),
	CONSTRAINT FK_SERVICO FOREIGN KEY (id_servico) REFERENCES servico(id),
	CONSTRAINT FK_FUNCIONARIO FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
	
);
*/

/**
 *
 * @author Lina
 */
public class Fila extends GenericDomain{
    @EntiteValidation(action= Action.I_D_U ,nameField="id da fila", message= "O código da fila não foi informado.")
    private Long id;
    @EntiteValidation(action= Action.I_U ,nameField="Animal", inField = "id" ,message= "O animal não foi informado.")
    private Animal animal;  
    @EntiteValidation(action= Action.I_U ,nameField="Serviço", message="O serviço não foi informado.")
    private Servico servico;
    private Funcionario funcionario;
    private String observacao;
    @EntiteValidation (action = Action.I_U, nameField = "Status", message = "O status do serviço não foi informado.")
    private StatusEnum status;
    @EntiteValidation(action= Action.I_U ,nameField="Coleira", message="O número da coleira não foi informado.")
    private int numeroColeira;
    @EntiteValidation(action= Action.I_U ,nameField="Ordem", message="A ordem não foi informada.")
    private int ordem;       
    
    public Fila(){
        
    }
    
    public Fila (Long id){
        this.id=id;
    }
    
    
    @Override
    public String toString(){
        return "Fila{" + "id=" + getId() + ", animal = " + getAnimal() + ", servico = " + getServico() + ""
                + ", fucionario = " + getFuncionario() + ", observacao = " + getObservacao() + ""
                + ", status = " + getStatus() + ", numeroColeira = " + getNumeroColeira() + ", ordem = " + getOrdem() + "}";
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public int getNumeroColeira() {
        return numeroColeira;
    }

    public void setNumeroColeira(int numeroColeira) {
        this.numeroColeira = numeroColeira;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.animal);
        hash = 41 * hash + Objects.hashCode(this.servico);
        hash = 41 * hash + Objects.hashCode(this.funcionario);
        hash = 41 * hash + Objects.hashCode(this.observacao);
        hash = 41 * hash + Objects.hashCode(this.status);
        hash = 41 * hash + Objects.hashCode(this.numeroColeira);
        hash = 41 * hash + Objects.hashCode(this.ordem);
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
        final Fila other = (Fila) obj;
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.numeroColeira != other.numeroColeira) {
            return false;
        }
        if (this.ordem != other.ordem) {
            return false;
        }
        return true;
    }

    
    
}
