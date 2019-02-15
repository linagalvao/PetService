/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.webservices.animal;
import br.com.petservicos.business.animal.AnimalBusiness;
import br.com.petservicos.domain.Animal;
import br.com.petservicos.webservices.generic.GenericWebServiceImpl;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Lina
 */
@Path("/animal")
public class AnimalWebServiceImpl extends GenericWebServiceImpl<Animal, AnimalBusiness>
        implements AnimalWebService {
    @Autowired
    private AnimalBusiness animalBusiness;  


    @Override
    protected AnimalBusiness getGenericService() {
        return animalBusiness;
    }
    

}
