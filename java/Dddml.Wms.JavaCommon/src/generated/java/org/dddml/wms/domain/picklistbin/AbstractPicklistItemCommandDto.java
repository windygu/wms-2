package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistItemCommandDto extends AbstractCommand
{
    private PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId;

    public PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId()
    {
        return this.picklistItemOrderShipGrpInvId;
    }

    public void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
    {
        this.picklistItemOrderShipGrpInvId = picklistItemOrderShipGrpInvId;
    }


    public void copyTo(AbstractPicklistItemCommand command)
    {
        command.setPicklistItemOrderShipGrpInvId(this.getPicklistItemOrderShipGrpInvId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
