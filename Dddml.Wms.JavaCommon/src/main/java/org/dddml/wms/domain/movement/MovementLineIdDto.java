package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;

public class MovementLineIdDto
{

    public MovementLineIdDto()
    {
    }

    public MovementLineId toMovementLineId()
    {
        MovementLineId v = new MovementLineId();
        v.setMovementDocumentNumber(this.getMovementDocumentNumber());
        v.setLineNumber(this.getLineNumber());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MovementLineIdDto.class) {
            return false;
        }

        MovementLineIdDto other = (MovementLineIdDto)obj;
        return true 
            && (getMovementDocumentNumber() == other.getMovementDocumentNumber() || (getMovementDocumentNumber() != null && getMovementDocumentNumber().equals(other.getMovementDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
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
        return hash;
    }

}

