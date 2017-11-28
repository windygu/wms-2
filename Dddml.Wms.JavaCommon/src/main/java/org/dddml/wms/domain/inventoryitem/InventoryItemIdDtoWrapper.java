package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemIdDtoWrapper extends InventoryItemIdDto
{
	
    private InventoryItemId value;

    public InventoryItemIdDtoWrapper()
    {
        this(new InventoryItemId());
    }

    public InventoryItemIdDtoWrapper(InventoryItemId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InventoryItemId toInventoryItemId()
    {
        return this.value;
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
    public String getLocatorId()
    {
        return this.value.getLocatorId();
    }

    @Override
    public void setLocatorId(String locatorId)
    {
        this.value.setLocatorId(locatorId);
    }

    @Override
    public String getAttributeSetInstance()
    {
        return this.value.getAttributeSetInstance();
    }

    @Override
    public void setAttributeSetInstance(String attributeSetInstance)
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
        if (obj.getClass() == InventoryItemIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryItemIdDtoWrapper other = (InventoryItemIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

