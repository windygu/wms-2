package org.dddml.wms.restful.exception;

public class AuthenticateException extends RuntimeException {

	private static final long serialVersionUID = -8501680351259382119L;

	public AuthenticateException(String message) {
		super(message);
	}
}
