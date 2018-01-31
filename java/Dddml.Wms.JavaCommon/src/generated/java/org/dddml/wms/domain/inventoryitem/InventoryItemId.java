package org.dddml.wms.domain.inventoryitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InventoryItemId implements Serializable
{
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

    public InventoryItemId()
    {
    }

    public InventoryItemId(String productId, String locatorId, String attributeSetInstanceId)
    {
        this.productId = productId;
        this.locatorId = locatorId;
        this.attributeSetInstanceId = attributeSetInstanceId;
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

        InventoryItemId other = (InventoryItemId)obj;
        return true 
            && (productId == other.productId || (productId != null && productId.equals(other.productId)))
            && (locatorId == other.locatorId || (locatorId != null && locatorId.equals(other.locatorId)))
            && (attributeSetInstanceId == other.attributeSetInstanceId || (attributeSetInstanceId != null && attributeSetInstanceId.equals(other.attributeSetInstanceId)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.productId != null) {
            hash += 13 * this.productId.hashCode();
        }
        if (this.locatorId != null) {
            hash += 13 * this.locatorId.hashCode();
        }
        if (this.attributeSetInstanceId != null) {
            hash += 13 * this.attributeSetInstanceId.hashCode();
        }
        return hash;
    }

}

