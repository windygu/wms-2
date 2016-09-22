package org.dddml.wms.domain;


public class InOutLineStateEventIdDtoWrapper extends InOutLineStateEventIdDto
{
	
    private InOutLineStateEventId value;

    public InOutLineStateEventIdDtoWrapper()
    {
        this(new InOutLineStateEventId());
    }

    public InOutLineStateEventIdDtoWrapper(InOutLineStateEventId value)
    {
        this.value = value;
    }

    public InOutLineStateEventId toInOutLineStateEventId()
    {
        return this.value;
    }

    @Override
    public String getInOutDocumentNumber()
    {
        return this.value.getInOutDocumentNumber();
    }

    @Override
    public void setInOutDocumentNumber(String inOutDocumentNumber)
    {
        this.value.setInOutDocumentNumber(inOutDocumentNumber);
    }

    @Override
    public SkuIdDto getSkuId()
    {
        return new SkuIdDtoWrapper(this.value.getSkuId());
    }

    @Override
    public void setSkuId(SkuIdDto skuId)
    {
        this.value.setSkuId(skuId.toSkuId());
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
        if (obj.getClass() == InOutLineStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InOutLineStateEventIdDtoWrapper other = (InOutLineStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

