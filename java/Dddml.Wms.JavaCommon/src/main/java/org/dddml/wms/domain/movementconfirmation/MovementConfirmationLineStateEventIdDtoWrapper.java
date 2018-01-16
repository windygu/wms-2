package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.*;

public class MovementConfirmationLineStateEventIdDtoWrapper extends MovementConfirmationLineStateEventIdDto
{
	
    private MovementConfirmationLineStateEventId value;

    public MovementConfirmationLineStateEventIdDtoWrapper()
    {
        this(new MovementConfirmationLineStateEventId());
    }

    public MovementConfirmationLineStateEventIdDtoWrapper(MovementConfirmationLineStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementConfirmationLineStateEventId toMovementConfirmationLineStateEventId()
    {
        return this.value;
    }

    @Override
    public String getMovementConfirmationDocumentNumber()
    {
        return this.value.getMovementConfirmationDocumentNumber();
    }

    @Override
    public void setMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber)
    {
        this.value.setMovementConfirmationDocumentNumber(movementConfirmationDocumentNumber);
    }

    @Override
    public String getLineNumber()
    {
        return this.value.getLineNumber();
    }

    @Override
    public void setLineNumber(String lineNumber)
    {
        this.value.setLineNumber(lineNumber);
    }

    @Override
    public Long getMovementConfirmationVersion()
    {
        return this.value.getMovementConfirmationVersion();
    }

    @Override
    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.value.setMovementConfirmationVersion(movementConfirmationVersion);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == MovementConfirmationLineStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementConfirmationLineStateEventIdDtoWrapper other = (MovementConfirmationLineStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

