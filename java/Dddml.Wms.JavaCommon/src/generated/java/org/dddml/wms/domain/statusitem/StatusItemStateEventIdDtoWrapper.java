package org.dddml.wms.domain.statusitem;

import org.dddml.wms.domain.*;

public class StatusItemStateEventIdDtoWrapper extends StatusItemStateEventIdDto
{
	
    private StatusItemStateEventId value;

    public StatusItemStateEventIdDtoWrapper()
    {
        this(new StatusItemStateEventId());
    }

    public StatusItemStateEventIdDtoWrapper(StatusItemStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public StatusItemStateEventId toStatusItemStateEventId()
    {
        return this.value;
    }

    @Override
    public String getStatusId()
    {
        return this.value.getStatusId();
    }

    @Override
    public void setStatusId(String statusId)
    {
        this.value.setStatusId(statusId);
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
        if (obj.getClass() == StatusItemStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        StatusItemStateEventIdDtoWrapper other = (StatusItemStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

