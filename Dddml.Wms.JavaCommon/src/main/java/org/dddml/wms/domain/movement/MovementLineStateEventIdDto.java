package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;

public class MovementLineStateEventIdDto
{

    public MovementLineStateEventIdDto()
    {
    }

    public MovementLineStateEventId toMovementLineStateEventId()
    {
        MovementLineStateEventId v = new MovementLineStateEventId();
        v.setMovementDocumentNumber(this.getMovementDocumentNumber());
        v.setLineNumber(this.getLineNumber());
        v.setMovementVersion(this.getMovementVersion());
        return v;
    }

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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MovementLineStateEventIdDto.class) {
            return false;
        }

        MovementLineStateEventIdDto other = (MovementLineStateEventIdDto)obj;
        return true 
            && (getMovementDocumentNumber() == other.getMovementDocumentNumber() || (getMovementDocumentNumber() != null && getMovementDocumentNumber().equals(other.getMovementDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
            && (getMovementVersion() == other.getMovementVersion() || (getMovementVersion() != null && getMovementVersion().equals(other.getMovementVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getMovementDocumentNumber() != null) {
            hash += 13 * this.getMovementDocumentNumber().hashCode();
        }
        if (this.getLineNumber() != null) {
            hash += 13 * this.getLineNumber().hashCode();
        }
        if (this.getMovementVersion() != null) {
            hash += 13 * this.getMovementVersion().hashCode();
        }
        return hash;
    }

}

