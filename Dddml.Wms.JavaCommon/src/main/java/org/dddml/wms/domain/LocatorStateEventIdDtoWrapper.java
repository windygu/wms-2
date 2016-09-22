package org.dddml.wms.domain;


public class LocatorStateEventIdDtoWrapper extends LocatorStateEventIdDto
{
	
    private LocatorStateEventId value;

    public LocatorStateEventIdDtoWrapper()
    {
        this(new LocatorStateEventId());
    }

    public LocatorStateEventIdDtoWrapper(LocatorStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public LocatorStateEventId toLocatorStateEventId()
    {
        return this.value;
    }

    @Override
    public String getLocatorId()
    {
        return this.value.getLocatorId();
    }

    @Override
    public void setLocatorId(String locatorId)
    {
        this.value.setLocatorId(locatorId);
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
        if (obj.getClass() == LocatorStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        LocatorStateEventIdDtoWrapper other = (LocatorStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

