package org.dddml.wms.restful.exception;

/**
 * Created by Li Yongchun on 2016/9/3.
 */
public class WebApiApplicationException extends RuntimeException {
    public WebApiApplicationException() {
        super();
    }

    public WebApiApplicationException(String message) {
        super(message);
    }

    public WebApiApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebApiApplicationException(Throwable cause) {
        super(cause);
    }

    protected WebApiApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
