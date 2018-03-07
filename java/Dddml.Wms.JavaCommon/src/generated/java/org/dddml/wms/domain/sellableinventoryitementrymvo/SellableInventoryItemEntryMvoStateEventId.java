package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.io.Serializable;
import org.dddml.wms.domain.sellableinventoryitem.SellableInventoryItemEntryId;
import org.dddml.wms.domain.sellableinventoryitem.*;
import org.dddml.wms.domain.*;

public class SellableInventoryItemEntryMvoStateEventId implements Serializable
{
    private SellableInventoryItemEntryId sellableInventoryItemEntryId = new SellableInventoryItemEntryId();

    public SellableInventoryItemEntryId getSellableInventoryItemEntryId()
    {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryId sellableInventoryItemEntryId)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
    }

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
    }

    protected String getSellableInventoryItemEntryIdSellableInventoryItemIdProductId()
    {
        return getSellableInventoryItemEntryId().getSellableInventoryItemId().getProductId();
    }

    protected void setSellableInventoryItemEntryIdSellableInventoryItemIdProductId(String sellableInventoryItemEntryIdSellableInventoryItemIdProductId)
    {
        getSellableInventoryItemEntryId().getSellableInventoryItemId().setProductId(sellableInventoryItemEntryIdSellableInventoryItemIdProductId);
    }

    protected String getSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId()
    {
        return getSellableInventoryItemEntryId().getSellableInventoryItemId().getLocatorId();
    }

    protected void setSellableInventoryItemEntryIdSellableInventoryItemIdLocatorId(String sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId)
    {
        getSellableInventoryItemEntryId().getSellableInventoryItemId().setLocatorId(sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId);
    }

    protected String getSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId()
    {
        return getSellableInventoryItemEntryId().getSellableInventoryItemId().getAttributeSetInstanceId();
    }

    protected void setSellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId(String sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId)
    {
        getSellableInventoryItemEntryId().getSellableInventoryItemId().setAttributeSetInstanceId(sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId);
    }

    protected Long getSellableInventoryItemEntryIdEntrySeqId()
    {
        return getSellableInventoryItemEntryId().getEntrySeqId();
    }

    protected void setSellableInventoryItemEntryIdEntrySeqId(Long sellableInventoryItemEntryIdEntrySeqId)
    {
        getSellableInventoryItemEntryId().setEntrySeqId(sellableInventoryItemEntryIdEntrySeqId);
    }

    public SellableInventoryItemEntryMvoStateEventId()
    {
    }

    public SellableInventoryItemEntryMvoStateEventId(SellableInventoryItemEntryId sellableInventoryItemEntryId, Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
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

        SellableInventoryItemEntryMvoStateEventId other = (SellableInventoryItemEntryMvoStateEventId)obj;
        return true 
            && (sellableInventoryItemEntryId == other.sellableInventoryItemEntryId || (sellableInventoryItemEntryId != null && sellableInventoryItemEntryId.equals(other.sellableInventoryItemEntryId)))
            && (sellableInventoryItemVersion == other.sellableInventoryItemVersion || (sellableInventoryItemVersion != null && sellableInventoryItemVersion.equals(other.sellableInventoryItemVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.sellableInventoryItemEntryId != null) {
            hash += 13 * this.sellableInventoryItemEntryId.hashCode();
        }
        if (this.sellableInventoryItemVersion != null) {
            hash += 13 * this.sellableInventoryItemVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "sellableInventoryItemEntryIdSellableInventoryItemIdProductId",
            "sellableInventoryItemEntryIdSellableInventoryItemIdLocatorId",
            "sellableInventoryItemEntryIdSellableInventoryItemIdAttributeSetInstanceId",
            "sellableInventoryItemEntryIdEntrySeqId",
            "sellableInventoryItemVersion",
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

