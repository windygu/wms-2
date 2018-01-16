package org.dddml.wms.domain.sellableinventoryitem;

import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractSellableInventoryItemCommandDto extends AbstractCommand
{
    private InventoryItemIdDto sellableInventoryItemId;

    public InventoryItemIdDto getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemIdDto sellableInventoryItemId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
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


    public void copyTo(AbstractSellableInventoryItemCommand command)
    {
        command.setSellableInventoryItemId((this.getSellableInventoryItemId() == null) ? null : this.getSellableInventoryItemId().toInventoryItemId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
