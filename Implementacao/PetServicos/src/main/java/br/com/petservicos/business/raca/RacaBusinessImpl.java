/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.raca;

import br.com.petservicos.business.generic.GenericBusinessImpl;
import br.com.petservicos.domain.Raca;
import br.com.petservicos.dao.raca.RacaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */

@Service
public class RacaBusinessImpl extends GenericBusinessImpl<Raca, RacaDao, RacaBusinessException> implements RacaBusiness
{
   @Autowired
   private RacaDao racaDao;
    
   public RacaBusinessImpl(){
       super(); 
   } 
   
   public RacaBusinessImpl(RacaDao racaDao){
       this.racaDao=racaDao;
   }

   @Override
   protected RacaDao getGenericDao() {
       return racaDao;
    }
}

    
