package org.dddml.wms.domain.picklistrolemvo;

import java.io.Serializable;
import org.dddml.wms.domain.picklist.PicklistRoleId;
import org.dddml.wms.domain.picklist.*;
import org.dddml.wms.domain.*;

public class PicklistRoleMvoEventId implements Serializable
{
    private PicklistRoleId picklistRoleId = new PicklistRoleId();

    public PicklistRoleId getPicklistRoleId()
    {
        return this.picklistRoleId;
    }

    public void setPicklistRoleId(PicklistRoleId picklistRoleId)
    {
        this.picklistRoleId = picklistRoleId;
    }

    private Long picklistVersion;

    public Long getPicklistVersion()
    {
        return this.picklistVersion;
    }

    public void setPicklistVersion(Long picklistVersion)
    {
        this.picklistVersion = picklistVersion;
    }

    protected String getPicklistRoleIdPicklistId()
    {
        return getPicklistRoleId().getPicklistId();
    }

    protected void setPicklistRoleIdPicklistId(String picklistRoleIdPicklistId)
    {
        getPicklistRoleId().setPicklistId(picklistRoleIdPicklistId);
    }

    protected String getPicklistRoleIdPartyRoleIdPartyId()
    {
        return getPicklistRoleId().getPartyRoleId().getPartyId();
    }

    protected void setPicklistRoleIdPartyRoleIdPartyId(String picklistRoleIdPartyRoleIdPartyId)
    {
        getPicklistRoleId().getPartyRoleId().setPartyId(picklistRoleIdPartyRoleIdPartyId);
    }

    protected String getPicklistRoleIdPartyRoleIdRoleTypeId()
    {
        return getPicklistRoleId().getPartyRoleId().getRoleTypeId();
    }

    protected void setPicklistRoleIdPartyRoleIdRoleTypeId(String picklistRoleIdPartyRoleIdRoleTypeId)
    {
        getPicklistRoleId().getPartyRoleId().setRoleTypeId(picklistRoleIdPartyRoleIdRoleTypeId);
    }

    public PicklistRoleMvoEventId()
    {
    }

    public PicklistRoleMvoEventId(PicklistRoleId picklistRoleId, Long picklistVersion)
    {
        this.picklistRoleId = picklistRoleId;
        this.picklistVersion = picklistVersion;
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

        PicklistRoleMvoEventId other = (PicklistRoleMvoEventId)obj;
        return true 
            && (picklistRoleId == other.picklistRoleId || (picklistRoleId != null && picklistRoleId.equals(other.picklistRoleId)))
            && (picklistVersion == other.picklistVersion || (picklistVersion != null && picklistVersion.equals(other.picklistVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.picklistRoleId != null) {
            hash += 13 * this.picklistRoleId.hashCode();
        }
        if (this.picklistVersion != null) {
            hash += 13 * this.picklistVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "picklistRoleIdPicklistId",
            "picklistRoleIdPartyRoleIdPartyId",
            "picklistRoleIdPartyRoleIdRoleTypeId",
            "picklistVersion",
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

