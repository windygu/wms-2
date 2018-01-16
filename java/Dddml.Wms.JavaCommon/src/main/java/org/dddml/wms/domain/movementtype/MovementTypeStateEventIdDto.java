package org.dddml.wms.domain.movementtype;

import org.dddml.wms.domain.*;

public class MovementTypeStateEventIdDto
{

    public MovementTypeStateEventIdDto()
    {
    }

    public MovementTypeStateEventId toMovementTypeStateEventId()
    {
        MovementTypeStateEventId v = new MovementTypeStateEventId();
        v.setMovementTypeId(this.getMovementTypeId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String movementTypeId;

    public String getMovementTypeId()
    {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.movementTypeId = movementTypeId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MovementTypeStateEventIdDto.class) {
            return false;
        }

        MovementTypeStateEventIdDto other = (MovementTypeStateEventIdDto)obj;
        return true 
            && (getMovementTypeId() == other.getMovementTypeId() || (getMovementTypeId() != null && getMovementTypeId().equals(other.getMovementTypeId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getMovementTypeId() != null) {
            hash += 13 * this.getMovementTypeId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

