package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ImportingShipmentItemDto
{

    public ImportingShipmentItemDto()
    {
    }

    public ImportingShipmentItem toImportingShipmentItem()
    {
        ImportingShipmentItem v = new ImportingShipmentItem();
        v.setProductId(this.getProductId());
        v.setQuantity(this.getQuantity());
        v.setTargetQuantity(this.getTargetQuantity());
        v.setShipmentContentDescription(this.getShipmentContentDescription());
        v.setAttributeSetInstance(this.getAttributeSetInstance());
        return v;
    }

    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private java.math.BigDecimal targetQuantity;

    public java.math.BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(java.math.BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
    }

    private String shipmentContentDescription;

    public String getShipmentContentDescription()
    {
        return this.shipmentContentDescription;
    }

    public void setShipmentContentDescription(String shipmentContentDescription)
    {
        this.shipmentContentDescription = shipmentContentDescription;
    }

    private java.util.Map<String, Object> attributeSetInstance;

    public java.util.Map<String, Object> getAttributeSetInstance()
    {
        return this.attributeSetInstance;
    }

    public void setAttributeSetInstance(java.util.Map<String, Object> attributeSetInstance)
    {
        this.attributeSetInstance = attributeSetInstance;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != ImportingShipmentItemDto.class) {
            return false;
        }

        ImportingShipmentItemDto other = (ImportingShipmentItemDto)obj;
        return true 
            && (getProductId() == other.getProductId() || (getProductId() != null && getProductId().equals(other.getProductId())))
            && (getQuantity() == other.getQuantity() || (getQuantity() != null && getQuantity().equals(other.getQuantity())))
            && (getTargetQuantity() == other.getTargetQuantity() || (getTargetQuantity() != null && getTargetQuantity().equals(other.getTargetQuantity())))
            && (getShipmentContentDescription() == other.getShipmentContentDescription() || (getShipmentContentDescription() != null && getShipmentContentDescription().equals(other.getShipmentContentDescription())))
            && (getAttributeSetInstance() == other.getAttributeSetInstance() || (getAttributeSetInstance() != null && getAttributeSetInstance().equals(other.getAttributeSetInstance())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getProductId() != null) {
            hash += 13 * this.getProductId().hashCode();
        }
        if (this.getQuantity() != null) {
            hash += 13 * this.getQuantity().hashCode();
        }
        if (this.getTargetQuantity() != null) {
            hash += 13 * this.getTargetQuantity().hashCode();
        }
        if (this.getShipmentContentDescription() != null) {
            hash += 13 * this.getShipmentContentDescription().hashCode();
        }
        if (this.getAttributeSetInstance() != null) {
            hash += 13 * this.getAttributeSetInstance().hashCode();
        }
        return hash;
    }

}

