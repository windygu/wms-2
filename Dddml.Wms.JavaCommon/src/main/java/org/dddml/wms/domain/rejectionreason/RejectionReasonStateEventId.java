package org.dddml.wms.domain.rejectionreason;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class RejectionReasonStateEventId implements Serializable
{
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

    public RejectionReasonStateEventId()
    {
    }

    public RejectionReasonStateEventId(String rejectionReasonId, Long version)
    {
        this.rejectionReasonId = rejectionReasonId;
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

        RejectionReasonStateEventId other = (RejectionReasonStateEventId)obj;
        return true 
            && (rejectionReasonId == other.rejectionReasonId || (rejectionReasonId != null && rejectionReasonId.equals(other.rejectionReasonId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.rejectionReasonId != null) {
            hash += 13 * this.rejectionReasonId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

