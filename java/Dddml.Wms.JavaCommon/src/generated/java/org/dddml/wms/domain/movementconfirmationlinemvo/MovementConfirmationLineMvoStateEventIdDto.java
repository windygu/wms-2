package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movementconfirmation.MovementConfirmationLineIdDto;
import org.dddml.wms.domain.movementconfirmation.*;
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
        v.setMovementConfirmationVersion(this.getMovementConfirmationVersion());
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

    private Long movementConfirmationVersion;

    public Long getMovementConfirmationVersion()
    {
        return this.movementConfirmationVersion;
    }

    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.movementConfirmationVersion = movementConfirmationVersion;
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
            && (getMovementConfirmationVersion() == other.getMovementConfirmationVersion() || (getMovementConfirmationVersion() != null && getMovementConfirmationVersion().equals(other.getMovementConfirmationVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getMovementConfirmationLineId() != null) {
            hash += 13 * this.getMovementConfirmationLineId().hashCode();
        }
        if (this.getMovementConfirmationVersion() != null) {
            hash += 13 * this.getMovementConfirmationVersion().hashCode();
        }
        return hash;
    }

}

