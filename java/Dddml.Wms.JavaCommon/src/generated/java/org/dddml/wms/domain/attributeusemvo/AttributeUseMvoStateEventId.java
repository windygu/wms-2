package org.dddml.wms.domain.attributeusemvo;

import java.io.Serializable;
import org.dddml.wms.domain.attributeset.AttributeSetAttributeUseId;
import org.dddml.wms.domain.attributeset.*;
import org.dddml.wms.domain.*;

public class AttributeUseMvoStateEventId implements Serializable
{
    private AttributeSetAttributeUseId attributeSetAttributeUseId = new AttributeSetAttributeUseId();

    public AttributeSetAttributeUseId getAttributeSetAttributeUseId()
    {
        return this.attributeSetAttributeUseId;
    }

    public void setAttributeSetAttributeUseId(AttributeSetAttributeUseId attributeSetAttributeUseId)
    {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
    }

    private Long attributeSetVersion;

    public Long getAttributeSetVersion()
    {
        return this.attributeSetVersion;
    }

    public void setAttributeSetVersion(Long attributeSetVersion)
    {
        this.attributeSetVersion = attributeSetVersion;
    }

    protected String getAttributeSetAttributeUseIdAttributeSetId()
    {
        return getAttributeSetAttributeUseId().getAttributeSetId();
    }

    protected void setAttributeSetAttributeUseIdAttributeSetId(String attributeSetAttributeUseIdAttributeSetId)
    {
        getAttributeSetAttributeUseId().setAttributeSetId(attributeSetAttributeUseIdAttributeSetId);
    }

    protected String getAttributeSetAttributeUseIdAttributeId()
    {
        return getAttributeSetAttributeUseId().getAttributeId();
    }

    protected void setAttributeSetAttributeUseIdAttributeId(String attributeSetAttributeUseIdAttributeId)
    {
        getAttributeSetAttributeUseId().setAttributeId(attributeSetAttributeUseIdAttributeId);
    }

    public AttributeUseMvoStateEventId()
    {
    }

    public AttributeUseMvoStateEventId(AttributeSetAttributeUseId attributeSetAttributeUseId, Long attributeSetVersion)
    {
        this.attributeSetAttributeUseId = attributeSetAttributeUseId;
        this.attributeSetVersion = attributeSetVersion;
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

        AttributeUseMvoStateEventId other = (AttributeUseMvoStateEventId)obj;
        return true 
            && (attributeSetAttributeUseId == other.attributeSetAttributeUseId || (attributeSetAttributeUseId != null && attributeSetAttributeUseId.equals(other.attributeSetAttributeUseId)))
            && (attributeSetVersion == other.attributeSetVersion || (attributeSetVersion != null && attributeSetVersion.equals(other.attributeSetVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.attributeSetAttributeUseId != null) {
            hash += 13 * this.attributeSetAttributeUseId.hashCode();
        }
        if (this.attributeSetVersion != null) {
            hash += 13 * this.attributeSetVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "attributeSetAttributeUseIdAttributeSetId",
            "attributeSetAttributeUseIdAttributeId",
            "attributeSetVersion",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
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

