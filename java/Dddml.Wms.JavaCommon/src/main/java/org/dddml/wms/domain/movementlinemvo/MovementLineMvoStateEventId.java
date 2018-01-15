package org.dddml.wms.domain.movementlinemvo;

import java.io.Serializable;
import org.dddml.wms.domain.movement.MovementLineId;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;

public class MovementLineMvoStateEventId implements Serializable
{
    private MovementLineId movementLineId = new MovementLineId();

    public MovementLineId getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineId movementLineId)
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

    public String getMovementLineIdMovementDocumentNumber()
    {
        return getMovementLineId().getMovementDocumentNumber();
    }

    public void setMovementLineIdMovementDocumentNumber(String movementLineIdMovementDocumentNumber)
    {
        getMovementLineId().setMovementDocumentNumber(movementLineIdMovementDocumentNumber);
    }

    public String getMovementLineIdLineNumber()
    {
        return getMovementLineId().getLineNumber();
    }

    public void setMovementLineIdLineNumber(String movementLineIdLineNumber)
    {
        getMovementLineId().setLineNumber(movementLineIdLineNumber);
    }

    public MovementLineMvoStateEventId()
    {
    }

    public MovementLineMvoStateEventId(MovementLineId movementLineId, Long movementVersion)
    {
        this.movementLineId = movementLineId;
        this.movementVersion = movementVersion;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MovementLineMvoStateEventId other = (MovementLineMvoStateEventId)obj;
        return true 
            && (movementLineId == other.movementLineId || (movementLineId != null && movementLineId.equals(other.movementLineId)))
            && (movementVersion == other.movementVersion || (movementVersion != null && movementVersion.equals(other.movementVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.movementLineId != null) {
            hash += 13 * this.movementLineId.hashCode();
        }
        if (this.movementVersion != null) {
            hash += 13 * this.movementVersion.hashCode();
        }
        return hash;
    }

}

