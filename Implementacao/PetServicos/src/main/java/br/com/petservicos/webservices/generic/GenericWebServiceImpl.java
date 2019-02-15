/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.webservices.generic;

import br.com.petservicos.domain.GenericDomain;
import br.com.petservicos.domain.ResponseResult;
import java.util.List;
import br.com.petservicos.business.generic.GenericBusiness;
import br.com.petservicos.business.generic.exception.GenericBusinessException;
import br.com.petservicos.webservices.exception.RestDefaultException;
import br.com.petservicos.webservices.exception.RestException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lina
 * @param <E>
 * @param <S>
 */
public abstract class GenericWebServiceImpl<E extends GenericDomain, S extends GenericBusiness> implements GenericWebService<E> {

    /**
     * Application context attribute to inject the default service class for the
     * current entity.
     */
//    @Autowired
//    private ApplicationContext appContext;

    /**
     * Generic service attribute based on the typed parameter.
     */
//    @Autowired
//    private S genericBusiness;

    /**
     * @return the genericService
     */

    /**
     *
     * @return the genericBusiness
     */
    protected abstract S getGenericService();

    @Override
    public ResponseResult add(E entity) throws RestDefaultException {
        try {
            getGenericService().add(entity);
            return new ResponseResult("1.0", "teste", "fernnado@gmail.com");
        } catch (GenericBusinessException ex) {
            throw new RestDefaultException(ex.getMessage());
        }
    }

    @Override
    public ResponseResult update(E entity) throws RestDefaultException {
        try {
            getGenericService().update(entity);
            return new ResponseResult("1.0", "teste", "fernnado@gmail.com");
        } catch (GenericBusinessException ex) {
            throw new RestDefaultException(ex.getMessage());
        }
    }

    @Override
    public ResponseResult delete(E entity) throws RestDefaultException {
        try {
            getGenericService().delete(entity);
            return new ResponseResult("1.0", "teste", "fernnado@gmail.com");
//        return new ResponseResult(version, author, email).
        } catch (GenericBusinessException ex) {
            Logger.getLogger(GenericWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RestDefaultException(ex.getMessage());
        }
    }

    @Override
    public ResponseResult deleteList(List listEntities) throws RestDefaultException {
        try {
            getGenericService().deleteList(listEntities);
            return new ResponseResult("1.0", "teste", "fernnado@gmail.com");
        } catch (GenericBusinessException ex) {
            Logger.getLogger(GenericWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RestDefaultException(ex.getMessage());
        }
    }

    @Override
    public List<E> list() throws RestDefaultException {
        try {
            return getGenericService().list();
        } catch (GenericBusinessException ex) {
            Logger.getLogger(GenericWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RestDefaultException(ex.getMessage());
        }
    }

    @Override
    public List<E> list(E entity) throws RestDefaultException {
        try {
           
            return getGenericService().list(entity);
        } catch (GenericBusinessException ex) {
            Logger.getLogger(GenericWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new RestDefaultException(ex.getMessage());
        }
    }


}
