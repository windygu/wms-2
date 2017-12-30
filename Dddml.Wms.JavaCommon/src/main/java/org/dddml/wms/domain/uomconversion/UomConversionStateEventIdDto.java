package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;

public class UomConversionStateEventIdDto
{

    public UomConversionStateEventIdDto()
    {
    }

    public UomConversionStateEventId toUomConversionStateEventId()
    {
        UomConversionStateEventId v = new UomConversionStateEventId();
        v.setUomConversionId(this.getUomConversionId().toUomConversionId());
        v.setVersion(this.getVersion());
        return v;
    }

    private UomConversionIdDto uomConversionId = new UomConversionIdDto();

    public UomConversionIdDto getUomConversionId()
    {
        return this.uomConversionId;
    }

    public void setUomConversionId(UomConversionIdDto uomConversionId)
    {
        this.uomConversionId = uomConversionId;
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
        if (obj == null || obj.getClass() != UomConversionStateEventIdDto.class) {
            return false;
        }

        UomConversionStateEventIdDto other = (UomConversionStateEventIdDto)obj;
        return true 
            && (getUomConversionId() == other.getUomConversionId() || (getUomConversionId() != null && getUomConversionId().equals(other.getUomConversionId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUomConversionId() != null) {
            hash += 13 * this.getUomConversionId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

