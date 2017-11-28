package org.dddml.wms.domain.inventoryitemeventtype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemEventTypeCommandDto extends AbstractCommand
{
    private String inventoryItemEventTypeId;

    public String getInventoryItemEventTypeId()
    {
        return this.inventoryItemEventTypeId;
    }

    public void setInventoryItemEventTypeId(String inventoryItemEventTypeId)
    {
        this.inventoryItemEventTypeId = inventoryItemEventTypeId;
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


    public void copyTo(AbstractInventoryItemEventTypeCommand command)
    {
        command.setInventoryItemEventTypeId(this.getInventoryItemEventTypeId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
