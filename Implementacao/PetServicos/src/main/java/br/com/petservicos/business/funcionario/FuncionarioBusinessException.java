/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.funcionario;

import br.com.petservicos.business.generic.exception.GenericBusinessException;

/**
 *
 * @author Lina
 * 
 */
public class FuncionarioBusinessException extends GenericBusinessException{
    
    public FuncionarioBusinessException(String message) {
        super(message);
    }
    
}
