package org.dddml.wms.restful.provider;

import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.rs.security.jose.common.JoseConstants;
import org.apache.cxf.rs.security.jose.jaxrs.JwtAuthenticationFilter;
import org.apache.cxf.rs.security.jose.jwt.JwtToken;
import org.apache.cxf.rs.security.jose.jwt.JwtUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Li Yongchun on 2016/9/12.
 */
public class CustomJwtAuthenticationFilter extends JwtAuthenticationFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //PhaseInterceptorChain.getCurrentMessage().put(JoseConstants.ENABLE_UNSIGNED_JWT_PRINCIPAL, true);
        JAXRSUtils.getCurrentMessage().put(JoseConstants.ENABLE_UNSIGNED_JWT_PRINCIPAL, true);
        super.filter(requestContext);
    }

    @Override
    protected void validateToken(JwtToken jwt) {
        JwtUtils.validateTokenClaims(jwt.getClaims(), getTtl(), getClockOffset(), false);
    }
}
