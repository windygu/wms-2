package org.dddml.wms.domain.uomtype;

import org.dddml.wms.domain.*;

public class UomTypeStateEventIdDtoWrapper extends UomTypeStateEventIdDto
{
	
    private UomTypeStateEventId value;

    public UomTypeStateEventIdDtoWrapper()
    {
        this(new UomTypeStateEventId());
    }

    public UomTypeStateEventIdDtoWrapper(UomTypeStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UomTypeStateEventId toUomTypeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getUomTypeId()
    {
        return this.value.getUomTypeId();
    }

    @Override
    public void setUomTypeId(String uomTypeId)
    {
        this.value.setUomTypeId(uomTypeId);
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
        if (obj.getClass() == UomTypeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UomTypeStateEventIdDtoWrapper other = (UomTypeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

