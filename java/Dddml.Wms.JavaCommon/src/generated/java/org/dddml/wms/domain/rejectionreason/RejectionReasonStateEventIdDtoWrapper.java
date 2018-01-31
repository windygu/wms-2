package org.dddml.wms.domain.rejectionreason;

import org.dddml.wms.domain.*;

public class RejectionReasonStateEventIdDtoWrapper extends RejectionReasonStateEventIdDto
{
	
    private RejectionReasonStateEventId value;

    public RejectionReasonStateEventIdDtoWrapper()
    {
        this(new RejectionReasonStateEventId());
    }

    public RejectionReasonStateEventIdDtoWrapper(RejectionReasonStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public RejectionReasonStateEventId toRejectionReasonStateEventId()
    {
        return this.value;
    }

    @Override
    public String getRejectionReasonId()
    {
        return this.value.getRejectionReasonId();
    }

    @Override
    public void setRejectionReasonId(String rejectionReasonId)
    {
        this.value.setRejectionReasonId(rejectionReasonId);
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
        if (obj.getClass() == RejectionReasonStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        RejectionReasonStateEventIdDtoWrapper other = (RejectionReasonStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

