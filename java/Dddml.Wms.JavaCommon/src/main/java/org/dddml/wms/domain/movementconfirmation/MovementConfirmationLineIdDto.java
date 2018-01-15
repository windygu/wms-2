package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.*;

public class MovementConfirmationLineIdDto
{

    public MovementConfirmationLineIdDto()
    {
    }

    public MovementConfirmationLineId toMovementConfirmationLineId()
    {
        MovementConfirmationLineId v = new MovementConfirmationLineId();
        v.setMovementConfirmationDocumentNumber(this.getMovementConfirmationDocumentNumber());
        v.setLineNumber(this.getLineNumber());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MovementConfirmationLineIdDto.class) {
            return false;
        }

        MovementConfirmationLineIdDto other = (MovementConfirmationLineIdDto)obj;
        return true 
            && (getMovementConfirmationDocumentNumber() == other.getMovementConfirmationDocumentNumber() || (getMovementConfirmationDocumentNumber() != null && getMovementConfirmationDocumentNumber().equals(other.getMovementConfirmationDocumentNumber())))
            && (getLineNumber() == other.getLineNumber() || (getLineNumber() != null && getLineNumber().equals(other.getLineNumber())))
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
        return hash;
    }

}

