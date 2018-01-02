package org.dddml.wms.domain.shipmentreceiptmvo;

import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentReceiptMvoCommandDto extends AbstractCommand
{
    private ShipmentReceiptIdDto shipmentReceiptId;

    public ShipmentReceiptIdDto getShipmentReceiptId()
    {
        return this.shipmentReceiptId;
    }

    public void setShipmentReceiptId(ShipmentReceiptIdDto shipmentReceiptId)
    {
        this.shipmentReceiptId = shipmentReceiptId;
    }

    private Long shipmentVersion;

    public Long getShipmentVersion()
    {
        return this.shipmentVersion;
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.shipmentVersion = shipmentVersion;
    }


    public void copyTo(AbstractShipmentReceiptMvoCommand command)
    {
        command.setShipmentReceiptId((this.getShipmentReceiptId() == null) ? null : this.getShipmentReceiptId().toShipmentReceiptId());
        command.setShipmentVersion(this.getShipmentVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
