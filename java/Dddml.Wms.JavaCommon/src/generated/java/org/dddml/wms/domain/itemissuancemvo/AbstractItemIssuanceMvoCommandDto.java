package org.dddml.wms.domain.itemissuancemvo;

import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractItemIssuanceMvoCommandDto extends AbstractCommand
{
    /**
     * Shipment Item Issuance Id
     */
    private ShipmentItemIssuanceId shipmentItemIssuanceId;

    public ShipmentItemIssuanceId getShipmentItemIssuanceId()
    {
        return this.shipmentItemIssuanceId;
    }

    public void setShipmentItemIssuanceId(ShipmentItemIssuanceId shipmentItemIssuanceId)
    {
        this.shipmentItemIssuanceId = shipmentItemIssuanceId;
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


    public void copyTo(AbstractItemIssuanceMvoCommand command)
    {
        command.setShipmentItemIssuanceId(this.getShipmentItemIssuanceId());
        command.setShipmentVersion(this.getShipmentVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
