/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.fila;

import br.com.petservicos.business.generic.GenericBusinessImpl;
import br.com.petservicos.dao.fila.FilaDao;
import br.com.petservicos.domain.Fila;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */
@Service
public class FilaBusinessImpl extends GenericBusinessImpl<Fila, FilaDao, FilaBusinessException> implements FilaBusiness{
    @Autowired
    private FilaDao filaDao;
    
    public FilaBusinessImpl(FilaDao genericDao) {
        super();
        this.filaDao=genericDao;
    }

    public FilaBusinessImpl() {
    }
        
    @Override
    protected FilaDao getGenericDao() {
        return filaDao;
    }
    
}

