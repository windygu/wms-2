package org.dddml.wms.domain;


public class AudienceStateEventIdDtoWrapper extends AudienceStateEventIdDto
{
	
    private AudienceStateEventId value;

    public AudienceStateEventIdDtoWrapper()
    {
        this(new AudienceStateEventId());
    }

    public AudienceStateEventIdDtoWrapper(AudienceStateEventId value)
    {
        this.value = value;
    }

    public AudienceStateEventId toAudienceStateEventId()
    {
        return this.value;
    }

    @Override
    public String getClientId()
    {
        return this.value.getClientId();
    }

    @Override
    public void setClientId(String clientId)
    {
        this.value.setClientId(clientId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == AudienceStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        AudienceStateEventIdDtoWrapper other = (AudienceStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

