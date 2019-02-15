/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.dao.cliente;

import br.com.petservicos.dao.generic.GenericDaoImpl;
import br.com.petservicos.domain.Cliente;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lina
 */
@Repository
public class ClienteDaoImpl extends GenericDaoImpl<Cliente> implements ClienteDao{
    
}
