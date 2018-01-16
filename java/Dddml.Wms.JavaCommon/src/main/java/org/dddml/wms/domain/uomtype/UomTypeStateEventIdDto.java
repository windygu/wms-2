package org.dddml.wms.domain.uomtype;

import org.dddml.wms.domain.*;

public class UomTypeStateEventIdDto
{

    public UomTypeStateEventIdDto()
    {
    }

    public UomTypeStateEventId toUomTypeStateEventId()
    {
        UomTypeStateEventId v = new UomTypeStateEventId();
        v.setUomTypeId(this.getUomTypeId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String uomTypeId;

    public String getUomTypeId()
    {
        return this.uomTypeId;
    }

    public void setUomTypeId(String uomTypeId)
    {
        this.uomTypeId = uomTypeId;
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
        if (obj == null || obj.getClass() != UomTypeStateEventIdDto.class) {
            return false;
        }

        UomTypeStateEventIdDto other = (UomTypeStateEventIdDto)obj;
        return true 
            && (getUomTypeId() == other.getUomTypeId() || (getUomTypeId() != null && getUomTypeId().equals(other.getUomTypeId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUomTypeId() != null) {
            hash += 13 * this.getUomTypeId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

