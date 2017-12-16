package org.dddml.wms.domain.supplierproduct;

import org.dddml.wms.domain.*;

public class SupplierProductStateEventIdDtoWrapper extends SupplierProductStateEventIdDto
{
	
    private SupplierProductStateEventId value;

    public SupplierProductStateEventIdDtoWrapper()
    {
        this(new SupplierProductStateEventId());
    }

    public SupplierProductStateEventIdDtoWrapper(SupplierProductStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public SupplierProductStateEventId toSupplierProductStateEventId()
    {
        return this.value;
    }

    @Override
    public SupplierProductIdDto getSupplierProductId()
    {
        return new SupplierProductIdDtoWrapper(this.value.getSupplierProductId());
    }

    @Override
    public void setSupplierProductId(SupplierProductIdDto supplierProductId)
    {
        this.value.setSupplierProductId(supplierProductId.toSupplierProductId());
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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
        if (obj.getClass() == SupplierProductStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        SupplierProductStateEventIdDtoWrapper other = (SupplierProductStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

