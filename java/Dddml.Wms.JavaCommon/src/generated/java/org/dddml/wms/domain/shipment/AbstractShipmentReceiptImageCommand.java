package org.dddml.wms.domain.shipment;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractShipmentReceiptImageCommand extends AbstractCommand implements ShipmentReceiptImageCommand
{
    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    private String shipmentId;

    public String getShipmentId()
    {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    private String shipmentReceiptReceiptSeqId;

    public String getShipmentReceiptReceiptSeqId()
    {
        return this.shipmentReceiptReceiptSeqId;
    }

    public void setShipmentReceiptReceiptSeqId(String shipmentReceiptReceiptSeqId)
    {
        this.shipmentReceiptReceiptSeqId = shipmentReceiptReceiptSeqId;
    }


    public static abstract class AbstractCreateOrMergePatchShipmentReceiptImage extends AbstractShipmentReceiptImageCommand implements CreateOrMergePatchShipmentReceiptImage
    {
        private String url;

        public String getUrl()
        {
            return this.url;
        }

        public void setUrl(String url)
        {
            this.url = url;
        }

        private Boolean active;

        public Boolean getActive()
        {
            return this.active;
        }

        public void setActive(Boolean active)
        {
            this.active = active;
        }

    }

    public static abstract class AbstractCreateShipmentReceiptImage extends AbstractCreateOrMergePatchShipmentReceiptImage implements CreateShipmentReceiptImage
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }

    }

    public static abstract class AbstractMergePatchShipmentReceiptImage extends AbstractCreateOrMergePatchShipmentReceiptImage implements MergePatchShipmentReceiptImage
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }

        private Boolean isPropertyUrlRemoved;

        public Boolean getIsPropertyUrlRemoved()
        {
            return this.isPropertyUrlRemoved;
        }

        public void setIsPropertyUrlRemoved(Boolean removed)
        {
            this.isPropertyUrlRemoved = removed;
        }

        private Boolean isPropertyActiveRemoved;

        public Boolean getIsPropertyActiveRemoved()
        {
            return this.isPropertyActiveRemoved;
        }

        public void setIsPropertyActiveRemoved(Boolean removed)
        {
            this.isPropertyActiveRemoved = removed;
        }

    }

    public static class SimpleCreateShipmentReceiptImage extends AbstractCreateShipmentReceiptImage
    {
    }

    
    public static class SimpleMergePatchShipmentReceiptImage extends AbstractMergePatchShipmentReceiptImage
    {
    }

    
	public static class SimpleRemoveShipmentReceiptImage extends AbstractShipmentReceiptImageCommand implements RemoveShipmentReceiptImage
	{
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_REMOVE;
        }
	}

    

}

