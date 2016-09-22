package org.dddml.wms.domain;


public class InOutLineIdDtoWrapper extends InOutLineIdDto
{
	
    private InOutLineId value;

    public InOutLineIdDtoWrapper()
    {
        this(new InOutLineId());
    }

    public InOutLineIdDtoWrapper(InOutLineId value)
    {
        this.value = value;
    }

    public InOutLineId toInOutLineId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == InOutLineIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InOutLineIdDtoWrapper other = (InOutLineIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

