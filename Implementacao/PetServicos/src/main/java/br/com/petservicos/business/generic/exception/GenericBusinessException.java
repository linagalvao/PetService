package br.com.petservicos.business.generic.exception;

/**
 * Generic exception to handle errors to the application.
 * 
 * @author Lina
 * 
 */
public class GenericBusinessException extends Exception {
	private static final long serialVersionUID = -4063429270899877528L;

	/**
	 * Default exception constructor.
	 * 
	 * @param message
	 */
	public GenericBusinessException(String message) {
		super(message);
	}

	/**
	 * Default exception constructor with Throwable parameter.
	 * 
	 * @param cause
	 */
	public GenericBusinessException(Throwable cause) {
		super(cause);
	}
}