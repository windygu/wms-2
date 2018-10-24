package org.dddml.wms.restful.resource;

import org.dddml.wms.domain.Command;
import org.dddml.wms.security.JwtAuthenticationToken;
import org.dddml.wms.security.JwtUser;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by yangjiefeng on 2018/8/22.
 */
public class SecurityContextUtil {

    public static final String COMMAND_CONTEXT_WAREHOUSE_IDS_KEY = "WAREHOUSE_IDS";

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
        JwtAuthenticationToken jwtAuthenticationToken = getJwtAuthenticationToken();
        if (jwtAuthenticationToken != null) {
            JwtUser jwtUser = jwtAuthenticationToken.getUser();
            // ////////////////////////////////////////////////////////
            Collection<String> warehouseIds = jwtUser.getUserGroups();
            command.getCommandContext().put(COMMAND_CONTEXT_WAREHOUSE_IDS_KEY, warehouseIds);
            // ////////////////////////////////////////////////////////
        }
    }

    public static Collection<String> getWarehouseIds() {
        Collection<String> warehouseIds;
        JwtAuthenticationToken jwtAuthenticationToken = getJwtAuthenticationToken();
        if (jwtAuthenticationToken != null) {
            JwtUser jwtUser = jwtAuthenticationToken.getUser();
            warehouseIds = jwtUser.getUserGroups();
        } else {
            warehouseIds = Collections.EMPTY_LIST;
        }
        return warehouseIds;
    }

    static JwtAuthenticationToken getJwtAuthenticationToken() {
        JwtAuthenticationToken jwtAuthenticationToken = null;
        if (SecurityContextHolder.getContext() != null
                && SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication() instanceof JwtAuthenticationToken) {
            jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        }
        return jwtAuthenticationToken;
    }
}
