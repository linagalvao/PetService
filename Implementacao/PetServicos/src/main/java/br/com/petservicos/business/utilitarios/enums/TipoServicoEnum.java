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
public enum TipoServicoEnum {
    B ("Banho","B"),
    T ("Tosa","T");
    private String descricao;
    private String valor;
    
    private TipoServicoEnum(String descricao,String valor){
        this.descricao=descricao;
        this.valor=valor;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public static TipoServicoEnum getTipoServicoEnum(String valor){
        for (TipoServicoEnum enums : TipoServicoEnum.values()) {
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
