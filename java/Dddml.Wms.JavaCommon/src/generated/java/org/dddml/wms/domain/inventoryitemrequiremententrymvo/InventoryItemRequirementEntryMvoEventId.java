package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryId;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.*;

public class InventoryItemRequirementEntryMvoEventId implements Serializable
{
    private InventoryItemRequirementEntryId inventoryItemRequirementEntryId = new InventoryItemRequirementEntryId();

    public InventoryItemRequirementEntryId getInventoryItemRequirementEntryId()
    {
        return this.inventoryItemRequirementEntryId;
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId)
    {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
    }

    private Long inventoryItemRequirementVersion;

    public Long getInventoryItemRequirementVersion()
    {
        return this.inventoryItemRequirementVersion;
    }

    public void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementVersion = inventoryItemRequirementVersion;
    }

    protected String getInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId()
    {
        return getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getProductId();
    }

    protected void setInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId)
    {
        getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setProductId(inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId);
    }

    protected String getInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId()
    {
        return getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getLocatorId();
    }

    protected void setInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId)
    {
        getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setLocatorId(inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId);
    }

    protected String getInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId()
    {
        return getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getAttributeSetInstanceId();
    }

    protected void setInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId)
    {
        getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setAttributeSetInstanceId(inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId);
    }

    protected Long getInventoryItemRequirementEntryIdEntrySeqId()
    {
        return getInventoryItemRequirementEntryId().getEntrySeqId();
    }

    protected void setInventoryItemRequirementEntryIdEntrySeqId(Long inventoryItemRequirementEntryIdEntrySeqId)
    {
        getInventoryItemRequirementEntryId().setEntrySeqId(inventoryItemRequirementEntryIdEntrySeqId);
    }

    public InventoryItemRequirementEntryMvoEventId()
    {
    }

    public InventoryItemRequirementEntryMvoEventId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId, Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
        this.inventoryItemRequirementVersion = inventoryItemRequirementVersion;
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

        InventoryItemRequirementEntryMvoEventId other = (InventoryItemRequirementEntryMvoEventId)obj;
        return true 
            && (inventoryItemRequirementEntryId == other.inventoryItemRequirementEntryId || (inventoryItemRequirementEntryId != null && inventoryItemRequirementEntryId.equals(other.inventoryItemRequirementEntryId)))
            && (inventoryItemRequirementVersion == other.inventoryItemRequirementVersion || (inventoryItemRequirementVersion != null && inventoryItemRequirementVersion.equals(other.inventoryItemRequirementVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemRequirementEntryId != null) {
            hash += 13 * this.inventoryItemRequirementEntryId.hashCode();
        }
        if (this.inventoryItemRequirementVersion != null) {
            hash += 13 * this.inventoryItemRequirementVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId",
            "inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId",
            "inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId",
            "inventoryItemRequirementEntryIdEntrySeqId",
            "inventoryItemRequirementVersion",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "String",
            "String",
            "Long",
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

