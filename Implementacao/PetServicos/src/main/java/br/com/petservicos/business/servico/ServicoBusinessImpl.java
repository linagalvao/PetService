/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.servico;

import br.com.petservicos.business.generic.GenericBusinessImpl;
import br.com.petservicos.dao.servico.ServicoDao;
import br.com.petservicos.domain.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */
@Service
public class ServicoBusinessImpl extends GenericBusinessImpl<Servico, ServicoDao, ServicoBusinessException> implements ServicoBusiness
{
    @Autowired
    private ServicoDao servicoDao;
    
   public ServicoBusinessImpl(){
       super(); 
   } 
   
   public ServicoBusinessImpl(ServicoDao servicoDao){
       this.servicoDao=servicoDao;
   }

    @Override
    protected ServicoDao getGenericDao() {
       return servicoDao;
    }
}
