package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderShipGroupCommandDto extends AbstractCommand
{
    /**
     * Ship Group Seq Id
     */
    private Long shipGroupSeqId;

    public Long getShipGroupSeqId()
    {
        return this.shipGroupSeqId;
    }

    public void setShipGroupSeqId(Long shipGroupSeqId)
    {
        this.shipGroupSeqId = shipGroupSeqId;
    }


    public void copyTo(AbstractOrderShipGroupCommand command)
    {
        command.setShipGroupSeqId(this.getShipGroupSeqId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
