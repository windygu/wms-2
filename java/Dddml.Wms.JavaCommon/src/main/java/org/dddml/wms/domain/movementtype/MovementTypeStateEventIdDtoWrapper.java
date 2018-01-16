package org.dddml.wms.domain.movementtype;

import org.dddml.wms.domain.*;

public class MovementTypeStateEventIdDtoWrapper extends MovementTypeStateEventIdDto
{
	
    private MovementTypeStateEventId value;

    public MovementTypeStateEventIdDtoWrapper()
    {
        this(new MovementTypeStateEventId());
    }

    public MovementTypeStateEventIdDtoWrapper(MovementTypeStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementTypeStateEventId toMovementTypeStateEventId()
    {
        return this.value;
    }

    @Override
    public String getMovementTypeId()
    {
        return this.value.getMovementTypeId();
    }

    @Override
    public void setMovementTypeId(String movementTypeId)
    {
        this.value.setMovementTypeId(movementTypeId);
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
        if (obj.getClass() == MovementTypeStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementTypeStateEventIdDtoWrapper other = (MovementTypeStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

