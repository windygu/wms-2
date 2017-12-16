package org.dddml.wms.domain.supplierproduct;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class SupplierProductStateEventId implements Serializable
{
    private SupplierProductId supplierProductId = new SupplierProductId();

    public SupplierProductId getSupplierProductId()
    {
        return this.supplierProductId;
    }

    public void setSupplierProductId(SupplierProductId supplierProductId)
    {
        this.supplierProductId = supplierProductId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public String getSupplierProductIdProductId()
    {
        return getSupplierProductId().getProductId();
    }

    public void setSupplierProductIdProductId(String supplierProductIdProductId)
    {
        getSupplierProductId().setProductId(supplierProductIdProductId);
    }

    public String getSupplierProductIdPartyId()
    {
        return getSupplierProductId().getPartyId();
    }

    public void setSupplierProductIdPartyId(String supplierProductIdPartyId)
    {
        getSupplierProductId().setPartyId(supplierProductIdPartyId);
    }

    public String getSupplierProductIdCurrencyUomId()
    {
        return getSupplierProductId().getCurrencyUomId();
    }

    public void setSupplierProductIdCurrencyUomId(String supplierProductIdCurrencyUomId)
    {
        getSupplierProductId().setCurrencyUomId(supplierProductIdCurrencyUomId);
    }

    public java.math.BigDecimal getSupplierProductIdMinimumOrderQuantity()
    {
        return getSupplierProductId().getMinimumOrderQuantity();
    }

    public void setSupplierProductIdMinimumOrderQuantity(java.math.BigDecimal supplierProductIdMinimumOrderQuantity)
    {
        getSupplierProductId().setMinimumOrderQuantity(supplierProductIdMinimumOrderQuantity);
    }

    public SupplierProductStateEventId()
    {
    }

    public SupplierProductStateEventId(SupplierProductId supplierProductId, Long version)
    {
        this.supplierProductId = supplierProductId;
        this.version = version;
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

        SupplierProductStateEventId other = (SupplierProductStateEventId)obj;
        return true 
            && (supplierProductId == other.supplierProductId || (supplierProductId != null && supplierProductId.equals(other.supplierProductId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.supplierProductId != null) {
            hash += 13 * this.supplierProductId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

