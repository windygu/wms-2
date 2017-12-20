package org.dddml.wms.domain.movement;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class MovementConfirmationLineStateEventId implements Serializable
{
    private String movementDocumentNumber;

    public String getMovementDocumentNumber()
    {
        return this.movementDocumentNumber;
    }

    public void setMovementDocumentNumber(String movementDocumentNumber)
    {
        this.movementDocumentNumber = movementDocumentNumber;
    }

    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
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

    public MovementConfirmationLineStateEventId()
    {
    }

    public MovementConfirmationLineStateEventId(String movementDocumentNumber, String lineNumber, Long movementVersion)
    {
        this.movementDocumentNumber = movementDocumentNumber;
        this.lineNumber = lineNumber;
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

        MovementConfirmationLineStateEventId other = (MovementConfirmationLineStateEventId)obj;
        return true 
            && (movementDocumentNumber == other.movementDocumentNumber || (movementDocumentNumber != null && movementDocumentNumber.equals(other.movementDocumentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
            && (movementVersion == other.movementVersion || (movementVersion != null && movementVersion.equals(other.movementVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.movementDocumentNumber != null) {
            hash += 13 * this.movementDocumentNumber.hashCode();
        }
        if (this.lineNumber != null) {
            hash += 13 * this.lineNumber.hashCode();
        }
        if (this.movementVersion != null) {
            hash += 13 * this.movementVersion.hashCode();
        }
        return hash;
    }

}

