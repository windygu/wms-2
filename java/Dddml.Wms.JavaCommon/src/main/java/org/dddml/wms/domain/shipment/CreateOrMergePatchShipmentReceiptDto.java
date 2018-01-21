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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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

    private String rejectionReasonId;

    public String getRejectionReasonId()
    {
        return this.rejectionReasonId;
    }

    public void setRejectionReasonId(String rejectionReasonId)
    {
        this.rejectionReasonId = rejectionReasonId;
    }

    private String damageStatusId;

    public String getDamageStatusId()
    {
        return this.damageStatusId;
    }

    public void setDamageStatusId(String damageStatusId)
    {
        this.damageStatusId = damageStatusId;
    }

    private String damageReasonId;

    public String getDamageReasonId()
    {
        return this.damageReasonId;
    }

    public void setDamageReasonId(String damageReasonId)
    {
        this.damageReasonId = damageReasonId;
    }

    private String receivedBy;

    public String getReceivedBy()
    {
        return this.receivedBy;
    }

    public void setReceivedBy(String receivedBy)
    {
        this.receivedBy = receivedBy;
    }

    private java.sql.Timestamp datetimeReceived;

    public java.sql.Timestamp getDatetimeReceived()
    {
        return this.datetimeReceived;
    }

    public void setDatetimeReceived(java.sql.Timestamp datetimeReceived)
    {
        this.datetimeReceived = datetimeReceived;
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

    private java.math.BigDecimal damagedQuantity;

    public java.math.BigDecimal getDamagedQuantity()
    {
        return this.damagedQuantity;
    }

    public void setDamagedQuantity(java.math.BigDecimal damagedQuantity)
    {
        this.damagedQuantity = damagedQuantity;
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

    private Boolean isPropertyAttributeSetInstanceIdRemoved;

    public Boolean getIsPropertyAttributeSetInstanceIdRemoved()
    {
        return this.isPropertyAttributeSetInstanceIdRemoved;
    }

    public void setIsPropertyAttributeSetInstanceIdRemoved(Boolean removed)
    {
        this.isPropertyAttributeSetInstanceIdRemoved = removed;
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

    private Boolean isPropertyRejectionReasonIdRemoved;

    public Boolean getIsPropertyRejectionReasonIdRemoved()
    {
        return this.isPropertyRejectionReasonIdRemoved;
    }

    public void setIsPropertyRejectionReasonIdRemoved(Boolean removed)
    {
        this.isPropertyRejectionReasonIdRemoved = removed;
    }

    private Boolean isPropertyDamageStatusIdRemoved;

    public Boolean getIsPropertyDamageStatusIdRemoved()
    {
        return this.isPropertyDamageStatusIdRemoved;
    }

    public void setIsPropertyDamageStatusIdRemoved(Boolean removed)
    {
        this.isPropertyDamageStatusIdRemoved = removed;
    }

    private Boolean isPropertyDamageReasonIdRemoved;

    public Boolean getIsPropertyDamageReasonIdRemoved()
    {
        return this.isPropertyDamageReasonIdRemoved;
    }

    public void setIsPropertyDamageReasonIdRemoved(Boolean removed)
    {
        this.isPropertyDamageReasonIdRemoved = removed;
    }

    private Boolean isPropertyReceivedByRemoved;

    public Boolean getIsPropertyReceivedByRemoved()
    {
        return this.isPropertyReceivedByRemoved;
    }

    public void setIsPropertyReceivedByRemoved(Boolean removed)
    {
        this.isPropertyReceivedByRemoved = removed;
    }

    private Boolean isPropertyDatetimeReceivedRemoved;

    public Boolean getIsPropertyDatetimeReceivedRemoved()
    {
        return this.isPropertyDatetimeReceivedRemoved;
    }

    public void setIsPropertyDatetimeReceivedRemoved(Boolean removed)
    {
        this.isPropertyDatetimeReceivedRemoved = removed;
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

    private Boolean isPropertyDamagedQuantityRemoved;

    public Boolean getIsPropertyDamagedQuantityRemoved()
    {
        return this.isPropertyDamagedQuantityRemoved;
    }

    public void setIsPropertyDamagedQuantityRemoved(Boolean removed)
    {
        this.isPropertyDamagedQuantityRemoved = removed;
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
        command.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        command.setShipmentItemSeqId(this.getShipmentItemSeqId());
        command.setRejectionReasonId(this.getRejectionReasonId());
        command.setDamageStatusId(this.getDamageStatusId());
        command.setDamageReasonId(this.getDamageReasonId());
        command.setReceivedBy(this.getReceivedBy());
        command.setDatetimeReceived(this.getDatetimeReceived());
        command.setItemDescription(this.getItemDescription());
        command.setAcceptedQuantity(this.getAcceptedQuantity());
        command.setRejectedQuantity(this.getRejectedQuantity());
        command.setDamagedQuantity(this.getDamagedQuantity());
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
        command.setIsPropertyAttributeSetInstanceIdRemoved(this.getIsPropertyAttributeSetInstanceIdRemoved());
        command.setIsPropertyShipmentItemSeqIdRemoved(this.getIsPropertyShipmentItemSeqIdRemoved());
        command.setIsPropertyRejectionReasonIdRemoved(this.getIsPropertyRejectionReasonIdRemoved());
        command.setIsPropertyDamageStatusIdRemoved(this.getIsPropertyDamageStatusIdRemoved());
        command.setIsPropertyDamageReasonIdRemoved(this.getIsPropertyDamageReasonIdRemoved());
        command.setIsPropertyReceivedByRemoved(this.getIsPropertyReceivedByRemoved());
        command.setIsPropertyDatetimeReceivedRemoved(this.getIsPropertyDatetimeReceivedRemoved());
        command.setIsPropertyItemDescriptionRemoved(this.getIsPropertyItemDescriptionRemoved());
        command.setIsPropertyAcceptedQuantityRemoved(this.getIsPropertyAcceptedQuantityRemoved());
        command.setIsPropertyRejectedQuantityRemoved(this.getIsPropertyRejectedQuantityRemoved());
        command.setIsPropertyDamagedQuantityRemoved(this.getIsPropertyDamagedQuantityRemoved());
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

