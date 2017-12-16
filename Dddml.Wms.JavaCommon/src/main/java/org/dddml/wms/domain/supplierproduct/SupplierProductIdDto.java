package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;

public class SupplierProductIdDto
{

    public SupplierProductIdDto()
    {
    }

    public SupplierProductId toSupplierProductId()
    {
        SupplierProductId v = new SupplierProductId();
        v.setProductId(this.getProductId());
        v.setPartyId(this.getPartyId());
        v.setCurrencyUomId(this.getCurrencyUomId());
        v.setMinimumOrderQuantity(this.getMinimumOrderQuantity());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SupplierProductIdDto.class) {
            return false;
        }

        SupplierProductIdDto other = (SupplierProductIdDto)obj;
        return true 
            && (getProductId() == other.getProductId() || (getProductId() != null && getProductId().equals(other.getProductId())))
            && (getPartyId() == other.getPartyId() || (getPartyId() != null && getPartyId().equals(other.getPartyId())))
            && (getCurrencyUomId() == other.getCurrencyUomId() || (getCurrencyUomId() != null && getCurrencyUomId().equals(other.getCurrencyUomId())))
            && (getMinimumOrderQuantity() == other.getMinimumOrderQuantity() || (getMinimumOrderQuantity() != null && getMinimumOrderQuantity().equals(other.getMinimumOrderQuantity())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getProductId() != null) {
            hash += 13 * this.getProductId().hashCode();
        }
        if (this.getPartyId() != null) {
            hash += 13 * this.getPartyId().hashCode();
        }
        if (this.getCurrencyUomId() != null) {
            hash += 13 * this.getCurrencyUomId().hashCode();
        }
        if (this.getMinimumOrderQuantity() != null) {
            hash += 13 * this.getMinimumOrderQuantity().hashCode();
        }
        return hash;
    }

}

