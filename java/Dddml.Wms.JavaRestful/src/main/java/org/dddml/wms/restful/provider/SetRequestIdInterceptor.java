/*
package org.dddml.wms.restful.provider;

import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxrs.impl.SecurityContextImpl;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.dddml.wms.domain.Command;
import org.dddml.wms.restful.annotation.SetRequesterId;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.lang.reflect.Method;
import java.util.List;

// 给 {@link Command Command} 设置 requesterId
public class SetRequestIdInterceptor extends AbstractPhaseInterceptor<Message> {

    public SetRequestIdInterceptor() {
        //发生在调用资源方法前
        super(Phase.PRE_INVOKE);
    }
    
    @Override
    public void handleMessage(Message message) throws Fault {
        SecurityContext securityContext = new SecurityContextImpl(message);
        String requesterId = securityContext.getUserPrincipal() == null ?
                null : securityContext.getUserPrincipal().getName();
        if (requesterId == null || requesterId.length() < 1) {
            return;
        }
        Method method = (Method) message.get("org.apache.cxf.resource.method");
        if (method != null) {
            SetRequesterId setRequesterId = method.getAnnotation(SetRequesterId.class);
            if (setRequesterId == null) {
                return;
            }
            //Copy from org.apache.cxf.interceptor.ServiceInvokerInterceptor
            // private Object getInvokee(Message message)
            Object invokee = message.getContent(List.class);
            if (invokee == null) {
                invokee = message.getContent(Object.class);
            }
            if (invokee == null) {
                return;
            }
            // Copy from org.apache.cxf.jaxrs.JAXRSInvoker
            // public Object invoke(Exchange exchange, Object request, Object resourceObject)
            List<Object> params = null;
            if (invokee instanceof List) {
                params = CastUtils.cast((List<?>) invokee);
            } else if (invokee != null) {
                params = new MessageContentsList(invokee);
            }
            if (params == null || params.size() < 1) {
                return;
            }
            for (int i = 0; i < method.getParameters().length; i++) {
                if (Command.class.isAssignableFrom(method.getParameters()[i].getType())) {
                    Command command = (Command) params.get(i);
                    command.setRequesterId(requesterId);
                }
            }

        }
    }
}
*/