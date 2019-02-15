/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.utilitarios.enums;

/**
 *
 * @author Lina
 */
public enum StatusEnum {
    A ("aguardando", "A"),
    C ("cancelado", "C"),
    I ("iniciado", "I"),
    P ("pausado", "P"),
    F ("finalizado", "F"),
    E ("entregue", "E");
    
    private String descricao;
    private String valor;
    
    private StatusEnum (String descricao, String valor){
        this.descricao=descricao;
        this.valor=valor;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public static StatusEnum getStatusEnum (String valor){
        for(StatusEnum enums : StatusEnum.values()){
            if (enums.valor.equals(valor)){
                return enums;
            }
        }
        return null;
    }
    
    public String getValor(){
        return valor;
    }
   
}
