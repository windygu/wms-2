package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;

public class SupplierProductStateEventIdDto
{

    public SupplierProductStateEventIdDto()
    {
    }

    public SupplierProductStateEventId toSupplierProductStateEventId()
    {
        SupplierProductStateEventId v = new SupplierProductStateEventId();
        v.setSupplierProductId(this.getSupplierProductId().toSupplierProductId());
        v.setVersion(this.getVersion());
        return v;
    }

    private SupplierProductIdDto supplierProductId = new SupplierProductIdDto();

    public SupplierProductIdDto getSupplierProductId()
    {
        return this.supplierProductId;
    }

    public void setSupplierProductId(SupplierProductIdDto supplierProductId)
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != SupplierProductStateEventIdDto.class) {
            return false;
        }

        SupplierProductStateEventIdDto other = (SupplierProductStateEventIdDto)obj;
        return true 
            && (getSupplierProductId() == other.getSupplierProductId() || (getSupplierProductId() != null && getSupplierProductId().equals(other.getSupplierProductId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getSupplierProductId() != null) {
            hash += 13 * this.getSupplierProductId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

