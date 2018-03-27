package org.dddml.wms.domain.picklistitemmvo;

import java.io.Serializable;
import org.dddml.wms.domain.picklistbin.PicklistBinPicklistItemId;
import org.dddml.wms.domain.picklistbin.*;
import org.dddml.wms.domain.*;

public class PicklistItemMvoEventId implements Serializable
{
    private PicklistBinPicklistItemId picklistBinPicklistItemId = new PicklistBinPicklistItemId();

    public PicklistBinPicklistItemId getPicklistBinPicklistItemId()
    {
        return this.picklistBinPicklistItemId;
    }

    public void setPicklistBinPicklistItemId(PicklistBinPicklistItemId picklistBinPicklistItemId)
    {
        this.picklistBinPicklistItemId = picklistBinPicklistItemId;
    }

    private Long picklistBinVersion;

    public Long getPicklistBinVersion()
    {
        return this.picklistBinVersion;
    }

    public void setPicklistBinVersion(Long picklistBinVersion)
    {
        this.picklistBinVersion = picklistBinVersion;
    }

    protected String getPicklistBinPicklistItemIdPicklistBinId()
    {
        return getPicklistBinPicklistItemId().getPicklistBinId();
    }

    protected void setPicklistBinPicklistItemIdPicklistBinId(String picklistBinPicklistItemIdPicklistBinId)
    {
        getPicklistBinPicklistItemId().setPicklistBinId(picklistBinPicklistItemIdPicklistBinId);
    }

    protected String getPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderId()
    {
        return getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().getOrderId();
    }

    protected void setPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderId(String picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderId)
    {
        getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().setOrderId(picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderId);
    }

    protected String getPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderItemSeqId()
    {
        return getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().getOrderItemSeqId();
    }

    protected void setPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderItemSeqId(String picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderItemSeqId)
    {
        getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().setOrderItemSeqId(picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderItemSeqId);
    }

    protected Long getPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdShipGroupSeqId()
    {
        return getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().getShipGroupSeqId();
    }

    protected void setPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdShipGroupSeqId(Long picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdShipGroupSeqId)
    {
        getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().setShipGroupSeqId(picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdShipGroupSeqId);
    }

    protected String getPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdProductId()
    {
        return getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().getProductId();
    }

    protected void setPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdProductId(String picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdProductId)
    {
        getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().setProductId(picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdProductId);
    }

    protected String getPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdLocatorId()
    {
        return getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().getLocatorId();
    }

    protected void setPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdLocatorId(String picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdLocatorId)
    {
        getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().setLocatorId(picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdLocatorId);
    }

    protected String getPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdAttributeSetInstanceId()
    {
        return getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().getAttributeSetInstanceId();
    }

    protected void setPicklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdAttributeSetInstanceId(String picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdAttributeSetInstanceId)
    {
        getPicklistBinPicklistItemId().getPicklistItemOrderShipGrpInvId().setAttributeSetInstanceId(picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdAttributeSetInstanceId);
    }

    public PicklistItemMvoEventId()
    {
    }

    public PicklistItemMvoEventId(PicklistBinPicklistItemId picklistBinPicklistItemId, Long picklistBinVersion)
    {
        this.picklistBinPicklistItemId = picklistBinPicklistItemId;
        this.picklistBinVersion = picklistBinVersion;
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

        PicklistItemMvoEventId other = (PicklistItemMvoEventId)obj;
        return true 
            && (picklistBinPicklistItemId == other.picklistBinPicklistItemId || (picklistBinPicklistItemId != null && picklistBinPicklistItemId.equals(other.picklistBinPicklistItemId)))
            && (picklistBinVersion == other.picklistBinVersion || (picklistBinVersion != null && picklistBinVersion.equals(other.picklistBinVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.picklistBinPicklistItemId != null) {
            hash += 13 * this.picklistBinPicklistItemId.hashCode();
        }
        if (this.picklistBinVersion != null) {
            hash += 13 * this.picklistBinVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "picklistBinPicklistItemIdPicklistBinId",
            "picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderId",
            "picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdOrderItemSeqId",
            "picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdShipGroupSeqId",
            "picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdProductId",
            "picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdLocatorId",
            "picklistBinPicklistItemIdPicklistItemOrderShipGrpInvIdAttributeSetInstanceId",
            "picklistBinVersion",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "String",
            "String",
            "Long",
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

