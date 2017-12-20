package org.dddml.wms.domain.movementconfirmation;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class MovementConfirmationLineStateEventId implements Serializable
{
    private String movementConfirmationDocumentNumber;

    public String getMovementConfirmationDocumentNumber()
    {
        return this.movementConfirmationDocumentNumber;
    }

    public void setMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber)
    {
        this.movementConfirmationDocumentNumber = movementConfirmationDocumentNumber;
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

    private Long movementConfirmationVersion;

    public Long getMovementConfirmationVersion()
    {
        return this.movementConfirmationVersion;
    }

    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.movementConfirmationVersion = movementConfirmationVersion;
    }

    public MovementConfirmationLineStateEventId()
    {
    }

    public MovementConfirmationLineStateEventId(String movementConfirmationDocumentNumber, String lineNumber, Long movementConfirmationVersion)
    {
        this.movementConfirmationDocumentNumber = movementConfirmationDocumentNumber;
        this.lineNumber = lineNumber;
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

        MovementConfirmationLineStateEventId other = (MovementConfirmationLineStateEventId)obj;
        return true 
            && (movementConfirmationDocumentNumber == other.movementConfirmationDocumentNumber || (movementConfirmationDocumentNumber != null && movementConfirmationDocumentNumber.equals(other.movementConfirmationDocumentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
            && (movementConfirmationVersion == other.movementConfirmationVersion || (movementConfirmationVersion != null && movementConfirmationVersion.equals(other.movementConfirmationVersion)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.movementConfirmationDocumentNumber != null) {
            hash += 13 * this.movementConfirmationDocumentNumber.hashCode();
        }
        if (this.lineNumber != null) {
            hash += 13 * this.lineNumber.hashCode();
        }
        if (this.movementConfirmationVersion != null) {
            hash += 13 * this.movementConfirmationVersion.hashCode();
        }
        return hash;
    }

}

