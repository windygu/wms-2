package org.dddml.wms.domain;


public class AudienceStateEventIdDto
{

    public AudienceStateEventIdDto()
    {
    }

    public AudienceStateEventId toAudienceStateEventId()
    {
        AudienceStateEventId v = new AudienceStateEventId();
        v.setClientId(this.getClientId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String clientId;

    public String getClientId()
    {
        return this.clientId;
    }

    public void setClientId(String clientId)
    {
        this.clientId = clientId;
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
        if (obj == null || obj.getClass() != AudienceStateEventIdDto.class) {
            return false;
        }

        AudienceStateEventIdDto other = (AudienceStateEventIdDto)obj;
        return true 
            && (getClientId() == other.getClientId() || (getClientId() != null && getClientId().equals(other.getClientId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getClientId() != null) {
            hash += 13 * this.getClientId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

