package org.dddml.wms.domain.movementlinemvo;

import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;

public class MovementLineMvoStateEventIdDtoWrapper extends MovementLineMvoStateEventIdDto
{
	
    private MovementLineMvoStateEventId value;

    public MovementLineMvoStateEventIdDtoWrapper()
    {
        this(new MovementLineMvoStateEventId());
    }

    public MovementLineMvoStateEventIdDtoWrapper(MovementLineMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementLineMvoStateEventId toMovementLineMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public MovementLineIdDto getMovementLineId()
    {
        return new MovementLineIdDtoWrapper(this.value.getMovementLineId());
    }

    @Override
    public void setMovementLineId(MovementLineIdDto movementLineId)
    {
        this.value.setMovementLineId(movementLineId.toMovementLineId());
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
        if (obj.getClass() == MovementLineMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementLineMvoStateEventIdDtoWrapper other = (MovementLineMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

