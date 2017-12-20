package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.*;

public class MovementConfirmationStateEventIdDtoWrapper extends MovementConfirmationStateEventIdDto
{
	
    private MovementConfirmationStateEventId value;

    public MovementConfirmationStateEventIdDtoWrapper()
    {
        this(new MovementConfirmationStateEventId());
    }

    public MovementConfirmationStateEventIdDtoWrapper(MovementConfirmationStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public MovementConfirmationStateEventId toMovementConfirmationStateEventId()
    {
        return this.value;
    }

    @Override
    public String getDocumentNumber()
    {
        return this.value.getDocumentNumber();
    }

    @Override
    public void setDocumentNumber(String documentNumber)
    {
        this.value.setDocumentNumber(documentNumber);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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
        if (obj.getClass() == MovementConfirmationStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        MovementConfirmationStateEventIdDtoWrapper other = (MovementConfirmationStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

