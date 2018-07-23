package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentReceiptCommandDto extends AbstractCommand
{
    /**
     * Receipt Seq Id
     */
    private String receiptSeqId;

    public String getReceiptSeqId()
    {
        return this.receiptSeqId;
    }

    public void setReceiptSeqId(String receiptSeqId)
    {
        this.receiptSeqId = receiptSeqId;
    }


    public void copyTo(AbstractShipmentReceiptCommand command)
    {
        command.setReceiptSeqId(this.getReceiptSeqId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
