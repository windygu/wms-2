package org.dddml.wms.domain;


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
            && (locatorId == other.locatorId || (locatorId != null && locatorId.equals(other.locatorId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.locatorId != null) {
            hash += 13 * this.locatorId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

