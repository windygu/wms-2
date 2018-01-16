package org.dddml.wms.domain.movementtype;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class MovementTypeStateEventId implements Serializable
{
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

    public MovementTypeStateEventId()
    {
    }

    public MovementTypeStateEventId(String movementTypeId, Long version)
    {
        this.movementTypeId = movementTypeId;
        this.version = version;
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

        MovementTypeStateEventId other = (MovementTypeStateEventId)obj;
        return true 
            && (movementTypeId == other.movementTypeId || (movementTypeId != null && movementTypeId.equals(other.movementTypeId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.movementTypeId != null) {
            hash += 13 * this.movementTypeId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

