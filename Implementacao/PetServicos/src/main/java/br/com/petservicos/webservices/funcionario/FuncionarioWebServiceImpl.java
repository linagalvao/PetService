/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.webservices.funcionario;

import br.com.petservicos.domain.Funcionario;
import br.com.petservicos.business.generic.exception.GenericBusinessException;
import javax.ws.rs.Path;
import br.com.petservicos.business.funcionario.FuncionarioBusiness;
import br.com.petservicos.webservices.generic.GenericWebServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lina
 */
@Path("/funcionario")
public class FuncionarioWebServiceImpl extends GenericWebServiceImpl<Funcionario, FuncionarioBusiness>
        implements FuncionarioWebService {
    @Autowired
   private FuncionarioBusiness funcionarioBusiness;  
//
//    public FuncionarioWebServiceImpl() {
//        setGenericBusiness(funcionarioBusiness);
//    }

    @Override
    protected FuncionarioBusiness getGenericService() {
        return funcionarioBusiness;
    }
    

}
