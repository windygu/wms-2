package org.dddml.wms.domain.rejectionreason;

import org.dddml.wms.domain.*;

public class RejectionReasonStateEventIdDto
{

    public RejectionReasonStateEventIdDto()
    {
    }

    public RejectionReasonStateEventId toRejectionReasonStateEventId()
    {
        RejectionReasonStateEventId v = new RejectionReasonStateEventId();
        v.setRejectionReasonId(this.getRejectionReasonId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String rejectionReasonId;

    public String getRejectionReasonId()
    {
        return this.rejectionReasonId;
    }

    public void setRejectionReasonId(String rejectionReasonId)
    {
        this.rejectionReasonId = rejectionReasonId;
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
        if (obj == null || obj.getClass() != RejectionReasonStateEventIdDto.class) {
            return false;
        }

        RejectionReasonStateEventIdDto other = (RejectionReasonStateEventIdDto)obj;
        return true 
            && (getRejectionReasonId() == other.getRejectionReasonId() || (getRejectionReasonId() != null && getRejectionReasonId().equals(other.getRejectionReasonId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getRejectionReasonId() != null) {
            hash += 13 * this.getRejectionReasonId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

