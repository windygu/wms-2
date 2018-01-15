package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;

public class SupplierProductIdDtoWrapper extends SupplierProductIdDto
{
	
    private SupplierProductId value;

    public SupplierProductIdDtoWrapper()
    {
        this(new SupplierProductId());
    }

    public SupplierProductIdDtoWrapper(SupplierProductId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public SupplierProductId toSupplierProductId()
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
    public String getPartyId()
    {
        return this.value.getPartyId();
    }

    @Override
    public void setPartyId(String partyId)
    {
        this.value.setPartyId(partyId);
    }

    @Override
    public String getCurrencyUomId()
    {
        return this.value.getCurrencyUomId();
    }

    @Override
    public void setCurrencyUomId(String currencyUomId)
    {
        this.value.setCurrencyUomId(currencyUomId);
    }

    @Override
    public java.math.BigDecimal getMinimumOrderQuantity()
    {
        return this.value.getMinimumOrderQuantity();
    }

    @Override
    public void setMinimumOrderQuantity(java.math.BigDecimal minimumOrderQuantity)
    {
        this.value.setMinimumOrderQuantity(minimumOrderQuantity);
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
        if (obj.getClass() == SupplierProductIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        SupplierProductIdDtoWrapper other = (SupplierProductIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

