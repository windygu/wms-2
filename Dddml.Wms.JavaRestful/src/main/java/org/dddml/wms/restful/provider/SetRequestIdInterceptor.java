package org.dddml.wms.restful.provider;

import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.security.SecurityContext;
import org.dddml.wms.domain.Command;
import org.dddml.wms.restful.annotation.SetRequesterId;

import javax.ws.rs.core.Context;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Li Yongchun on 2016/9/13.
 */
public class SetRequestIdInterceptor extends AbstractPhaseInterceptor<Message> {

    public SetRequestIdInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Context
    private SecurityContext securityContext;

    private javax.ws.rs.core.SecurityContext securityContext1;

    @Context
    public void setSecurityContext(javax.ws.rs.core.SecurityContext securityContext) {
        this.securityContext1 = securityContext;
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        if (securityContext == null) {
            securityContext = message.get(SecurityContext.class);
        }
        Method method = (Method) message.get("org.apache.cxf.resource.method");
        if (method != null) {
            SetRequesterId setRequesterId = method.getAnnotation(SetRequesterId.class);
            if (setRequesterId == null) {
                return;
            }
            Object invokee = message.getContent(List.class);
            if (invokee == null) {
                invokee = message.getContent(Object.class);
            }
            List<Object> params = null;
            if (invokee instanceof List) {
                params = CastUtils.cast((List<?>) invokee);
            } else if (invokee != null) {
                params = new MessageContentsList(invokee);
            }
            for (int i = 0; i < method.getParameters().length; i++) {
                if (Command.class.isAssignableFrom(method.getParameters()[i].getType())) {
                    Command command = (Command) params.get(i);
                    if (securityContext != null && securityContext.getUserPrincipal() != null) {
                        command.setRequesterId(securityContext.getUserPrincipal().getName());
                    }
                }
            }

        }
    }
}
