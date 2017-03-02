package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class InOutStateEventIdDtoWrapper extends InOutStateEventIdDto
{
	
    private InOutStateEventId value;

    public InOutStateEventIdDtoWrapper()
    {
        this(new InOutStateEventId());
    }

    public InOutStateEventIdDtoWrapper(InOutStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public InOutStateEventId toInOutStateEventId()
    {
        return this.value;
    }

    @Override
    public String getDocumentNumber()
    {
        return this.value.getDocumentNumber();
    }

    @Override
    public void setDocumentNumber(String documentNumber)
    {
        this.value.setDocumentNumber(documentNumber);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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
        if (obj.getClass() == InOutStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        InOutStateEventIdDtoWrapper other = (InOutStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

