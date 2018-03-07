package org.dddml.wms.domain.organizationstructure;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class OrganizationStructureId implements Serializable
{
    private String organizationStructureTypeId;

    public String getOrganizationStructureTypeId()
    {
        return this.organizationStructureTypeId;
    }

    public void setOrganizationStructureTypeId(String organizationStructureTypeId)
    {
        this.organizationStructureTypeId = organizationStructureTypeId;
    }

    private String parentId;

    public String getParentId()
    {
        return this.parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    private String subsidiaryId;

    public String getSubsidiaryId()
    {
        return this.subsidiaryId;
    }

    public void setSubsidiaryId(String subsidiaryId)
    {
        this.subsidiaryId = subsidiaryId;
    }

    public OrganizationStructureId()
    {
    }

    public OrganizationStructureId(String organizationStructureTypeId, String parentId, String subsidiaryId)
    {
        this.organizationStructureTypeId = organizationStructureTypeId;
        this.parentId = parentId;
        this.subsidiaryId = subsidiaryId;
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

        OrganizationStructureId other = (OrganizationStructureId)obj;
        return true 
            && (organizationStructureTypeId == other.organizationStructureTypeId || (organizationStructureTypeId != null && organizationStructureTypeId.equals(other.organizationStructureTypeId)))
            && (parentId == other.parentId || (parentId != null && parentId.equals(other.parentId)))
            && (subsidiaryId == other.subsidiaryId || (subsidiaryId != null && subsidiaryId.equals(other.subsidiaryId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.organizationStructureTypeId != null) {
            hash += 13 * this.organizationStructureTypeId.hashCode();
        }
        if (this.parentId != null) {
            hash += 13 * this.parentId.hashCode();
        }
        if (this.subsidiaryId != null) {
            hash += 13 * this.subsidiaryId.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "organizationStructureTypeId",
            "parentId",
            "subsidiaryId",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "String",
            "String",
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

