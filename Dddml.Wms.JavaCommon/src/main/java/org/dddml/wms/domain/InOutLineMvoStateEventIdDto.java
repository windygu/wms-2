package org.dddml.wms.domain;


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

