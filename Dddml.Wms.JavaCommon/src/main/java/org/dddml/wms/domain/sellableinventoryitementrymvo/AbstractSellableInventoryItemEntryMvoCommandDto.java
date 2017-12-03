package org.dddml.wms.domain.sellableinventoryitementrymvo;

import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractSellableInventoryItemEntryMvoCommandDto extends AbstractCommand
{
    private SellableInventoryItemEntryIdDto sellableInventoryItemEntryId;

    public SellableInventoryItemEntryIdDto getSellableInventoryItemEntryId()
    {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryIdDto sellableInventoryItemEntryId)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
    }

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
    }


    public void copyTo(AbstractSellableInventoryItemEntryMvoCommand command)
    {
        command.setSellableInventoryItemEntryId((this.getSellableInventoryItemEntryId() == null) ? null : this.getSellableInventoryItemEntryId().toSellableInventoryItemEntryId());
        command.setSellableInventoryItemVersion(this.getSellableInventoryItemVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
