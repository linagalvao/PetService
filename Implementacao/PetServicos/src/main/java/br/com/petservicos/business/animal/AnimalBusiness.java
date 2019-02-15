/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.animal;

import br.com.petservicos.business.generic.GenericBusiness;
import br.com.petservicos.domain.Animal;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */

@Service
public interface AnimalBusiness extends GenericBusiness<Animal, AnimalBusinessException> {
    
}
