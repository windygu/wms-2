package org.dddml.wms.domain.shipmentitem;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentItemCommandDto extends AbstractCommand
{
    private ShipmentItemIdDto shipmentItemId;

    public ShipmentItemIdDto getShipmentItemId()
    {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemIdDto shipmentItemId)
    {
        this.shipmentItemId = shipmentItemId;
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


    public void copyTo(AbstractShipmentItemCommand command)
    {
        command.setShipmentItemId((this.getShipmentItemId() == null) ? null : this.getShipmentItemId().toShipmentItemId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
