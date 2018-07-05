package org.dddml.wms.domain.inventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemEntryEventId implements Serializable
{
    private InventoryItemId inventoryItemId = new InventoryItemId();

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    private Long entrySeqId;

    public Long getEntrySeqId()
    {
        return this.entrySeqId;
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.entrySeqId = entrySeqId;
    }

    private Long inventoryItemVersion;

    public Long getInventoryItemVersion()
    {
        return this.inventoryItemVersion;
    }

    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.inventoryItemVersion = inventoryItemVersion;
    }

    protected String getInventoryItemIdProductId()
    {
        return getInventoryItemId().getProductId();
    }

    protected void setInventoryItemIdProductId(String inventoryItemIdProductId)
    {
        getInventoryItemId().setProductId(inventoryItemIdProductId);
    }

    protected String getInventoryItemIdLocatorId()
    {
        return getInventoryItemId().getLocatorId();
    }

    protected void setInventoryItemIdLocatorId(String inventoryItemIdLocatorId)
    {
        getInventoryItemId().setLocatorId(inventoryItemIdLocatorId);
    }

    protected String getInventoryItemIdAttributeSetInstanceId()
    {
        return getInventoryItemId().getAttributeSetInstanceId();
    }

    protected void setInventoryItemIdAttributeSetInstanceId(String inventoryItemIdAttributeSetInstanceId)
    {
        getInventoryItemId().setAttributeSetInstanceId(inventoryItemIdAttributeSetInstanceId);
    }

    public InventoryItemEntryEventId()
    {
    }

    public InventoryItemEntryEventId(InventoryItemId inventoryItemId, Long entrySeqId, Long inventoryItemVersion)
    {
        this.inventoryItemId = inventoryItemId;
        this.entrySeqId = entrySeqId;
        this.inventoryItemVersion = inventoryItemVersion;
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

        InventoryItemEntryEventId other = (InventoryItemEntryEventId)obj;
        return true 
            && (inventoryItemId == other.inventoryItemId || (inventoryItemId != null && inventoryItemId.equals(other.inventoryItemId)))
            && (entrySeqId == other.entrySeqId || (entrySeqId != null && entrySeqId.equals(other.entrySeqId)))
            && (inventoryItemVersion == other.inventoryItemVersion || (inventoryItemVersion != null && inventoryItemVersion.equals(other.inventoryItemVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemId != null) {
            hash += 13 * this.inventoryItemId.hashCode();
        }
        if (this.entrySeqId != null) {
            hash += 13 * this.entrySeqId.hashCode();
        }
        if (this.inventoryItemVersion != null) {
            hash += 13 * this.inventoryItemVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "inventoryItemIdProductId",
            "inventoryItemIdLocatorId",
            "inventoryItemIdAttributeSetInstanceId",
            "entrySeqId",
            "inventoryItemVersion",
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

