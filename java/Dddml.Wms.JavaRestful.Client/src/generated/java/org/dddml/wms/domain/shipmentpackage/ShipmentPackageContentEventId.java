package org.dddml.wms.domain.shipmentpackage;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class ShipmentPackageContentEventId implements Serializable
{
    private ShipmentPackageId shipmentPackageId = new ShipmentPackageId();

    public ShipmentPackageId getShipmentPackageId()
    {
        return this.shipmentPackageId;
    }

    public void setShipmentPackageId(ShipmentPackageId shipmentPackageId)
    {
        this.shipmentPackageId = shipmentPackageId;
    }

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
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

    protected String getShipmentPackageIdShipmentId()
    {
        return getShipmentPackageId().getShipmentId();
    }

    protected void setShipmentPackageIdShipmentId(String shipmentPackageIdShipmentId)
    {
        getShipmentPackageId().setShipmentId(shipmentPackageIdShipmentId);
    }

    protected String getShipmentPackageIdShipmentPackageSeqId()
    {
        return getShipmentPackageId().getShipmentPackageSeqId();
    }

    protected void setShipmentPackageIdShipmentPackageSeqId(String shipmentPackageIdShipmentPackageSeqId)
    {
        getShipmentPackageId().setShipmentPackageSeqId(shipmentPackageIdShipmentPackageSeqId);
    }

    public ShipmentPackageContentEventId()
    {
    }

    public ShipmentPackageContentEventId(ShipmentPackageId shipmentPackageId, String shipmentItemSeqId, Long shipmentPackageVersion)
    {
        this.shipmentPackageId = shipmentPackageId;
        this.shipmentItemSeqId = shipmentItemSeqId;
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

        ShipmentPackageContentEventId other = (ShipmentPackageContentEventId)obj;
        return true 
            && (shipmentPackageId == other.shipmentPackageId || (shipmentPackageId != null && shipmentPackageId.equals(other.shipmentPackageId)))
            && (shipmentItemSeqId == other.shipmentItemSeqId || (shipmentItemSeqId != null && shipmentItemSeqId.equals(other.shipmentItemSeqId)))
            && (shipmentPackageVersion == other.shipmentPackageVersion || (shipmentPackageVersion != null && shipmentPackageVersion.equals(other.shipmentPackageVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentPackageId != null) {
            hash += 13 * this.shipmentPackageId.hashCode();
        }
        if (this.shipmentItemSeqId != null) {
            hash += 13 * this.shipmentItemSeqId.hashCode();
        }
        if (this.shipmentPackageVersion != null) {
            hash += 13 * this.shipmentPackageVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "shipmentPackageIdShipmentId",
            "shipmentPackageIdShipmentPackageSeqId",
            "shipmentItemSeqId",
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

