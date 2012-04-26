package org.wjhua.twquiz.exception;

/**
 * FormatException when parse input string or config properties.
 * 
 * @author jinhua
 * 
 */
public class FormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7116261195406705576L;

	public FormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormatException(String message) {
		super(message);
	}

}
