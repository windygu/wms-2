package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;

public class MovementStateEventIdDtoWrapper extends MovementStateEventIdDto
{
	
    private MovementStateEventId value;

    public MovementStateEventIdDtoWrapper()
    {
        this(new MovementStateEventId());
    }

    public MovementStateEventIdDtoWrapper(MovementStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementStateEventId toMovementStateEventId()
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
        if (obj.getClass() == MovementStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementStateEventIdDtoWrapper other = (MovementStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

