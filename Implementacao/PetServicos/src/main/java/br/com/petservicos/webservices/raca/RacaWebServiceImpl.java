/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.webservices.raca;

import br.com.petservicos.business.generic.exception.GenericBusinessException;
import br.com.petservicos.business.raca.RacaBusiness;
import br.com.petservicos.domain.Raca;
import br.com.petservicos.webservices.generic.GenericWebServiceImpl;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lina
 */

@Path("/raca")
public class RacaWebServiceImpl extends GenericWebServiceImpl<Raca, RacaBusiness> 
        implements RacaWebService {
   
   @Autowired
   private RacaBusiness racaBusiness;  

   @Override
   protected RacaBusiness getGenericService() {
        return racaBusiness;
                
    }
     
}
