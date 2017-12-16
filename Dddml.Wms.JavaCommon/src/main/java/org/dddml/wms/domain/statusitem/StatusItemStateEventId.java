package org.dddml.wms.domain.statusitem;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class StatusItemStateEventId implements Serializable
{
    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
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

    public StatusItemStateEventId()
    {
    }

    public StatusItemStateEventId(String statusId, Long version)
    {
        this.statusId = statusId;
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

        StatusItemStateEventId other = (StatusItemStateEventId)obj;
        return true 
            && (statusId == other.statusId || (statusId != null && statusId.equals(other.statusId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.statusId != null) {
            hash += 13 * this.statusId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

