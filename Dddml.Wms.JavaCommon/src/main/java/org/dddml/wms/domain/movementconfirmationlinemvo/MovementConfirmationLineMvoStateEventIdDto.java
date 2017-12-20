package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movement.MovementConfirmationLineIdDto;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;

public class MovementConfirmationLineMvoStateEventIdDto
{

    public MovementConfirmationLineMvoStateEventIdDto()
    {
    }

    public MovementConfirmationLineMvoStateEventId toMovementConfirmationLineMvoStateEventId()
    {
        MovementConfirmationLineMvoStateEventId v = new MovementConfirmationLineMvoStateEventId();
        v.setMovementConfirmationLineId(this.getMovementConfirmationLineId().toMovementConfirmationLineId());
        v.setMovementVersion(this.getMovementVersion());
        return v;
    }

    private MovementConfirmationLineIdDto movementConfirmationLineId = new MovementConfirmationLineIdDto();

    public MovementConfirmationLineIdDto getMovementConfirmationLineId()
    {
        return this.movementConfirmationLineId;
    }

    public void setMovementConfirmationLineId(MovementConfirmationLineIdDto movementConfirmationLineId)
    {
        this.movementConfirmationLineId = movementConfirmationLineId;
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
        if (obj == null || obj.getClass() != MovementConfirmationLineMvoStateEventIdDto.class) {
            return false;
        }

        MovementConfirmationLineMvoStateEventIdDto other = (MovementConfirmationLineMvoStateEventIdDto)obj;
        return true 
            && (getMovementConfirmationLineId() == other.getMovementConfirmationLineId() || (getMovementConfirmationLineId() != null && getMovementConfirmationLineId().equals(other.getMovementConfirmationLineId())))
            && (getMovementVersion() == other.getMovementVersion() || (getMovementVersion() != null && getMovementVersion().equals(other.getMovementVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getMovementConfirmationLineId() != null) {
            hash += 13 * this.getMovementConfirmationLineId().hashCode();
        }
        if (this.getMovementVersion() != null) {
            hash += 13 * this.getMovementVersion().hashCode();
        }
        return hash;
    }

}

