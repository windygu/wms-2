package org.dddml.wms.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by yangjiefeng on 2018/8/21.
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public JwtAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public JwtAuthenticationToken(JwtUser user, Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);

    }

    public JwtAuthenticationToken(String authToken) {
        super(null, null, new ArrayList<>());
        this.token = authToken;
    }

    private JwtUser user;

    private String token;

    public JwtUser getUser() {
        return this.user;
    }

    public String getToken() {
        return token;
    }

}
