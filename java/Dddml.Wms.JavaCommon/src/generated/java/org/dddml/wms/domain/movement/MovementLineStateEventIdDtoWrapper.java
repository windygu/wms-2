package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;

public class MovementLineStateEventIdDtoWrapper extends MovementLineStateEventIdDto
{
	
    private MovementLineStateEventId value;

    public MovementLineStateEventIdDtoWrapper()
    {
        this(new MovementLineStateEventId());
    }

    public MovementLineStateEventIdDtoWrapper(MovementLineStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementLineStateEventId toMovementLineStateEventId()
    {
        return this.value;
    }

    @Override
    public String getMovementDocumentNumber()
    {
        return this.value.getMovementDocumentNumber();
    }

    @Override
    public void setMovementDocumentNumber(String movementDocumentNumber)
    {
        this.value.setMovementDocumentNumber(movementDocumentNumber);
    }

    @Override
    public String getLineNumber()
    {
        return this.value.getLineNumber();
    }

    @Override
    public void setLineNumber(String lineNumber)
    {
        this.value.setLineNumber(lineNumber);
    }

    @Override
    public Long getMovementVersion()
    {
        return this.value.getMovementVersion();
    }

    @Override
    public void setMovementVersion(Long movementVersion)
    {
        this.value.setMovementVersion(movementVersion);
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
        if (obj.getClass() == MovementLineStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementLineStateEventIdDtoWrapper other = (MovementLineStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

