package org.dddml.wms.domain.movementtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractMovementTypeCommandDto extends AbstractCommand
{
    /**
     * Movement Type Id
     */
    private String movementTypeId;

    public String getMovementTypeId()
    {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.movementTypeId = movementTypeId;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


}
