package org.dddml.wms.domain.inventoryprtriggered;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryPRTriggeredEventId implements Serializable
{
    private InventoryPRTriggeredId inventoryPRTriggeredId = new InventoryPRTriggeredId();

    public InventoryPRTriggeredId getInventoryPRTriggeredId()
    {
        return this.inventoryPRTriggeredId;
    }

    public void setInventoryPRTriggeredId(InventoryPRTriggeredId inventoryPRTriggeredId)
    {
        this.inventoryPRTriggeredId = inventoryPRTriggeredId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    protected String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getProductId();
    }

    protected void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setProductId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId);
    }

    protected String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getLocatorId();
    }

    protected void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setLocatorId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId);
    }

    protected String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getAttributeSetInstanceId();
    }

    protected void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setAttributeSetInstanceId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId);
    }

    protected Long getInventoryPRTriggeredIdSourceEntryIdEntrySeqId()
    {
        return getInventoryPRTriggeredId().getSourceEntryId().getEntrySeqId();
    }

    protected void setInventoryPRTriggeredIdSourceEntryIdEntrySeqId(Long inventoryPRTriggeredIdSourceEntryIdEntrySeqId)
    {
        getInventoryPRTriggeredId().getSourceEntryId().setEntrySeqId(inventoryPRTriggeredIdSourceEntryIdEntrySeqId);
    }

    protected String getInventoryPRTriggeredIdInventoryPostingRuleId()
    {
        return getInventoryPRTriggeredId().getInventoryPostingRuleId();
    }

    protected void setInventoryPRTriggeredIdInventoryPostingRuleId(String inventoryPRTriggeredIdInventoryPostingRuleId)
    {
        getInventoryPRTriggeredId().setInventoryPostingRuleId(inventoryPRTriggeredIdInventoryPostingRuleId);
    }

    public InventoryPRTriggeredEventId()
    {
    }

    public InventoryPRTriggeredEventId(InventoryPRTriggeredId inventoryPRTriggeredId, Long version)
    {
        this.inventoryPRTriggeredId = inventoryPRTriggeredId;
        this.version = version;
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

        InventoryPRTriggeredEventId other = (InventoryPRTriggeredEventId)obj;
        return true 
            && (inventoryPRTriggeredId == other.inventoryPRTriggeredId || (inventoryPRTriggeredId != null && inventoryPRTriggeredId.equals(other.inventoryPRTriggeredId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryPRTriggeredId != null) {
            hash += 13 * this.inventoryPRTriggeredId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId",
            "inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId",
            "inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId",
            "inventoryPRTriggeredIdSourceEntryIdEntrySeqId",
            "inventoryPRTriggeredIdInventoryPostingRuleId",
            "version",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "String",
            "String",
            "Long",
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

