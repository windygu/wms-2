package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;

public class UomConversionIdDto
{

    public UomConversionIdDto()
    {
    }

    public UomConversionId toUomConversionId()
    {
        UomConversionId v = new UomConversionId();
        v.setUomId(this.getUomId());
        v.setUomIdTo(this.getUomIdTo());
        return v;
    }

    private String uomId;

    public String getUomId()
    {
        return this.uomId;
    }

    public void setUomId(String uomId)
    {
        this.uomId = uomId;
    }

    private String uomIdTo;

    public String getUomIdTo()
    {
        return this.uomIdTo;
    }

    public void setUomIdTo(String uomIdTo)
    {
        this.uomIdTo = uomIdTo;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != UomConversionIdDto.class) {
            return false;
        }

        UomConversionIdDto other = (UomConversionIdDto)obj;
        return true 
            && (getUomId() == other.getUomId() || (getUomId() != null && getUomId().equals(other.getUomId())))
            && (getUomIdTo() == other.getUomIdTo() || (getUomIdTo() != null && getUomIdTo().equals(other.getUomIdTo())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUomId() != null) {
            hash += 13 * this.getUomId().hashCode();
        }
        if (this.getUomIdTo() != null) {
            hash += 13 * this.getUomIdTo().hashCode();
        }
        return hash;
    }

}

