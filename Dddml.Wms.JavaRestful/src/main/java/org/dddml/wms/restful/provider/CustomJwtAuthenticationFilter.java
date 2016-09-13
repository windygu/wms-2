package org.dddml.wms.restful.provider;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.rs.security.jose.common.JoseConstants;
import org.apache.cxf.rs.security.jose.common.JoseException;
import org.apache.cxf.rs.security.jose.jaxrs.JwtAuthenticationFilter;
import org.apache.cxf.rs.security.jose.jaxrs.JwtTokenSecurityContext;
import org.apache.cxf.rs.security.jose.jwa.SignatureAlgorithm;
import org.apache.cxf.rs.security.jose.jwt.JoseJwtConsumer;
import org.apache.cxf.rs.security.jose.jwt.JwtToken;
import org.apache.cxf.rs.security.jose.jwt.JwtUtils;
import org.apache.cxf.security.SecurityContext;
import org.dddml.wms.restful.annotation.Logged;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import java.io.IOException;
import java.security.Principal;
import java.util.logging.Logger;

/**
 * 处理JWT
 * Created by Li Yongchun on 2016/9/12.
 */
@Logged
@Priority(Priorities.AUTHENTICATION)
public class CustomJwtAuthenticationFilter extends JoseJwtConsumer implements ContainerRequestFilter {

    protected static final Logger LOG = LogUtils.getL7dLogger(JwtAuthenticationFilter.class);

    private static final String DEFAULT_AUTH_SCHEME = "Bearer";
    private String expectedAuthScheme = DEFAULT_AUTH_SCHEME;
    private int clockOffset;
    private String roleClaim;
    private int ttl;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String auth = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        String[] parts = auth == null ? null : auth.split(" ");
        if (parts == null || !expectedAuthScheme.equals(parts[0]) || parts.length != 2) {
            throw new JoseException(expectedAuthScheme + " scheme is expected");
        }
        JwtToken token = super.getJwtToken(parts[1]);

        JAXRSUtils.getCurrentMessage().put(JoseConstants.ENABLE_UNSIGNED_JWT_PRINCIPAL, true);

        SecurityContext securityContext = configureSecurityContext(token);
        if (securityContext != null) {
            JAXRSUtils.getCurrentMessage().put(SecurityContext.class, securityContext);
        }
    }

    protected SecurityContext configureSecurityContext(JwtToken jwt) {
        Message m = JAXRSUtils.getCurrentMessage();
        boolean enableUnsignedJwt =
                MessageUtils.getContextualBoolean(m, JoseConstants.ENABLE_UNSIGNED_JWT_PRINCIPAL, false);

        // The token must be signed/verified with a public key to set up the security context,
        // unless we directly configure otherwise
        if (jwt.getClaims().getSubject() != null
                && (isVerifiedWithAPublicKey(jwt) || enableUnsignedJwt)) {
            return new JwtTokenSecurityContext(jwt, roleClaim);
        }
        return null;
    }

    private boolean isVerifiedWithAPublicKey(JwtToken jwt) {
        if (isJwsRequired()) {
            String alg = (String) jwt.getJwsHeader(JoseConstants.HEADER_ALGORITHM);
            SignatureAlgorithm sigAlg = SignatureAlgorithm.getAlgorithm(alg);
            return SignatureAlgorithm.isPublicKeyAlgorithm(sigAlg);
        }

        return false;
    }

    @Override
    protected void validateToken(JwtToken jwt) {
        //JwtUtils.validateTokenClaims(jwt.getClaims(), getTtl(), getClockOffset(), false);
    }


    public void setExpectedAuthScheme(String expectedAuthScheme) {
        this.expectedAuthScheme = expectedAuthScheme;
    }


    public int getClockOffset() {
        return clockOffset;
    }

    public void setClockOffset(int clockOffset) {
        this.clockOffset = clockOffset;
    }

    public String getRoleClaim() {
        return roleClaim;
    }

    public void setRoleClaim(String roleClaim) {
        this.roleClaim = roleClaim;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
}
