package org.dddml.wms.domain.inventoryitementrymvo;

import java.io.Serializable;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryId;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;

public class InventoryItemEntryMvoStateEventId implements Serializable
{
    private InventoryItemEntryId inventoryItemEntryId = new InventoryItemEntryId();

    public InventoryItemEntryId getInventoryItemEntryId()
    {
        return this.inventoryItemEntryId;
    }

    public void setInventoryItemEntryId(InventoryItemEntryId inventoryItemEntryId)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
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

    protected String getInventoryItemEntryIdInventoryItemIdProductId()
    {
        return getInventoryItemEntryId().getInventoryItemId().getProductId();
    }

    protected void setInventoryItemEntryIdInventoryItemIdProductId(String inventoryItemEntryIdInventoryItemIdProductId)
    {
        getInventoryItemEntryId().getInventoryItemId().setProductId(inventoryItemEntryIdInventoryItemIdProductId);
    }

    protected String getInventoryItemEntryIdInventoryItemIdLocatorId()
    {
        return getInventoryItemEntryId().getInventoryItemId().getLocatorId();
    }

    protected void setInventoryItemEntryIdInventoryItemIdLocatorId(String inventoryItemEntryIdInventoryItemIdLocatorId)
    {
        getInventoryItemEntryId().getInventoryItemId().setLocatorId(inventoryItemEntryIdInventoryItemIdLocatorId);
    }

    protected String getInventoryItemEntryIdInventoryItemIdAttributeSetInstanceId()
    {
        return getInventoryItemEntryId().getInventoryItemId().getAttributeSetInstanceId();
    }

    protected void setInventoryItemEntryIdInventoryItemIdAttributeSetInstanceId(String inventoryItemEntryIdInventoryItemIdAttributeSetInstanceId)
    {
        getInventoryItemEntryId().getInventoryItemId().setAttributeSetInstanceId(inventoryItemEntryIdInventoryItemIdAttributeSetInstanceId);
    }

    protected Long getInventoryItemEntryIdEntrySeqId()
    {
        return getInventoryItemEntryId().getEntrySeqId();
    }

    protected void setInventoryItemEntryIdEntrySeqId(Long inventoryItemEntryIdEntrySeqId)
    {
        getInventoryItemEntryId().setEntrySeqId(inventoryItemEntryIdEntrySeqId);
    }

    public InventoryItemEntryMvoStateEventId()
    {
    }

    public InventoryItemEntryMvoStateEventId(InventoryItemEntryId inventoryItemEntryId, Long inventoryItemVersion)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
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

        InventoryItemEntryMvoStateEventId other = (InventoryItemEntryMvoStateEventId)obj;
        return true 
            && (inventoryItemEntryId == other.inventoryItemEntryId || (inventoryItemEntryId != null && inventoryItemEntryId.equals(other.inventoryItemEntryId)))
            && (inventoryItemVersion == other.inventoryItemVersion || (inventoryItemVersion != null && inventoryItemVersion.equals(other.inventoryItemVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inventoryItemEntryId != null) {
            hash += 13 * this.inventoryItemEntryId.hashCode();
        }
        if (this.inventoryItemVersion != null) {
            hash += 13 * this.inventoryItemVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "inventoryItemEntryIdInventoryItemIdProductId",
            "inventoryItemEntryIdInventoryItemIdLocatorId",
            "inventoryItemEntryIdInventoryItemIdAttributeSetInstanceId",
            "inventoryItemEntryIdEntrySeqId",
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

