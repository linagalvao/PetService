package br.com.petservicos.webservices.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * RestDefaultException Servi�o Rest para tratamento de exce��o padr�o para
 * restease
 *
 * @author Lina
 *
 * <pre>
 * History:
 *    28/04/2015 - Lina Galvão
 * </pre>
 */
public class RestDefaultException extends WebApplicationException {

    public RestDefaultException(String message) {
        super(Response.status(666)
                .entity(message).type(MediaType.TEXT_PLAIN).build());
    }

}
