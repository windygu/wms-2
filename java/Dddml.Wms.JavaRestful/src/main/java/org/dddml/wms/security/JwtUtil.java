package org.dddml.wms.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class JwtUtil {
    private static final String CLAIM_KEY_ROLE = "role";
    private static final String CLAIM_KEY_USER_GROUP = "user_group";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${jwt.secret}")
    private String secret;

    /**
     * Tries to parse specified String as a JWT token.
     * If successful, returns User object with username, id and role prefilled (extracted from token).
     * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
     *
     * @param token the JWT token to parse
     * @return the User object extracted from specified token or null if a token is invalid.
     */
    public JwtUser parseToken(String token) {
        try {

            Claims body = null;
            if (secret == null || secret.trim().isEmpty()) {
                String unsignedToken = token.substring(0, token.lastIndexOf(".") + 1);
                body = Jwts.parser()
                        .parseClaimsJwt(unsignedToken)
                        .getBody();
            } else {
                body = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token)
                        .getBody();
            }
            return getJwtUser(body);

        } catch (JwtException | ClassCastException e) {
            //e.printStackTrace();
            if (logger.isInfoEnabled()) {
                logger.info("Parse JWT error.", e);
            }
            return null;
        }
    }

    private JwtUser getJwtUser(Claims body) {
        JwtUser u = new JwtUser();
        // ///////////////////////////////////
        u.setUsername(body.getSubject());
        // ///////////////////////////////////
        u.setRole((String) body.get(CLAIM_KEY_ROLE));
        List<GrantedAuthority> authorityList = null;
        if (u.getRole() != null) {
            authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(u.getRole());
        } else {
            authorityList = new ArrayList<>();
        }
        u.setAuthorities(authorityList);
        // ///////////////////////////////////
        String userGroupStr = (String) body.get(CLAIM_KEY_USER_GROUP);
        if (userGroupStr != null) {
            u.setUserGroups(commaSeparatedStringToList(userGroupStr));
        }
        // ///////////////////////////////////
        return u;
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims.
     * These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public String generateToken(JwtUser u) {
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        //claims.put("userId", u.getId());
        claims.put("role", u.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private static List<String> commaSeparatedStringToList(String str) {
        return Arrays.asList(StringUtils.tokenizeToStringArray(str, ","));
    }
}