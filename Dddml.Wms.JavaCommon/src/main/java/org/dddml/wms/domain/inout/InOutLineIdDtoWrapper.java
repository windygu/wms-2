package org.dddml.wms.domain.inout;

import org.dddml.wms.domain.*;

public class InOutLineIdDtoWrapper extends InOutLineIdDto
{
	
    private InOutLineId value;

    public InOutLineIdDtoWrapper()
    {
        this(new InOutLineId());
    }

    public InOutLineIdDtoWrapper(InOutLineId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
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
    public Long getLineNumber()
    {
        return this.value.getLineNumber();
    }

    @Override
    public void setLineNumber(Long lineNumber)
    {
        this.value.setLineNumber(lineNumber);
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

}

