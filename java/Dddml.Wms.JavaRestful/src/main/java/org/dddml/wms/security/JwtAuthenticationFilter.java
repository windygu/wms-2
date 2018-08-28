package org.dddml.wms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.http.HttpStatus;

/**
 * token的校验
 */
@Component
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    private JwtUtil jwtUtil;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (authentication == null) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }


    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        //        if (header == null || !header.startsWith("Bearer ")) {
        //            throw new JwtTokenMissingException("No JWT token found in request headers");
        //        }
        String authToken = header.substring(7);
        // parse the token.
        JwtUser parsedUser = jwtUtil.parseToken(authToken);
        if (parsedUser == null) {
            return null;//throw new JwtTokenMalformedException("JWT token is not valid");
        }
        return new JwtAuthenticationToken(parsedUser, parsedUser.getUsername(), null, parsedUser.getAuthorities());
    }



}