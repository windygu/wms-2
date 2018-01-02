package org.dddml.wms.domain.lot;

import org.dddml.wms.domain.*;

public class LotStateEventIdDto
{

    public LotStateEventIdDto()
    {
    }

    public LotStateEventId toLotStateEventId()
    {
        LotStateEventId v = new LotStateEventId();
        v.setLotId(this.getLotId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String lotId;

    public String getLotId()
    {
        return this.lotId;
    }

    public void setLotId(String lotId)
    {
        this.lotId = lotId;
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
        if (obj == null || obj.getClass() != LotStateEventIdDto.class) {
            return false;
        }

        LotStateEventIdDto other = (LotStateEventIdDto)obj;
        return true 
            && (getLotId() == other.getLotId() || (getLotId() != null && getLotId().equals(other.getLotId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getLotId() != null) {
            hash += 13 * this.getLotId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

