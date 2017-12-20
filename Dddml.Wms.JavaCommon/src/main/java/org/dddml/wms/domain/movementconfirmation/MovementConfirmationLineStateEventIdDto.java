package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.*;

public class MovementConfirmationLineStateEventIdDto
{

    public MovementConfirmationLineStateEventIdDto()
    {
    }

    public MovementConfirmationLineStateEventId toMovementConfirmationLineStateEventId()
    {
        MovementConfirmationLineStateEventId v = new MovementConfirmationLineStateEventId();
        v.setMovementConfirmationDocumentNumber(this.getMovementConfirmationDocumentNumber());
        v.setLineNumber(this.getLineNumber());
        v.setMovementConfirmationVersion(this.getMovementConfirmationVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MovementConfirmationLineStateEventIdDto.class) {
            return false;
        }

        MovementConfirmationLineStateEventIdDto other = (MovementConfirmationLineStateEventIdDto)obj;
        return true 
            && (getMovementConfirmationDocumentNumber() == other.getMovementConfirmationDocumentNumber() || (getMovementConfirmationDocumentNumber() != null && getMovementConfirmationDocumentNumber().equals(other.getMovementConfirmationDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
            && (getMovementConfirmationVersion() == other.getMovementConfirmationVersion() || (getMovementConfirmationVersion() != null && getMovementConfirmationVersion().equals(other.getMovementConfirmationVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getMovementConfirmationDocumentNumber() != null) {
            hash += 13 * this.getMovementConfirmationDocumentNumber().hashCode();
        }
        if (this.getLineNumber() != null) {
            hash += 13 * this.getLineNumber().hashCode();
        }
        if (this.getMovementConfirmationVersion() != null) {
            hash += 13 * this.getMovementConfirmationVersion().hashCode();
        }
        return hash;
    }

}

