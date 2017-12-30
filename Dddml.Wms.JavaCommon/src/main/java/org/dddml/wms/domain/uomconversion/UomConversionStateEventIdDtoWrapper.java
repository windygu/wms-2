package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;

public class UomConversionStateEventIdDtoWrapper extends UomConversionStateEventIdDto
{
	
    private UomConversionStateEventId value;

    public UomConversionStateEventIdDtoWrapper()
    {
        this(new UomConversionStateEventId());
    }

    public UomConversionStateEventIdDtoWrapper(UomConversionStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UomConversionStateEventId toUomConversionStateEventId()
    {
        return this.value;
    }

    @Override
    public UomConversionIdDto getUomConversionId()
    {
        return new UomConversionIdDtoWrapper(this.value.getUomConversionId());
    }

    @Override
    public void setUomConversionId(UomConversionIdDto uomConversionId)
    {
        this.value.setUomConversionId(uomConversionId.toUomConversionId());
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
        if (obj.getClass() == UomConversionStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UomConversionStateEventIdDtoWrapper other = (UomConversionStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

