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
public enum EspecieEnum {
    F ("Felina","F"),
    C ("Canina","C");
    private String descricao;
    private String valor;
    
    private EspecieEnum(String descricao,String valor){
        this.descricao=descricao;
        this.valor=valor;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public static EspecieEnum getTipoEspecieEnum(String valor){
        for (EspecieEnum enums : EspecieEnum.values()) {
            if(enums.valor.equals(valor)){
                return enums;
            }
        }
        return null;
    }
    
    public String getValor(){
        return valor;        
    }
}
