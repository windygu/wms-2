package org.dddml.wms.domain.statusitem;

import org.dddml.wms.domain.*;

public class StatusItemStateEventIdDto
{

    public StatusItemStateEventIdDto()
    {
    }

    public StatusItemStateEventId toStatusItemStateEventId()
    {
        StatusItemStateEventId v = new StatusItemStateEventId();
        v.setStatusId(this.getStatusId());
        v.setVersion(this.getVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != StatusItemStateEventIdDto.class) {
            return false;
        }

        StatusItemStateEventIdDto other = (StatusItemStateEventIdDto)obj;
        return true 
            && (getStatusId() == other.getStatusId() || (getStatusId() != null && getStatusId().equals(other.getStatusId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getStatusId() != null) {
            hash += 13 * this.getStatusId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

