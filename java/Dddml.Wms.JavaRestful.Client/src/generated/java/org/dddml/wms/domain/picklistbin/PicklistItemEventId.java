package org.dddml.wms.domain.picklistbin;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class PicklistItemEventId implements Serializable
{
    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
    }

    private PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId = new PicklistItemOrderShipGrpInvId();

    public PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId()
    {
        return this.picklistItemOrderShipGrpInvId;
    }

    public void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
    {
        this.picklistItemOrderShipGrpInvId = picklistItemOrderShipGrpInvId;
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

    protected String getPicklistItemOrderShipGrpInvIdOrderId()
    {
        return getPicklistItemOrderShipGrpInvId().getOrderId();
    }

    protected void setPicklistItemOrderShipGrpInvIdOrderId(String picklistItemOrderShipGrpInvIdOrderId)
    {
        getPicklistItemOrderShipGrpInvId().setOrderId(picklistItemOrderShipGrpInvIdOrderId);
    }

    protected String getPicklistItemOrderShipGrpInvIdOrderItemSeqId()
    {
        return getPicklistItemOrderShipGrpInvId().getOrderItemSeqId();
    }

    protected void setPicklistItemOrderShipGrpInvIdOrderItemSeqId(String picklistItemOrderShipGrpInvIdOrderItemSeqId)
    {
        getPicklistItemOrderShipGrpInvId().setOrderItemSeqId(picklistItemOrderShipGrpInvIdOrderItemSeqId);
    }

    protected String getPicklistItemOrderShipGrpInvIdShipGroupSeqId()
    {
        return getPicklistItemOrderShipGrpInvId().getShipGroupSeqId();
    }

    protected void setPicklistItemOrderShipGrpInvIdShipGroupSeqId(String picklistItemOrderShipGrpInvIdShipGroupSeqId)
    {
        getPicklistItemOrderShipGrpInvId().setShipGroupSeqId(picklistItemOrderShipGrpInvIdShipGroupSeqId);
    }

    protected String getPicklistItemOrderShipGrpInvIdProductId()
    {
        return getPicklistItemOrderShipGrpInvId().getProductId();
    }

    protected void setPicklistItemOrderShipGrpInvIdProductId(String picklistItemOrderShipGrpInvIdProductId)
    {
        getPicklistItemOrderShipGrpInvId().setProductId(picklistItemOrderShipGrpInvIdProductId);
    }

    protected String getPicklistItemOrderShipGrpInvIdLocatorId()
    {
        return getPicklistItemOrderShipGrpInvId().getLocatorId();
    }

    protected void setPicklistItemOrderShipGrpInvIdLocatorId(String picklistItemOrderShipGrpInvIdLocatorId)
    {
        getPicklistItemOrderShipGrpInvId().setLocatorId(picklistItemOrderShipGrpInvIdLocatorId);
    }

    protected String getPicklistItemOrderShipGrpInvIdAttributeSetInstanceId()
    {
        return getPicklistItemOrderShipGrpInvId().getAttributeSetInstanceId();
    }

    protected void setPicklistItemOrderShipGrpInvIdAttributeSetInstanceId(String picklistItemOrderShipGrpInvIdAttributeSetInstanceId)
    {
        getPicklistItemOrderShipGrpInvId().setAttributeSetInstanceId(picklistItemOrderShipGrpInvIdAttributeSetInstanceId);
    }

    public PicklistItemEventId()
    {
    }

    public PicklistItemEventId(String picklistBinId, PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId, Long picklistBinVersion)
    {
        this.picklistBinId = picklistBinId;
        this.picklistItemOrderShipGrpInvId = picklistItemOrderShipGrpInvId;
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

        PicklistItemEventId other = (PicklistItemEventId)obj;
        return true 
            && (picklistBinId == other.picklistBinId || (picklistBinId != null && picklistBinId.equals(other.picklistBinId)))
            && (picklistItemOrderShipGrpInvId == other.picklistItemOrderShipGrpInvId || (picklistItemOrderShipGrpInvId != null && picklistItemOrderShipGrpInvId.equals(other.picklistItemOrderShipGrpInvId)))
            && (picklistBinVersion == other.picklistBinVersion || (picklistBinVersion != null && picklistBinVersion.equals(other.picklistBinVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.picklistBinId != null) {
            hash += 13 * this.picklistBinId.hashCode();
        }
        if (this.picklistItemOrderShipGrpInvId != null) {
            hash += 13 * this.picklistItemOrderShipGrpInvId.hashCode();
        }
        if (this.picklistBinVersion != null) {
            hash += 13 * this.picklistBinVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "picklistBinId",
            "picklistItemOrderShipGrpInvIdOrderId",
            "picklistItemOrderShipGrpInvIdOrderItemSeqId",
            "picklistItemOrderShipGrpInvIdShipGroupSeqId",
            "picklistItemOrderShipGrpInvIdProductId",
            "picklistItemOrderShipGrpInvIdLocatorId",
            "picklistItemOrderShipGrpInvIdAttributeSetInstanceId",
            "picklistBinVersion",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "String",
            "String",
            "String",
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

