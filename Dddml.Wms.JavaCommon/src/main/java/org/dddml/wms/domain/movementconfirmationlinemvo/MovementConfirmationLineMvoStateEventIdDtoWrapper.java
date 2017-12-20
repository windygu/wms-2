package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.domain.*;

public class MovementConfirmationLineMvoStateEventIdDtoWrapper extends MovementConfirmationLineMvoStateEventIdDto
{
	
    private MovementConfirmationLineMvoStateEventId value;

    public MovementConfirmationLineMvoStateEventIdDtoWrapper()
    {
        this(new MovementConfirmationLineMvoStateEventId());
    }

    public MovementConfirmationLineMvoStateEventIdDtoWrapper(MovementConfirmationLineMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementConfirmationLineMvoStateEventId toMovementConfirmationLineMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public MovementConfirmationLineIdDto getMovementConfirmationLineId()
    {
        return new MovementConfirmationLineIdDtoWrapper(this.value.getMovementConfirmationLineId());
    }

    @Override
    public void setMovementConfirmationLineId(MovementConfirmationLineIdDto movementConfirmationLineId)
    {
        this.value.setMovementConfirmationLineId(movementConfirmationLineId.toMovementConfirmationLineId());
    }

    @Override
    public Long getMovementConfirmationVersion()
    {
        return this.value.getMovementConfirmationVersion();
    }

    @Override
    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.value.setMovementConfirmationVersion(movementConfirmationVersion);
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
        if (obj.getClass() == MovementConfirmationLineMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementConfirmationLineMvoStateEventIdDtoWrapper other = (MovementConfirmationLineMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

