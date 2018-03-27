package org.dddml.wms.domain.shipmentpackage;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentPackageContentCommandDto extends AbstractCommand
{
    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }


    public void copyTo(AbstractShipmentPackageContentCommand command)
    {
        command.setShipmentItemSeqId(this.getShipmentItemSeqId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
