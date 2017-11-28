package org.dddml.wms.domain.inventoryitementrymvo;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractInventoryItemEntryMvoCommandDto extends AbstractCommand
{
    private InventoryItemEntryIdDto inventoryItemEntryId;

    public InventoryItemEntryIdDto getInventoryItemEntryId()
    {
        return this.inventoryItemEntryId;
    }

    public void setInventoryItemEntryId(InventoryItemEntryIdDto inventoryItemEntryId)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
    }

    private Long inventoryItemVersion;

    public Long getInventoryItemVersion()
    {
        return this.inventoryItemVersion;
    }

    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.inventoryItemVersion = inventoryItemVersion;
    }


    public void copyTo(AbstractInventoryItemEntryMvoCommand command)
    {
        command.setInventoryItemEntryId((this.getInventoryItemEntryId() == null) ? null : this.getInventoryItemEntryId().toInventoryItemEntryId());
        command.setInventoryItemVersion(this.getInventoryItemVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
