package org.dddml.wms.domain.supplierproduct;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class SupplierProductId implements Serializable
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

    private String partyId;

    public String getPartyId()
    {
        return this.partyId;
    }

    public void setPartyId(String partyId)
    {
        this.partyId = partyId;
    }

    private String currencyUomId;

    public String getCurrencyUomId()
    {
        return this.currencyUomId;
    }

    public void setCurrencyUomId(String currencyUomId)
    {
        this.currencyUomId = currencyUomId;
    }

    private java.math.BigDecimal minimumOrderQuantity;

    public java.math.BigDecimal getMinimumOrderQuantity()
    {
        return this.minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(java.math.BigDecimal minimumOrderQuantity)
    {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public SupplierProductId()
    {
    }

    public SupplierProductId(String productId, String partyId, String currencyUomId, java.math.BigDecimal minimumOrderQuantity)
    {
        this.productId = productId;
        this.partyId = partyId;
        this.currencyUomId = currencyUomId;
        this.minimumOrderQuantity = minimumOrderQuantity;
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

        SupplierProductId other = (SupplierProductId)obj;
        return true 
            && (productId == other.productId || (productId != null && productId.equals(other.productId)))
            && (partyId == other.partyId || (partyId != null && partyId.equals(other.partyId)))
            && (currencyUomId == other.currencyUomId || (currencyUomId != null && currencyUomId.equals(other.currencyUomId)))
            && (minimumOrderQuantity == other.minimumOrderQuantity || (minimumOrderQuantity != null && minimumOrderQuantity.equals(other.minimumOrderQuantity)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.productId != null) {
            hash += 13 * this.productId.hashCode();
        }
        if (this.partyId != null) {
            hash += 13 * this.partyId.hashCode();
        }
        if (this.currencyUomId != null) {
            hash += 13 * this.currencyUomId.hashCode();
        }
        if (this.minimumOrderQuantity != null) {
            hash += 13 * this.minimumOrderQuantity.hashCode();
        }
        return hash;
    }

}

