package org.dddml.wms.domain.uom;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class UomStateEventId implements Serializable
{
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

    public UomStateEventId()
    {
    }

    public UomStateEventId(String uomId, Long version)
    {
        this.uomId = uomId;
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

        UomStateEventId other = (UomStateEventId)obj;
        return true 
            && (uomId == other.uomId || (uomId != null && uomId.equals(other.uomId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.uomId != null) {
            hash += 13 * this.uomId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

