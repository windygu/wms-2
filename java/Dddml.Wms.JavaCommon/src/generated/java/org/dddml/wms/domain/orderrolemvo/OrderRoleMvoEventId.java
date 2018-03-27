package org.dddml.wms.domain.orderrolemvo;

import java.io.Serializable;
import org.dddml.wms.domain.order.OrderRoleId;
import org.dddml.wms.domain.order.*;
import org.dddml.wms.domain.*;

public class OrderRoleMvoEventId implements Serializable
{
    private OrderRoleId orderRoleId = new OrderRoleId();

    public OrderRoleId getOrderRoleId()
    {
        return this.orderRoleId;
    }

    public void setOrderRoleId(OrderRoleId orderRoleId)
    {
        this.orderRoleId = orderRoleId;
    }

    private Long orderVersion;

    public Long getOrderVersion()
    {
        return this.orderVersion;
    }

    public void setOrderVersion(Long orderVersion)
    {
        this.orderVersion = orderVersion;
    }

    protected String getOrderRoleIdOrderId()
    {
        return getOrderRoleId().getOrderId();
    }

    protected void setOrderRoleIdOrderId(String orderRoleIdOrderId)
    {
        getOrderRoleId().setOrderId(orderRoleIdOrderId);
    }

    protected String getOrderRoleIdPartyRoleIdPartyId()
    {
        return getOrderRoleId().getPartyRoleId().getPartyId();
    }

    protected void setOrderRoleIdPartyRoleIdPartyId(String orderRoleIdPartyRoleIdPartyId)
    {
        getOrderRoleId().getPartyRoleId().setPartyId(orderRoleIdPartyRoleIdPartyId);
    }

    protected String getOrderRoleIdPartyRoleIdRoleTypeId()
    {
        return getOrderRoleId().getPartyRoleId().getRoleTypeId();
    }

    protected void setOrderRoleIdPartyRoleIdRoleTypeId(String orderRoleIdPartyRoleIdRoleTypeId)
    {
        getOrderRoleId().getPartyRoleId().setRoleTypeId(orderRoleIdPartyRoleIdRoleTypeId);
    }

    public OrderRoleMvoEventId()
    {
    }

    public OrderRoleMvoEventId(OrderRoleId orderRoleId, Long orderVersion)
    {
        this.orderRoleId = orderRoleId;
        this.orderVersion = orderVersion;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrderRoleMvoEventId other = (OrderRoleMvoEventId)obj;
        return true 
            && (orderRoleId == other.orderRoleId || (orderRoleId != null && orderRoleId.equals(other.orderRoleId)))
            && (orderVersion == other.orderVersion || (orderVersion != null && orderVersion.equals(other.orderVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.orderRoleId != null) {
            hash += 13 * this.orderRoleId.hashCode();
        }
        if (this.orderVersion != null) {
            hash += 13 * this.orderVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "orderRoleIdOrderId",
            "orderRoleIdPartyRoleIdPartyId",
            "orderRoleIdPartyRoleIdRoleTypeId",
            "orderVersion",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "String",
            "String",
            "Long",
    };

    protected static final java.util.Map<String, String> FLATTENED_PROPERTY_TYPE_MAP;

    static {
        java.util.Map<String, String> m = new java.util.HashMap<String, String>();
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            m.put(FLATTENED_PROPERTY_NAMES[i], FLATTENED_PROPERTY_TYPES[i]);
        }
        FLATTENED_PROPERTY_TYPE_MAP = m;
    }

    protected void forEachFlattenedProperty(java.util.function.BiConsumer<String, Object> consumer) {
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            String pn = FLATTENED_PROPERTY_NAMES[i];
            if (Character.isLowerCase(pn.charAt(0))) {
                pn = Character.toUpperCase(pn.charAt(0)) + pn.substring(1);
            }
            java.lang.reflect.Method m = null;
            try {
                m = this.getClass().getDeclaredMethod("get" + pn, new Class[0]);
            } catch (NoSuchMethodException e) {
                try {
                    m = this.getClass().getMethod("get" + pn, new Class[0]);
                } catch (NoSuchMethodException e1) {
                    throw new RuntimeException(e);
                }
            }
            Object pv = null;
            try {
                pv = m.invoke(this);
            } catch (IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            consumer.accept(pn, pv);
        }
    }

    protected void setFlattenedPropertyValues(Object... values) {
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            String pn = FLATTENED_PROPERTY_NAMES[i];
            if (Character.isLowerCase(pn.charAt(0))) {
                pn = Character.toUpperCase(pn.charAt(0)) + pn.substring(1);
            }
            Object v = values[i];
            Class propCls = v == null ? Object.class : v.getClass();
            java.lang.reflect.Method setterMethod = null;
            if (v == null) {
                setterMethod = getNullValueSetterMethod(pn);
            }
            if (setterMethod == null) {
                try {
                    setterMethod = this.getClass().getDeclaredMethod("set" + pn, new Class[]{propCls});
                } catch (NoSuchMethodException e) {
                    try {
                        setterMethod = this.getClass().getMethod("set" + pn, new Class[]{propCls});
                    } catch (NoSuchMethodException e1) {
                        throw new RuntimeException(e1);
                    }
                }
            }
            try {
                setterMethod.invoke(this, v);
            } catch (IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private java.lang.reflect.Method getNullValueSetterMethod(String pascalPropName) {
        java.lang.reflect.Method m;
        final String methodName = "set" + pascalPropName;
        m = java.util.Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                .findFirst().orElse(null);
        if (m == null) {
            m = java.util.Arrays.stream(this.getClass().getMethods())
                    .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                    .findFirst().orElse(null);
        }
        return m;
    }

}

