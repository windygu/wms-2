package org.dddml.wms.domain;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class InOutLineMvoStateEventId implements Serializable
{
    private InOutLineId inOutLineId = new InOutLineId();

    public InOutLineId getInOutLineId()
    {
        return this.inOutLineId;
    }

    public void setInOutLineId(InOutLineId inOutLineId)
    {
        this.inOutLineId = inOutLineId;
    }

    private Long inOutVersion;

    public Long getInOutVersion()
    {
        return this.inOutVersion;
    }

    public void setInOutVersion(Long inOutVersion)
    {
        this.inOutVersion = inOutVersion;
    }

    public String getInOutLineIdInOutDocumentNumber()
    {
        return getInOutLineId().getInOutDocumentNumber();
    }

    public void setInOutLineIdInOutDocumentNumber(String inOutLineIdInOutDocumentNumber)
    {
        getInOutLineId().setInOutDocumentNumber(inOutLineIdInOutDocumentNumber);
    }

    public Long getInOutLineIdLineNumber()
    {
        return getInOutLineId().getLineNumber();
    }

    public void setInOutLineIdLineNumber(Long inOutLineIdLineNumber)
    {
        getInOutLineId().setLineNumber(inOutLineIdLineNumber);
    }

    public InOutLineMvoStateEventId()
    {
    }

    public InOutLineMvoStateEventId(InOutLineId inOutLineId, Long inOutVersion)
    {
        this.inOutLineId = inOutLineId;
        this.inOutVersion = inOutVersion;
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

        InOutLineMvoStateEventId other = (InOutLineMvoStateEventId)obj;
        return true 
            && (inOutLineId == other.inOutLineId || (inOutLineId != null && inOutLineId.equals(other.inOutLineId)))
            && (inOutVersion == other.inOutVersion || (inOutVersion != null && inOutVersion.equals(other.inOutVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.inOutLineId != null) {
            hash += 13 * this.inOutLineId.hashCode();
        }
        if (this.inOutVersion != null) {
            hash += 13 * this.inOutVersion.hashCode();
        }
        return hash;
    }

}

