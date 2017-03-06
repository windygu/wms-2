package org.dddml.wms.domain.inoutlinemvo;

import org.dddml.wms.domain.inout.InOutLineIdDto;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.domain.*;

public class InOutLineMvoStateEventIdDto
{

    public InOutLineMvoStateEventIdDto()
    {
    }

    public InOutLineMvoStateEventId toInOutLineMvoStateEventId()
    {
        InOutLineMvoStateEventId v = new InOutLineMvoStateEventId();
        v.setInOutLineId(this.getInOutLineId().toInOutLineId());
        v.setInOutVersion(this.getInOutVersion());
        return v;
    }

    private InOutLineIdDto inOutLineId = new InOutLineIdDto();

    public InOutLineIdDto getInOutLineId()
    {
        return this.inOutLineId;
    }

    public void setInOutLineId(InOutLineIdDto inOutLineId)
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != InOutLineMvoStateEventIdDto.class) {
            return false;
        }

        InOutLineMvoStateEventIdDto other = (InOutLineMvoStateEventIdDto)obj;
        return true 
            && (getInOutLineId() == other.getInOutLineId() || (getInOutLineId() != null && getInOutLineId().equals(other.getInOutLineId())))
            && (getInOutVersion() == other.getInOutVersion() || (getInOutVersion() != null && getInOutVersion().equals(other.getInOutVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getInOutLineId() != null) {
            hash += 13 * this.getInOutLineId().hashCode();
        }
        if (this.getInOutVersion() != null) {
            hash += 13 * this.getInOutVersion().hashCode();
        }
        return hash;
    }

}

