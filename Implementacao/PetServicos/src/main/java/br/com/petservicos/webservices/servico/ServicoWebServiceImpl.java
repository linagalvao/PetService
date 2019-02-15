/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.webservices.servico;

import javax.ws.rs.Path;
import br.com.petservicos.business.servico.ServicoBusiness;
import br.com.petservicos.domain.Servico;
import br.com.petservicos.webservices.generic.GenericWebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lina
 */
@Path("/servico")
public class ServicoWebServiceImpl extends GenericWebServiceImpl<Servico, ServicoBusiness>
        implements ServicoWebService {
   
    @Autowired
   private ServicoBusiness servicoBusiness;  

//    public ServicoWebServiceImpl() {
//        setGenericBusiness(servicoBusiness);
//    }

    @Override
    protected ServicoBusiness getGenericService() {
        return servicoBusiness;
                
    }
     
}
