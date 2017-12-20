package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.io.Serializable;
import org.dddml.wms.domain.movement.MovementConfirmationLineId;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;

public class MovementConfirmationLineMvoStateEventId implements Serializable
{
    private MovementConfirmationLineId movementConfirmationLineId = new MovementConfirmationLineId();

    public MovementConfirmationLineId getMovementConfirmationLineId()
    {
        return this.movementConfirmationLineId;
    }

    public void setMovementConfirmationLineId(MovementConfirmationLineId movementConfirmationLineId)
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

    public String getMovementConfirmationLineIdMovementDocumentNumber()
    {
        return getMovementConfirmationLineId().getMovementDocumentNumber();
    }

    public void setMovementConfirmationLineIdMovementDocumentNumber(String movementConfirmationLineIdMovementDocumentNumber)
    {
        getMovementConfirmationLineId().setMovementDocumentNumber(movementConfirmationLineIdMovementDocumentNumber);
    }

    public String getMovementConfirmationLineIdLineNumber()
    {
        return getMovementConfirmationLineId().getLineNumber();
    }

    public void setMovementConfirmationLineIdLineNumber(String movementConfirmationLineIdLineNumber)
    {
        getMovementConfirmationLineId().setLineNumber(movementConfirmationLineIdLineNumber);
    }

    public MovementConfirmationLineMvoStateEventId()
    {
    }

    public MovementConfirmationLineMvoStateEventId(MovementConfirmationLineId movementConfirmationLineId, Long movementVersion)
    {
        this.movementConfirmationLineId = movementConfirmationLineId;
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

        MovementConfirmationLineMvoStateEventId other = (MovementConfirmationLineMvoStateEventId)obj;
        return true 
            && (movementConfirmationLineId == other.movementConfirmationLineId || (movementConfirmationLineId != null && movementConfirmationLineId.equals(other.movementConfirmationLineId)))
            && (movementVersion == other.movementVersion || (movementVersion != null && movementVersion.equals(other.movementVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.movementConfirmationLineId != null) {
            hash += 13 * this.movementConfirmationLineId.hashCode();
        }
        if (this.movementVersion != null) {
            hash += 13 * this.movementVersion.hashCode();
        }
        return hash;
    }

}

