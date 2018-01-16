package org.dddml.wms.domain.movement;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class MovementLineId implements Serializable
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

    public MovementLineId()
    {
    }

    public MovementLineId(String movementDocumentNumber, String lineNumber)
    {
        this.movementDocumentNumber = movementDocumentNumber;
        this.lineNumber = lineNumber;
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

        MovementLineId other = (MovementLineId)obj;
        return true 
            && (movementDocumentNumber == other.movementDocumentNumber || (movementDocumentNumber != null && movementDocumentNumber.equals(other.movementDocumentNumber)))
            && (lineNumber == other.lineNumber || (lineNumber != null && lineNumber.equals(other.lineNumber)))
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
        return hash;
    }

}

