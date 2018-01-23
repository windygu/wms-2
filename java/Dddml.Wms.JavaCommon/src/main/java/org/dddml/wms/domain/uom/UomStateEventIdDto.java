package org.dddml.wms.domain.uom;

import org.dddml.wms.domain.*;

public class UomStateEventIdDto
{

    public UomStateEventIdDto()
    {
    }

    public UomStateEventId toUomStateEventId()
    {
        UomStateEventId v = new UomStateEventId();
        v.setUomId(this.getUomId());
        v.setVersion(this.getVersion());
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
        if (obj == null || obj.getClass() != UomStateEventIdDto.class) {
            return false;
        }

        UomStateEventIdDto other = (UomStateEventIdDto)obj;
        return true 
            && (getUomId() == other.getUomId() || (getUomId() != null && getUomId().equals(other.getUomId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUomId() != null) {
            hash += 13 * this.getUomId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

