package org.dddml.wms.domain.shipmentpackagecontentmvo;

import org.dddml.wms.domain.shipmentpackage.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentPackageContentMvoCommandDto extends AbstractCommand
{
    /**
     * Shipment Package Content Id
     */
    private ShipmentPackageContentId shipmentPackageContentId;

    public ShipmentPackageContentId getShipmentPackageContentId()
    {
        return this.shipmentPackageContentId;
    }

    public void setShipmentPackageContentId(ShipmentPackageContentId shipmentPackageContentId)
    {
        this.shipmentPackageContentId = shipmentPackageContentId;
    }

    /**
     * Shipment Package Version
     */
    private Long shipmentPackageVersion;

    public Long getShipmentPackageVersion()
    {
        return this.shipmentPackageVersion;
    }

    public void setShipmentPackageVersion(Long shipmentPackageVersion)
    {
        this.shipmentPackageVersion = shipmentPackageVersion;
    }


    public void copyTo(AbstractShipmentPackageContentMvoCommand command)
    {
        command.setShipmentPackageContentId(this.getShipmentPackageContentId());
        command.setShipmentPackageVersion(this.getShipmentPackageVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
