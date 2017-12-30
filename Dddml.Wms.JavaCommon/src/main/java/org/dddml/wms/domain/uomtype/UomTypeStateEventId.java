package org.dddml.wms.domain.uomtype;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class UomTypeStateEventId implements Serializable
{
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

    public UomTypeStateEventId()
    {
    }

    public UomTypeStateEventId(String uomTypeId, Long version)
    {
        this.uomTypeId = uomTypeId;
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

        UomTypeStateEventId other = (UomTypeStateEventId)obj;
        return true 
            && (uomTypeId == other.uomTypeId || (uomTypeId != null && uomTypeId.equals(other.uomTypeId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.uomTypeId != null) {
            hash += 13 * this.uomTypeId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

