package org.dddml.wms.restful.resource;

import org.dddml.wms.domain.Command;
import org.dddml.wms.security.JwtAuthenticationToken;
import org.dddml.wms.security.JwtUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by yangjiefeng on 2018/8/22.
 */
public class SecurityContextUtil {
    public static String getRequesterId() {
        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
            return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        }
        return null;
    }

    public static void setCommandContext(Command command) {
        String requesterId = getRequesterId();
        if (requesterId != null) {
            command.setRequesterId(requesterId);
        }
        JwtAuthenticationToken jwtAuthenticationToken = null;
        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication() instanceof JwtAuthenticationToken) {
            jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        }
        if (jwtAuthenticationToken != null) {
            //JwtUser jwtUser = jwtAuthenticationToken.getUser();
            //String partyId = jwtUser.getPartyId();
            //command.getCommandContext().put(COMMAND_CONTEXT_PARTY_ID_KEY, partyId);
        }
    }
}
