package org.dddml.wms.domain.inventoryitem;

import org.dddml.wms.domain.*;

public class InventoryItemIdDto
{

    public InventoryItemIdDto()
    {
    }

    public InventoryItemId toInventoryItemId()
    {
        InventoryItemId v = new InventoryItemId();
        v.setProductId(this.getProductId());
        v.setLocatorId(this.getLocatorId());
        v.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
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

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
    }

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InventoryItemIdDto.class) {
            return false;
        }

        InventoryItemIdDto other = (InventoryItemIdDto)obj;
        return true 
            && (getProductId() == other.getProductId() || (getProductId() != null && getProductId().equals(other.getProductId())))
            && (getLocatorId() == other.getLocatorId() || (getLocatorId() != null && getLocatorId().equals(other.getLocatorId())))
            && (getAttributeSetInstanceId() == other.getAttributeSetInstanceId() || (getAttributeSetInstanceId() != null && getAttributeSetInstanceId().equals(other.getAttributeSetInstanceId())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getProductId() != null) {
            hash += 13 * this.getProductId().hashCode();
        }
        if (this.getLocatorId() != null) {
            hash += 13 * this.getLocatorId().hashCode();
        }
        if (this.getAttributeSetInstanceId() != null) {
            hash += 13 * this.getAttributeSetInstanceId().hashCode();
        }
        return hash;
    }

}

