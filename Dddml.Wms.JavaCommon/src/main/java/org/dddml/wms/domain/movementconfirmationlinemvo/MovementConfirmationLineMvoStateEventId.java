package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.io.Serializable;
import org.dddml.wms.domain.movementconfirmation.MovementConfirmationLineId;
import org.dddml.wms.domain.movementconfirmation.*;
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

    private Long movementConfirmationVersion;

    public Long getMovementConfirmationVersion()
    {
        return this.movementConfirmationVersion;
    }

    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.movementConfirmationVersion = movementConfirmationVersion;
    }

    public String getMovementConfirmationLineIdMovementConfirmationDocumentNumber()
    {
        return getMovementConfirmationLineId().getMovementConfirmationDocumentNumber();
    }

    public void setMovementConfirmationLineIdMovementConfirmationDocumentNumber(String movementConfirmationLineIdMovementConfirmationDocumentNumber)
    {
        getMovementConfirmationLineId().setMovementConfirmationDocumentNumber(movementConfirmationLineIdMovementConfirmationDocumentNumber);
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

    public MovementConfirmationLineMvoStateEventId(MovementConfirmationLineId movementConfirmationLineId, Long movementConfirmationVersion)
    {
        this.movementConfirmationLineId = movementConfirmationLineId;
        this.movementConfirmationVersion = movementConfirmationVersion;
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
            && (movementConfirmationVersion == other.movementConfirmationVersion || (movementConfirmationVersion != null && movementConfirmationVersion.equals(other.movementConfirmationVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.movementConfirmationLineId != null) {
            hash += 13 * this.movementConfirmationLineId.hashCode();
        }
        if (this.movementConfirmationVersion != null) {
            hash += 13 * this.movementConfirmationVersion.hashCode();
        }
        return hash;
    }

}

