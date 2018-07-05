package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractItemIssuanceCommandDto extends AbstractCommand
{
    private String itemIssuanceSeqId;

    public String getItemIssuanceSeqId()
    {
        return this.itemIssuanceSeqId;
    }

    public void setItemIssuanceSeqId(String itemIssuanceSeqId)
    {
        this.itemIssuanceSeqId = itemIssuanceSeqId;
    }


}
