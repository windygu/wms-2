package org.dddml.wms.domain.movementlinemvo;

import org.dddml.wms.domain.movement.MovementLineIdDto;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;

public class MovementLineMvoStateEventIdDto
{

    public MovementLineMvoStateEventIdDto()
    {
    }

    public MovementLineMvoStateEventId toMovementLineMvoStateEventId()
    {
        MovementLineMvoStateEventId v = new MovementLineMvoStateEventId();
        v.setMovementLineId(this.getMovementLineId().toMovementLineId());
        v.setMovementVersion(this.getMovementVersion());
        return v;
    }

    private MovementLineIdDto movementLineId = new MovementLineIdDto();

    public MovementLineIdDto getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineIdDto movementLineId)
    {
        this.movementLineId = movementLineId;
    }

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MovementLineMvoStateEventIdDto.class) {
            return false;
        }

        MovementLineMvoStateEventIdDto other = (MovementLineMvoStateEventIdDto)obj;
        return true 
            && (getMovementLineId() == other.getMovementLineId() || (getMovementLineId() != null && getMovementLineId().equals(other.getMovementLineId())))
            && (getMovementVersion() == other.getMovementVersion() || (getMovementVersion() != null && getMovementVersion().equals(other.getMovementVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getMovementLineId() != null) {
            hash += 13 * this.getMovementLineId().hashCode();
        }
        if (this.getMovementVersion() != null) {
            hash += 13 * this.getMovementVersion().hashCode();
        }
        return hash;
    }

}

