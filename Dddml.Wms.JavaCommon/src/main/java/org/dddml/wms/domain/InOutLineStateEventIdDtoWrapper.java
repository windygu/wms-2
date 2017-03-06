package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class InOutLineStateEventIdDtoWrapper extends InOutLineStateEventIdDto
{
	
    private InOutLineStateEventId value;

    public InOutLineStateEventIdDtoWrapper()
    {
        this(new InOutLineStateEventId());
    }

    public InOutLineStateEventIdDtoWrapper(InOutLineStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
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

}

