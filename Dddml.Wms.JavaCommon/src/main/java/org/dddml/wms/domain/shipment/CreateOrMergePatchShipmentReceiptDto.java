package org.dddml.wms.domain.shipment;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentReceiptDto extends AbstractShipmentReceiptCommandDto
{
    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    private String shipmentItemSeqId;

    public String getShipmentItemSeqId()
    {
        return this.shipmentItemSeqId;
    }

    public void setShipmentItemSeqId(String shipmentItemSeqId)
    {
        this.shipmentItemSeqId = shipmentItemSeqId;
    }

    private String rejectionId;

    public String getRejectionId()
    {
        return this.rejectionId;
    }

    public void setRejectionId(String rejectionId)
    {
        this.rejectionId = rejectionId;
    }

    private String itemDescription;

    public String getItemDescription()
    {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    private java.math.BigDecimal acceptedQuantity;

    public java.math.BigDecimal getAcceptedQuantity()
    {
        return this.acceptedQuantity;
    }

    public void setAcceptedQuantity(java.math.BigDecimal acceptedQuantity)
    {
        this.acceptedQuantity = acceptedQuantity;
    }

    private java.math.BigDecimal rejectedQuantity;

    public java.math.BigDecimal getRejectedQuantity()
    {
        return this.rejectedQuantity;
    }

    public void setRejectedQuantity(java.math.BigDecimal rejectedQuantity)
    {
        this.rejectedQuantity = rejectedQuantity;
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

    private Boolean isPropertyProductIdRemoved;

    public Boolean getIsPropertyProductIdRemoved()
    {
        return this.isPropertyProductIdRemoved;
    }

    public void setIsPropertyProductIdRemoved(Boolean removed)
    {
        this.isPropertyProductIdRemoved = removed;
    }

    private Boolean isPropertyShipmentItemSeqIdRemoved;

    public Boolean getIsPropertyShipmentItemSeqIdRemoved()
    {
        return this.isPropertyShipmentItemSeqIdRemoved;
    }

    public void setIsPropertyShipmentItemSeqIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentItemSeqIdRemoved = removed;
    }

    private Boolean isPropertyRejectionIdRemoved;

    public Boolean getIsPropertyRejectionIdRemoved()
    {
        return this.isPropertyRejectionIdRemoved;
    }

    public void setIsPropertyRejectionIdRemoved(Boolean removed)
    {
        this.isPropertyRejectionIdRemoved = removed;
    }

    private Boolean isPropertyItemDescriptionRemoved;

    public Boolean getIsPropertyItemDescriptionRemoved()
    {
        return this.isPropertyItemDescriptionRemoved;
    }

    public void setIsPropertyItemDescriptionRemoved(Boolean removed)
    {
        this.isPropertyItemDescriptionRemoved = removed;
    }

    private Boolean isPropertyAcceptedQuantityRemoved;

    public Boolean getIsPropertyAcceptedQuantityRemoved()
    {
        return this.isPropertyAcceptedQuantityRemoved;
    }

    public void setIsPropertyAcceptedQuantityRemoved(Boolean removed)
    {
        this.isPropertyAcceptedQuantityRemoved = removed;
    }

    private Boolean isPropertyRejectedQuantityRemoved;

    public Boolean getIsPropertyRejectedQuantityRemoved()
    {
        return this.isPropertyRejectedQuantityRemoved;
    }

    public void setIsPropertyRejectedQuantityRemoved(Boolean removed)
    {
        this.isPropertyRejectedQuantityRemoved = removed;
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

    public void copyTo(AbstractShipmentReceiptCommand.AbstractCreateOrMergePatchShipmentReceipt command)
    {
        ((AbstractShipmentReceiptCommandDto) this).copyTo(command);
        command.setProductId(this.getProductId());
        command.setShipmentItemSeqId(this.getShipmentItemSeqId());
        command.setRejectionId(this.getRejectionId());
        command.setItemDescription(this.getItemDescription());
        command.setAcceptedQuantity(this.getAcceptedQuantity());
        command.setRejectedQuantity(this.getRejectedQuantity());
        command.setActive(this.getActive());
    }

    public ShipmentReceiptCommand toCommand()
    {
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt command = new AbstractShipmentReceiptCommand.SimpleCreateShipmentReceipt();
            copyTo((AbstractShipmentReceiptCommand.AbstractCreateShipmentReceipt) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt command = new AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt();
            copyTo((AbstractShipmentReceiptCommand.SimpleMergePatchShipmentReceipt) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt command = new AbstractShipmentReceiptCommand.SimpleRemoveShipmentReceipt();
            ((AbstractShipmentReceiptCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentReceiptCommand.AbstractCreateShipmentReceipt command)
    {
        copyTo((AbstractShipmentReceiptCommand.AbstractCreateOrMergePatchShipmentReceipt) command);
    }

    public void copyTo(AbstractShipmentReceiptCommand.AbstractMergePatchShipmentReceipt command)
    {
        copyTo((AbstractShipmentReceiptCommand.AbstractCreateOrMergePatchShipmentReceipt) command);
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyShipmentItemSeqIdRemoved(this.getIsPropertyShipmentItemSeqIdRemoved());
        command.setIsPropertyRejectionIdRemoved(this.getIsPropertyRejectionIdRemoved());
        command.setIsPropertyItemDescriptionRemoved(this.getIsPropertyItemDescriptionRemoved());
        command.setIsPropertyAcceptedQuantityRemoved(this.getIsPropertyAcceptedQuantityRemoved());
        command.setIsPropertyRejectedQuantityRemoved(this.getIsPropertyRejectedQuantityRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateShipmentReceiptDto extends CreateOrMergePatchShipmentReceiptDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentReceiptCommand.CreateShipmentReceipt toCreateShipmentReceipt()
        {
            return (ShipmentReceiptCommand.CreateShipmentReceipt) toCommand();
        }

    }

    public static class MergePatchShipmentReceiptDto extends CreateOrMergePatchShipmentReceiptDto
    {
        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentReceiptCommand.MergePatchShipmentReceipt toMergePatchShipmentReceipt()
        {
            return (ShipmentReceiptCommand.MergePatchShipmentReceipt) toCommand();
        }

    }

}

