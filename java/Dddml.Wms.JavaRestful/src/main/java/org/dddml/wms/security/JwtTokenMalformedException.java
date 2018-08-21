package org.dddml.wms.security;

/**
 * Created by yangjiefeng on 2018/8/21.
 */
public class JwtTokenMalformedException extends RuntimeException {

    public JwtTokenMalformedException(String message) {

        super(message);

    }
}
