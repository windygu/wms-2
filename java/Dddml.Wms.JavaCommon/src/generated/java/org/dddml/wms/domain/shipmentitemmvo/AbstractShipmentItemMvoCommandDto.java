package org.dddml.wms.domain.shipmentitemmvo;

import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentItemMvoCommandDto extends AbstractCommand
{
    /**
     * Shipment Item Id
     */
    private ShipmentItemId shipmentItemId;

    public ShipmentItemId getShipmentItemId()
    {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemId shipmentItemId)
    {
        this.shipmentItemId = shipmentItemId;
    }

    /**
     * Shipment Version
     */
    private Long shipmentVersion;

    public Long getShipmentVersion()
    {
        return this.shipmentVersion;
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.shipmentVersion = shipmentVersion;
    }


    public void copyTo(AbstractShipmentItemMvoCommand command)
    {
        command.setShipmentItemId(this.getShipmentItemId());
        command.setShipmentVersion(this.getShipmentVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
