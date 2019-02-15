/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.animal;

import br.com.petservicos.business.generic.GenericBusinessImpl;
import br.com.petservicos.dao.animal.AnimalDao;
import br.com.petservicos.domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */

@Service
public class AnimalBusinessImpl extends GenericBusinessImpl<Animal, AnimalDao, AnimalBusinessException>implements AnimalBusiness
{
    @Autowired
    private AnimalDao animalDao;
    
    public AnimalBusinessImpl(){
        super();
    }
    
    public AnimalBusinessImpl(AnimalDao animalDao){
        this.animalDao=animalDao;
    }

    @Override
    protected AnimalDao getGenericDao() {
        return animalDao;
    }

   
    
}
