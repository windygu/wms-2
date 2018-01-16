package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;

public class UomConversionIdDtoWrapper extends UomConversionIdDto
{
	
    private UomConversionId value;

    public UomConversionIdDtoWrapper()
    {
        this(new UomConversionId());
    }

    public UomConversionIdDtoWrapper(UomConversionId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UomConversionId toUomConversionId()
    {
        return this.value;
    }

    @Override
    public String getUomId()
    {
        return this.value.getUomId();
    }

    @Override
    public void setUomId(String uomId)
    {
        this.value.setUomId(uomId);
    }

    @Override
    public String getUomIdTo()
    {
        return this.value.getUomIdTo();
    }

    @Override
    public void setUomIdTo(String uomIdTo)
    {
        this.value.setUomIdTo(uomIdTo);
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
        if (obj.getClass() == UomConversionIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UomConversionIdDtoWrapper other = (UomConversionIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

