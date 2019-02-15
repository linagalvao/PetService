/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.webservices.exception;

import javax.management.InvalidAttributeValueException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

/**
 * This class intercept all server exceptions and log on console the {@link Throwable}.
 *
 * @author Lina
 */
@Provider
public class ServerExceptionInterceptor implements ExceptionMapper<Throwable> {
    private final Logger logger;

    /**
     * Default constructor.
     */
    public ServerExceptionInterceptor() {
        logger = Logger.getLogger("config-application-exception");
    }

    @Override
    public Response toResponse(Throwable throwable) {
        logger.error("Error: ", throwable);

        if (throwable instanceof InvalidAttributeValueException) {
            return Response.status(Status.BAD_REQUEST).build();
        }

        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}