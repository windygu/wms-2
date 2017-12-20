package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;

public class MovementLineIdDtoWrapper extends MovementLineIdDto
{
	
    private MovementLineId value;

    public MovementLineIdDtoWrapper()
    {
        this(new MovementLineId());
    }

    public MovementLineIdDtoWrapper(MovementLineId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementLineId toMovementLineId()
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
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == MovementLineIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementLineIdDtoWrapper other = (MovementLineIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

