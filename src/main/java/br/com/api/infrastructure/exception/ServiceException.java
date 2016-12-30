package br.com.api.infrastructure.exception;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
