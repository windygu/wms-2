package org.dddml.wms.domain.itemissuancemvo;

import java.io.Serializable;
import org.dddml.wms.domain.shipment.ShipmentItemIssuanceId;
import org.dddml.wms.domain.shipment.*;
import org.dddml.wms.domain.*;

public class ItemIssuanceMvoEventId implements Serializable
{
    private ShipmentItemIssuanceId shipmentItemIssuanceId = new ShipmentItemIssuanceId();

    public ShipmentItemIssuanceId getShipmentItemIssuanceId()
    {
        return this.shipmentItemIssuanceId;
    }

    public void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId)
    {
        this.shipmentItemIssuanceId = shipmentItemIssuanceId;
    }

    private Long shipmentVersion;

    public Long getShipmentVersion()
    {
        return this.shipmentVersion;
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.shipmentVersion = shipmentVersion;
    }

    protected String getShipmentItemIssuanceIdShipmentId()
    {
        return getShipmentItemIssuanceId().getShipmentId();
    }

    protected void setShipmentItemIssuanceIdShipmentId(String shipmentItemIssuanceIdShipmentId)
    {
        getShipmentItemIssuanceId().setShipmentId(shipmentItemIssuanceIdShipmentId);
    }

    protected String getShipmentItemIssuanceIdItemIssuanceSeqId()
    {
        return getShipmentItemIssuanceId().getItemIssuanceSeqId();
    }

    protected void setShipmentItemIssuanceIdItemIssuanceSeqId(String shipmentItemIssuanceIdItemIssuanceSeqId)
    {
        getShipmentItemIssuanceId().setItemIssuanceSeqId(shipmentItemIssuanceIdItemIssuanceSeqId);
    }

    public ItemIssuanceMvoEventId()
    {
    }

    public ItemIssuanceMvoEventId(ShipmentItemIssuanceId shipmentItemIssuanceId, Long shipmentVersion)
    {
        this.shipmentItemIssuanceId = shipmentItemIssuanceId;
        this.shipmentVersion = shipmentVersion;
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

        ItemIssuanceMvoEventId other = (ItemIssuanceMvoEventId)obj;
        return true 
            && (shipmentItemIssuanceId == other.shipmentItemIssuanceId || (shipmentItemIssuanceId != null && shipmentItemIssuanceId.equals(other.shipmentItemIssuanceId)))
            && (shipmentVersion == other.shipmentVersion || (shipmentVersion != null && shipmentVersion.equals(other.shipmentVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.shipmentItemIssuanceId != null) {
            hash += 13 * this.shipmentItemIssuanceId.hashCode();
        }
        if (this.shipmentVersion != null) {
            hash += 13 * this.shipmentVersion.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "shipmentItemIssuanceIdShipmentId",
            "shipmentItemIssuanceIdItemIssuanceSeqId",
            "shipmentVersion",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
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

