package org.dddml.wms.domain.locator;

import org.dddml.wms.domain.*;

public class LocatorStateEventIdDto
{

    public LocatorStateEventIdDto()
    {
    }

    public LocatorStateEventId toLocatorStateEventId()
    {
        LocatorStateEventId v = new LocatorStateEventId();
        v.setLocatorId(this.getLocatorId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
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
        if (obj == null || obj.getClass() != LocatorStateEventIdDto.class) {
            return false;
        }

        LocatorStateEventIdDto other = (LocatorStateEventIdDto)obj;
        return true 
            && (getLocatorId() == other.getLocatorId() || (getLocatorId() != null && getLocatorId().equals(other.getLocatorId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getLocatorId() != null) {
            hash += 13 * this.getLocatorId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

