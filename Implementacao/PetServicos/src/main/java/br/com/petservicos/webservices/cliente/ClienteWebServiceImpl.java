/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.webservices.cliente;

import br.com.petservicos.business.cliente.ClienteBusiness;
import br.com.petservicos.domain.Cliente;
import br.com.petservicos.webservices.generic.GenericWebServiceImpl;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lina
 */
@Path("/cliente")
public class ClienteWebServiceImpl extends GenericWebServiceImpl<Cliente, ClienteBusiness>
        implements ClienteWebService {
    
    @Autowired
    private ClienteBusiness clienteBusiness;  


    @Override
    protected ClienteBusiness getGenericService() {
        return clienteBusiness;
    }
    

}