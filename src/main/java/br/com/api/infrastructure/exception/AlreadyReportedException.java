/**
 * 
 */
package br.com.api.infrastructure.exception;

/**
 * @author douglasog87@gmail.com
 * @since 29/12/2016
 */
public class AlreadyReportedException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public AlreadyReportedException() {
		super();
	}

	public AlreadyReportedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlreadyReportedException(String message) {
		super(message);
	}

	public AlreadyReportedException(Throwable cause) {
		super(cause);
	}
}
