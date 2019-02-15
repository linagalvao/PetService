/*
 * Copyright (c) 2015 LG Eletronics. All Rights Reserved. This software is the
 * confidential and proprietary information of LG Eletronics. You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with LG Eletronics.
 */
package br.com.petservicos.webservices.generic;

import br.com.petservicos.domain.GenericDomain;
import br.com.petservicos.domain.ResponseResult;
import br.com.petservicos.webservices.exception.RestDefaultException;
import br.com.petservicos.webservices.exception.RestException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Generic service that will be the base service for all services
 * implementations.
 *
 * @author Lina
 * @param <E>
 * @param <RestException>
 */
public interface GenericWebService<E extends GenericDomain> {

    /**
     * Default generic add method.
     *
     * @param entity
     * @return
     * @throws RestException
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    ResponseResult add(E entity) throws RestDefaultException;

    /**
     * Default generic update method.
     *
     * @param entity
     * @return
     * @throws RestException
     */
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")    
    ResponseResult update(E entity) throws RestException;

    /**
     * Default generic delete method.
     *
     * @param entity
     * @return
     * @throws RestException
     */
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")    
    ResponseResult delete(E entity) throws RestException;

    /**
     * Default generic delete method based on list.
     *
     * @param listEntities
     * @return
     * @throws RestException
     */
    @POST
    @Path("/deleteList")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    ResponseResult deleteList(List<E> listEntities) throws RestException;

   
    /**
     * Default list method without parameters.
     *
     * @return
     * @throws RestException
     */
    @POST
    @Path("/listAll")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")    
    List<E> list() throws RestException;    
    
    /**
     * Default method to return a list of an entity. The chosen criteria will be
     * specified on the mybatis xml file.
     *
     * @param entity
     * @return
     * @throws RestException
     */
    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")    
    List<E> list(E entity) throws RestException;
}
