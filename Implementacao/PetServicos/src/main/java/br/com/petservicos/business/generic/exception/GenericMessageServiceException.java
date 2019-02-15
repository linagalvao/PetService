package br.com.petservicos.business.generic.exception;

import br.com.petservicos.business.generic.exception.GenericBusinessException;

/**
 * Message with list of params.
 * 
 * @author lina
 * 
 */
public class GenericMessageServiceException extends GenericBusinessException {
    
    private static final long serialVersionUID = 1414349055048557711L;

    private Object[] param;

    /**
     * Constructor with the error message.
     * 
     * @param message
     */
    public GenericMessageServiceException(String message) {
        super(message);
    }

    /**
     * Constructor with the {@link Throwable} cause.
     * 
     * @param cause
     */
    public GenericMessageServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with error message and params.
     * 
     * @param message
     * @param params
     */
    public GenericMessageServiceException(String message, Object... param) {
        super(message);
        this.param = param;
    }

    /**
     * Get param used with exception message.
     * 
     * @return
     */
    public Object[] getParam() {
        return param;
    }
}