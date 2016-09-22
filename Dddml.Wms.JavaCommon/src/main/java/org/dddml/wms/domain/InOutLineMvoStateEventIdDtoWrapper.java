package org.dddml.wms.domain;


public class InOutLineMvoStateEventIdDtoWrapper extends InOutLineMvoStateEventIdDto
{
	
    private InOutLineMvoStateEventId value;

    public InOutLineMvoStateEventIdDtoWrapper()
    {
        this(new InOutLineMvoStateEventId());
    }

    public InOutLineMvoStateEventIdDtoWrapper(InOutLineMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InOutLineMvoStateEventId toInOutLineMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public InOutLineIdDto getInOutLineId()
    {
        return new InOutLineIdDtoWrapper(this.value.getInOutLineId());
    }

    @Override
    public void setInOutLineId(InOutLineIdDto inOutLineId)
    {
        this.value.setInOutLineId(inOutLineId.toInOutLineId());
    }

    @Override
    public Long getInOutVersion()
    {
        return this.value.getInOutVersion();
    }

    @Override
    public void setInOutVersion(Long inOutVersion)
    {
        this.value.setInOutVersion(inOutVersion);
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
        if (obj.getClass() == InOutLineMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InOutLineMvoStateEventIdDtoWrapper other = (InOutLineMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

