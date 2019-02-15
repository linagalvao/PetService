/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.cliente;

import br.com.petservicos.business.generic.GenericBusinessImpl;
import br.com.petservicos.dao.cliente.ClienteDao;
import br.com.petservicos.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */
@Service
public class ClienteBusinessImpl extends GenericBusinessImpl<Cliente, ClienteDao, ClienteBusinessException> implements ClienteBusiness
{
    @Autowired
    private ClienteDao clienteDao;
    
    public ClienteBusinessImpl (){
        super();
    }
    
    public ClienteBusinessImpl(ClienteDao clienteDao) {
        this.clienteDao=clienteDao;
    }

    @Override
    protected ClienteDao getGenericDao() {
        return clienteDao;
    }
    
}
