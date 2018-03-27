package org.dddml.wms.domain.shipmentpackagecontentmvo;

import java.io.Serializable;
import org.dddml.wms.domain.shipmentpackage.ShipmentPackageContentId;
import org.dddml.wms.domain.shipmentpackage.*;
import org.dddml.wms.domain.*;

public class ShipmentPackageContentMvoEventId implements Serializable
{
    private ShipmentPackageContentId shipmentPackageContentId = new ShipmentPackageContentId();

    public ShipmentPackageContentId getShipmentPackageContentId()
    {
        return this.shipmentPackageContentId;
    }

    public void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId)
    {
        this.shipmentPackageContentId = shipmentPackageContentId;
    }

    private Long shipmentPackageVersion;

    public Long getShipmentPackageVersion()
    {
        return this.shipmentPackageVersion;
    }

    public void setShipmentPackageVersion(Long shipmentPackageVersion)
    {
        this.shipmentPackageVersion = shipmentPackageVersion;
    }

    protected String getShipmentPackageContentIdShipmentPackageIdShipmentId()
    {
        return getShipmentPackageContentId().getShipmentPackageId().getShipmentId();
    }

    protected void setShipmentPackageContentIdShipmentPackageIdShipmentId(String shipmentPackageContentIdShipmentPackageIdShipmentId)
    {
        getShipmentPackageContentId().getShipmentPackageId().setShipmentId(shipmentPackageContentIdShipmentPackageIdShipmentId);
    }

    protected String getShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId()
    {
        return getShipmentPackageContentId().getShipmentPackageId().getShipmentPackageSeqId();
    }

    protected void setShipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId(String shipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId)
    {
        getShipmentPackageContentId().getShipmentPackageId().setShipmentPackageSeqId(shipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId);
    }

    protected String getShipmentPackageContentIdShipmentItemSeqId()
    {
        return getShipmentPackageContentId().getShipmentItemSeqId();
    }

    protected void setShipmentPackageContentIdShipmentItemSeqId(String shipmentPackageContentIdShipmentItemSeqId)
    {
        getShipmentPackageContentId().setShipmentItemSeqId(shipmentPackageContentIdShipmentItemSeqId);
    }

    public ShipmentPackageContentMvoEventId()
    {
    }

    public ShipmentPackageContentMvoEventId(ShipmentPackageContentId shipmentPackageContentId, Long shipmentPackageVersion)
    {
        this.shipmentPackageContentId = shipmentPackageContentId;
        this.shipmentPackageVersion = shipmentPackageVersion;
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

        ShipmentPackageContentMvoEventId other = (ShipmentPackageContentMvoEventId)obj;
        return true 
            && (shipmentPackageContentId == other.shipmentPackageContentId || (shipmentPackageContentId != null && shipmentPackageContentId.equals(other.shipmentPackageContentId)))
            && (shipmentPackageVersion == other.shipmentPackageVersion || (shipmentPackageVersion != null && shipmentPackageVersion.equals(other.shipmentPackageVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentPackageContentId != null) {
            hash += 13 * this.shipmentPackageContentId.hashCode();
        }
        if (this.shipmentPackageVersion != null) {
            hash += 13 * this.shipmentPackageVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "shipmentPackageContentIdShipmentPackageIdShipmentId",
            "shipmentPackageContentIdShipmentPackageIdShipmentPackageSeqId",
            "shipmentPackageContentIdShipmentItemSeqId",
            "shipmentPackageVersion",
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

