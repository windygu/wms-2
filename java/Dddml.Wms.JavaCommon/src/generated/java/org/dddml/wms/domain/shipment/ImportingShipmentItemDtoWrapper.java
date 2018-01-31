package org.dddml.wms.domain.shipment;

import org.dddml.wms.domain.*;

public class ImportingShipmentItemDtoWrapper extends ImportingShipmentItemDto
{
	
    private ImportingShipmentItem value;

    public ImportingShipmentItemDtoWrapper()
    {
        this(new ImportingShipmentItem());
    }

    public ImportingShipmentItemDtoWrapper(ImportingShipmentItem value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public ImportingShipmentItem toImportingShipmentItem()
    {
        return this.value;
    }

    @Override
    public String getShipmentItemSeqId()
    {
        return this.value.getShipmentItemSeqId();
    }

    @Override
    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.value.setShipmentItemSeqId(shipmentItemSeqId);
    }

    @Override
    public String getProductId()
    {
        return this.value.getProductId();
    }

    @Override
    public void setProductId(String productId)
    {
        this.value.setProductId(productId);
    }

    @Override
    public java.math.BigDecimal getQuantity()
    {
        return this.value.getQuantity();
    }

    @Override
    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.value.setQuantity(quantity);
    }

    @Override
    public java.math.BigDecimal getTargetQuantity()
    {
        return this.value.getTargetQuantity();
    }

    @Override
    public void setTargetQuantity(java.math.BigDecimal targetQuantity)
    {
        this.value.setTargetQuantity(targetQuantity);
    }

    @Override
    public String getShipmentContentDescription()
    {
        return this.value.getShipmentContentDescription();
    }

    @Override
    public void setShipmentContentDescription(String shipmentContentDescription)
    {
        this.value.setShipmentContentDescription(shipmentContentDescription);
    }

    @Override
    public java.util.Map<String, Object> getAttributeSetInstance()
    {
        return this.value.getAttributeSetInstance();
    }

    @Override
    public void setAttributeSetInstance(java.util.Map<String, Object> attributeSetInstance)
    {
        this.value.setAttributeSetInstance(attributeSetInstance);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == ImportingShipmentItemDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ImportingShipmentItemDtoWrapper other = (ImportingShipmentItemDtoWrapper)obj;
        return value.equals(other.value);
    }

}

