package org.dddml.wms.domain.order;

import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchOrderItemDto extends AbstractOrderItemCommandDto
{
    /**
     * Product Id
     */
    private String productId;

    public String getProductId()
    {
        return this.productId;
    }

    public void setProductId(String productId)
    {
        this.productId = productId;
    }

    /**
     * External Product Id
     */
    private String externalProductId;

    public String getExternalProductId()
    {
        return this.externalProductId;
    }

    public void setExternalProductId(String externalProductId)
    {
        this.externalProductId = externalProductId;
    }

    /**
     * Quantity
     */
    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Cancel Quantity
     */
    private java.math.BigDecimal cancelQuantity;

    public java.math.BigDecimal getCancelQuantity()
    {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(java.math.BigDecimal cancelQuantity)
    {
        this.cancelQuantity = cancelQuantity;
    }

    /**
     * Selected Amount
     */
    private java.math.BigDecimal selectedAmount;

    public java.math.BigDecimal getSelectedAmount()
    {
        return this.selectedAmount;
    }

    public void setSelectedAmount(java.math.BigDecimal selectedAmount)
    {
        this.selectedAmount = selectedAmount;
    }

    /**
     * External Id
     */
    private String externalId;

    public String getExternalId()
    {
        return this.externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    /**
     * Order Item Type Id
     */
    private String orderItemTypeId;

    public String getOrderItemTypeId()
    {
        return this.orderItemTypeId;
    }

    public void setOrderItemTypeId(String orderItemTypeId)
    {
        this.orderItemTypeId = orderItemTypeId;
    }

    /**
     * Order Item Group Seq Id
     */
    private String orderItemGroupSeqId;

    public String getOrderItemGroupSeqId()
    {
        return this.orderItemGroupSeqId;
    }

    public void setOrderItemGroupSeqId(String orderItemGroupSeqId)
    {
        this.orderItemGroupSeqId = orderItemGroupSeqId;
    }

    /**
     * Is Item Group Primary
     */
    private String isItemGroupPrimary;

    public String getIsItemGroupPrimary()
    {
        return this.isItemGroupPrimary;
    }

    public void setIsItemGroupPrimary(String isItemGroupPrimary)
    {
        this.isItemGroupPrimary = isItemGroupPrimary;
    }

    /**
     * From Inventory Item Id
     */
    private String fromInventoryItemId;

    public String getFromInventoryItemId()
    {
        return this.fromInventoryItemId;
    }

    public void setFromInventoryItemId(String fromInventoryItemId)
    {
        this.fromInventoryItemId = fromInventoryItemId;
    }

    /**
     * Is Promo
     */
    private String isPromo;

    public String getIsPromo()
    {
        return this.isPromo;
    }

    public void setIsPromo(String isPromo)
    {
        this.isPromo = isPromo;
    }

    /**
     * Quote Id
     */
    private String quoteId;

    public String getQuoteId()
    {
        return this.quoteId;
    }

    public void setQuoteId(String quoteId)
    {
        this.quoteId = quoteId;
    }

    /**
     * Quote Item Seq Id
     */
    private String quoteItemSeqId;

    public String getQuoteItemSeqId()
    {
        return this.quoteItemSeqId;
    }

    public void setQuoteItemSeqId(String quoteItemSeqId)
    {
        this.quoteItemSeqId = quoteItemSeqId;
    }

    /**
     * Shopping List Id
     */
    private String shoppingListId;

    public String getShoppingListId()
    {
        return this.shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    /**
     * Shopping List Item Seq Id
     */
    private String shoppingListItemSeqId;

    public String getShoppingListItemSeqId()
    {
        return this.shoppingListItemSeqId;
    }

    public void setShoppingListItemSeqId(String shoppingListItemSeqId)
    {
        this.shoppingListItemSeqId = shoppingListItemSeqId;
    }

    /**
     * Unit Price
     */
    private java.math.BigDecimal unitPrice;

    public java.math.BigDecimal getUnitPrice()
    {
        return this.unitPrice;
    }

    public void setUnitPrice(java.math.BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    /**
     * Unit List Price
     */
    private java.math.BigDecimal unitListPrice;

    public java.math.BigDecimal getUnitListPrice()
    {
        return this.unitListPrice;
    }

    public void setUnitListPrice(java.math.BigDecimal unitListPrice)
    {
        this.unitListPrice = unitListPrice;
    }

    /**
     * Unit Average Cost
     */
    private java.math.BigDecimal unitAverageCost;

    public java.math.BigDecimal getUnitAverageCost()
    {
        return this.unitAverageCost;
    }

    public void setUnitAverageCost(java.math.BigDecimal unitAverageCost)
    {
        this.unitAverageCost = unitAverageCost;
    }

    /**
     * Unit Recurring Price
     */
    private java.math.BigDecimal unitRecurringPrice;

    public java.math.BigDecimal getUnitRecurringPrice()
    {
        return this.unitRecurringPrice;
    }

    public void setUnitRecurringPrice(java.math.BigDecimal unitRecurringPrice)
    {
        this.unitRecurringPrice = unitRecurringPrice;
    }

    /**
     * Is Modified Price
     */
    private String isModifiedPrice;

    public String getIsModifiedPrice()
    {
        return this.isModifiedPrice;
    }

    public void setIsModifiedPrice(String isModifiedPrice)
    {
        this.isModifiedPrice = isModifiedPrice;
    }

    /**
     * Recurring Freq Uom Id
     */
    private String recurringFreqUomId;

    public String getRecurringFreqUomId()
    {
        return this.recurringFreqUomId;
    }

    public void setRecurringFreqUomId(String recurringFreqUomId)
    {
        this.recurringFreqUomId = recurringFreqUomId;
    }

    /**
     * Item Description
     */
    private String itemDescription;

    public String getItemDescription()
    {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    /**
     * Comments
     */
    private String comments;

    public String getComments()
    {
        return this.comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    /**
     * Corresponding Po Id
     */
    private String correspondingPoId;

    public String getCorrespondingPoId()
    {
        return this.correspondingPoId;
    }

    public void setCorrespondingPoId(String correspondingPoId)
    {
        this.correspondingPoId = correspondingPoId;
    }

    /**
     * Status Id
     */
    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    /**
     * Sync Status Id
     */
    private String syncStatusId;

    public String getSyncStatusId()
    {
        return this.syncStatusId;
    }

    public void setSyncStatusId(String syncStatusId)
    {
        this.syncStatusId = syncStatusId;
    }

    /**
     * Estimated Ship Date
     */
    private java.sql.Timestamp estimatedShipDate;

    public java.sql.Timestamp getEstimatedShipDate()
    {
        return this.estimatedShipDate;
    }

    public void setEstimatedShipDate(java.sql.Timestamp estimatedShipDate)
    {
        this.estimatedShipDate = estimatedShipDate;
    }

    /**
     * Estimated Delivery Date
     */
    private java.sql.Timestamp estimatedDeliveryDate;

    public java.sql.Timestamp getEstimatedDeliveryDate()
    {
        return this.estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(java.sql.Timestamp estimatedDeliveryDate)
    {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    /**
     * Auto Cancel Date
     */
    private java.sql.Timestamp autoCancelDate;

    public java.sql.Timestamp getAutoCancelDate()
    {
        return this.autoCancelDate;
    }

    public void setAutoCancelDate(java.sql.Timestamp autoCancelDate)
    {
        this.autoCancelDate = autoCancelDate;
    }

    /**
     * Dont Cancel Set Date
     */
    private java.sql.Timestamp dontCancelSetDate;

    public java.sql.Timestamp getDontCancelSetDate()
    {
        return this.dontCancelSetDate;
    }

    public void setDontCancelSetDate(java.sql.Timestamp dontCancelSetDate)
    {
        this.dontCancelSetDate = dontCancelSetDate;
    }

    /**
     * Dont Cancel Set By
     */
    private String dontCancelSetBy;

    public String getDontCancelSetBy()
    {
        return this.dontCancelSetBy;
    }

    public void setDontCancelSetBy(String dontCancelSetBy)
    {
        this.dontCancelSetBy = dontCancelSetBy;
    }

    /**
     * Ship Before Date
     */
    private java.sql.Timestamp shipBeforeDate;

    public java.sql.Timestamp getShipBeforeDate()
    {
        return this.shipBeforeDate;
    }

    public void setShipBeforeDate(java.sql.Timestamp shipBeforeDate)
    {
        this.shipBeforeDate = shipBeforeDate;
    }

    /**
     * Ship After Date
     */
    private java.sql.Timestamp shipAfterDate;

    public java.sql.Timestamp getShipAfterDate()
    {
        return this.shipAfterDate;
    }

    public void setShipAfterDate(java.sql.Timestamp shipAfterDate)
    {
        this.shipAfterDate = shipAfterDate;
    }

    /**
     * Used to cancel all orders from suppliers when its in past
     */
    private java.sql.Timestamp cancelBackOrderDate;

    public java.sql.Timestamp getCancelBackOrderDate()
    {
        return this.cancelBackOrderDate;
    }

    public void setCancelBackOrderDate(java.sql.Timestamp cancelBackOrderDate)
    {
        this.cancelBackOrderDate = cancelBackOrderDate;
    }

    /**
     * Used to specify the override or actual glAccountId used for the adjustment, avoids problems if configuration changes after initial posting, etc.
     */
    private String overrideGlAccountId;

    public String getOverrideGlAccountId()
    {
        return this.overrideGlAccountId;
    }

    public void setOverrideGlAccountId(String overrideGlAccountId)
    {
        this.overrideGlAccountId = overrideGlAccountId;
    }

    /**
     * Active
     */
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

    private Boolean isPropertyExternalProductIdRemoved;

    public Boolean getIsPropertyExternalProductIdRemoved()
    {
        return this.isPropertyExternalProductIdRemoved;
    }

    public void setIsPropertyExternalProductIdRemoved(Boolean removed)
    {
        this.isPropertyExternalProductIdRemoved = removed;
    }

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyCancelQuantityRemoved;

    public Boolean getIsPropertyCancelQuantityRemoved()
    {
        return this.isPropertyCancelQuantityRemoved;
    }

    public void setIsPropertyCancelQuantityRemoved(Boolean removed)
    {
        this.isPropertyCancelQuantityRemoved = removed;
    }

    private Boolean isPropertySelectedAmountRemoved;

    public Boolean getIsPropertySelectedAmountRemoved()
    {
        return this.isPropertySelectedAmountRemoved;
    }

    public void setIsPropertySelectedAmountRemoved(Boolean removed)
    {
        this.isPropertySelectedAmountRemoved = removed;
    }

    private Boolean isPropertyExternalIdRemoved;

    public Boolean getIsPropertyExternalIdRemoved()
    {
        return this.isPropertyExternalIdRemoved;
    }

    public void setIsPropertyExternalIdRemoved(Boolean removed)
    {
        this.isPropertyExternalIdRemoved = removed;
    }

    private Boolean isPropertyOrderItemTypeIdRemoved;

    public Boolean getIsPropertyOrderItemTypeIdRemoved()
    {
        return this.isPropertyOrderItemTypeIdRemoved;
    }

    public void setIsPropertyOrderItemTypeIdRemoved(Boolean removed)
    {
        this.isPropertyOrderItemTypeIdRemoved = removed;
    }

    private Boolean isPropertyOrderItemGroupSeqIdRemoved;

    public Boolean getIsPropertyOrderItemGroupSeqIdRemoved()
    {
        return this.isPropertyOrderItemGroupSeqIdRemoved;
    }

    public void setIsPropertyOrderItemGroupSeqIdRemoved(Boolean removed)
    {
        this.isPropertyOrderItemGroupSeqIdRemoved = removed;
    }

    private Boolean isPropertyIsItemGroupPrimaryRemoved;

    public Boolean getIsPropertyIsItemGroupPrimaryRemoved()
    {
        return this.isPropertyIsItemGroupPrimaryRemoved;
    }

    public void setIsPropertyIsItemGroupPrimaryRemoved(Boolean removed)
    {
        this.isPropertyIsItemGroupPrimaryRemoved = removed;
    }

    private Boolean isPropertyFromInventoryItemIdRemoved;

    public Boolean getIsPropertyFromInventoryItemIdRemoved()
    {
        return this.isPropertyFromInventoryItemIdRemoved;
    }

    public void setIsPropertyFromInventoryItemIdRemoved(Boolean removed)
    {
        this.isPropertyFromInventoryItemIdRemoved = removed;
    }

    private Boolean isPropertyIsPromoRemoved;

    public Boolean getIsPropertyIsPromoRemoved()
    {
        return this.isPropertyIsPromoRemoved;
    }

    public void setIsPropertyIsPromoRemoved(Boolean removed)
    {
        this.isPropertyIsPromoRemoved = removed;
    }

    private Boolean isPropertyQuoteIdRemoved;

    public Boolean getIsPropertyQuoteIdRemoved()
    {
        return this.isPropertyQuoteIdRemoved;
    }

    public void setIsPropertyQuoteIdRemoved(Boolean removed)
    {
        this.isPropertyQuoteIdRemoved = removed;
    }

    private Boolean isPropertyQuoteItemSeqIdRemoved;

    public Boolean getIsPropertyQuoteItemSeqIdRemoved()
    {
        return this.isPropertyQuoteItemSeqIdRemoved;
    }

    public void setIsPropertyQuoteItemSeqIdRemoved(Boolean removed)
    {
        this.isPropertyQuoteItemSeqIdRemoved = removed;
    }

    private Boolean isPropertyShoppingListIdRemoved;

    public Boolean getIsPropertyShoppingListIdRemoved()
    {
        return this.isPropertyShoppingListIdRemoved;
    }

    public void setIsPropertyShoppingListIdRemoved(Boolean removed)
    {
        this.isPropertyShoppingListIdRemoved = removed;
    }

    private Boolean isPropertyShoppingListItemSeqIdRemoved;

    public Boolean getIsPropertyShoppingListItemSeqIdRemoved()
    {
        return this.isPropertyShoppingListItemSeqIdRemoved;
    }

    public void setIsPropertyShoppingListItemSeqIdRemoved(Boolean removed)
    {
        this.isPropertyShoppingListItemSeqIdRemoved = removed;
    }

    private Boolean isPropertyUnitPriceRemoved;

    public Boolean getIsPropertyUnitPriceRemoved()
    {
        return this.isPropertyUnitPriceRemoved;
    }

    public void setIsPropertyUnitPriceRemoved(Boolean removed)
    {
        this.isPropertyUnitPriceRemoved = removed;
    }

    private Boolean isPropertyUnitListPriceRemoved;

    public Boolean getIsPropertyUnitListPriceRemoved()
    {
        return this.isPropertyUnitListPriceRemoved;
    }

    public void setIsPropertyUnitListPriceRemoved(Boolean removed)
    {
        this.isPropertyUnitListPriceRemoved = removed;
    }

    private Boolean isPropertyUnitAverageCostRemoved;

    public Boolean getIsPropertyUnitAverageCostRemoved()
    {
        return this.isPropertyUnitAverageCostRemoved;
    }

    public void setIsPropertyUnitAverageCostRemoved(Boolean removed)
    {
        this.isPropertyUnitAverageCostRemoved = removed;
    }

    private Boolean isPropertyUnitRecurringPriceRemoved;

    public Boolean getIsPropertyUnitRecurringPriceRemoved()
    {
        return this.isPropertyUnitRecurringPriceRemoved;
    }

    public void setIsPropertyUnitRecurringPriceRemoved(Boolean removed)
    {
        this.isPropertyUnitRecurringPriceRemoved = removed;
    }

    private Boolean isPropertyIsModifiedPriceRemoved;

    public Boolean getIsPropertyIsModifiedPriceRemoved()
    {
        return this.isPropertyIsModifiedPriceRemoved;
    }

    public void setIsPropertyIsModifiedPriceRemoved(Boolean removed)
    {
        this.isPropertyIsModifiedPriceRemoved = removed;
    }

    private Boolean isPropertyRecurringFreqUomIdRemoved;

    public Boolean getIsPropertyRecurringFreqUomIdRemoved()
    {
        return this.isPropertyRecurringFreqUomIdRemoved;
    }

    public void setIsPropertyRecurringFreqUomIdRemoved(Boolean removed)
    {
        this.isPropertyRecurringFreqUomIdRemoved = removed;
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

    private Boolean isPropertyCommentsRemoved;

    public Boolean getIsPropertyCommentsRemoved()
    {
        return this.isPropertyCommentsRemoved;
    }

    public void setIsPropertyCommentsRemoved(Boolean removed)
    {
        this.isPropertyCommentsRemoved = removed;
    }

    private Boolean isPropertyCorrespondingPoIdRemoved;

    public Boolean getIsPropertyCorrespondingPoIdRemoved()
    {
        return this.isPropertyCorrespondingPoIdRemoved;
    }

    public void setIsPropertyCorrespondingPoIdRemoved(Boolean removed)
    {
        this.isPropertyCorrespondingPoIdRemoved = removed;
    }

    private Boolean isPropertyStatusIdRemoved;

    public Boolean getIsPropertyStatusIdRemoved()
    {
        return this.isPropertyStatusIdRemoved;
    }

    public void setIsPropertyStatusIdRemoved(Boolean removed)
    {
        this.isPropertyStatusIdRemoved = removed;
    }

    private Boolean isPropertySyncStatusIdRemoved;

    public Boolean getIsPropertySyncStatusIdRemoved()
    {
        return this.isPropertySyncStatusIdRemoved;
    }

    public void setIsPropertySyncStatusIdRemoved(Boolean removed)
    {
        this.isPropertySyncStatusIdRemoved = removed;
    }

    private Boolean isPropertyEstimatedShipDateRemoved;

    public Boolean getIsPropertyEstimatedShipDateRemoved()
    {
        return this.isPropertyEstimatedShipDateRemoved;
    }

    public void setIsPropertyEstimatedShipDateRemoved(Boolean removed)
    {
        this.isPropertyEstimatedShipDateRemoved = removed;
    }

    private Boolean isPropertyEstimatedDeliveryDateRemoved;

    public Boolean getIsPropertyEstimatedDeliveryDateRemoved()
    {
        return this.isPropertyEstimatedDeliveryDateRemoved;
    }

    public void setIsPropertyEstimatedDeliveryDateRemoved(Boolean removed)
    {
        this.isPropertyEstimatedDeliveryDateRemoved = removed;
    }

    private Boolean isPropertyAutoCancelDateRemoved;

    public Boolean getIsPropertyAutoCancelDateRemoved()
    {
        return this.isPropertyAutoCancelDateRemoved;
    }

    public void setIsPropertyAutoCancelDateRemoved(Boolean removed)
    {
        this.isPropertyAutoCancelDateRemoved = removed;
    }

    private Boolean isPropertyDontCancelSetDateRemoved;

    public Boolean getIsPropertyDontCancelSetDateRemoved()
    {
        return this.isPropertyDontCancelSetDateRemoved;
    }

    public void setIsPropertyDontCancelSetDateRemoved(Boolean removed)
    {
        this.isPropertyDontCancelSetDateRemoved = removed;
    }

    private Boolean isPropertyDontCancelSetByRemoved;

    public Boolean getIsPropertyDontCancelSetByRemoved()
    {
        return this.isPropertyDontCancelSetByRemoved;
    }

    public void setIsPropertyDontCancelSetByRemoved(Boolean removed)
    {
        this.isPropertyDontCancelSetByRemoved = removed;
    }

    private Boolean isPropertyShipBeforeDateRemoved;

    public Boolean getIsPropertyShipBeforeDateRemoved()
    {
        return this.isPropertyShipBeforeDateRemoved;
    }

    public void setIsPropertyShipBeforeDateRemoved(Boolean removed)
    {
        this.isPropertyShipBeforeDateRemoved = removed;
    }

    private Boolean isPropertyShipAfterDateRemoved;

    public Boolean getIsPropertyShipAfterDateRemoved()
    {
        return this.isPropertyShipAfterDateRemoved;
    }

    public void setIsPropertyShipAfterDateRemoved(Boolean removed)
    {
        this.isPropertyShipAfterDateRemoved = removed;
    }

    private Boolean isPropertyCancelBackOrderDateRemoved;

    public Boolean getIsPropertyCancelBackOrderDateRemoved()
    {
        return this.isPropertyCancelBackOrderDateRemoved;
    }

    public void setIsPropertyCancelBackOrderDateRemoved(Boolean removed)
    {
        this.isPropertyCancelBackOrderDateRemoved = removed;
    }

    private Boolean isPropertyOverrideGlAccountIdRemoved;

    public Boolean getIsPropertyOverrideGlAccountIdRemoved()
    {
        return this.isPropertyOverrideGlAccountIdRemoved;
    }

    public void setIsPropertyOverrideGlAccountIdRemoved(Boolean removed)
    {
        this.isPropertyOverrideGlAccountIdRemoved = removed;
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

    public void copyTo(AbstractOrderItemCommand.AbstractCreateOrMergePatchOrderItem command)
    {
        ((AbstractOrderItemCommandDto) this).copyTo(command);
        command.setProductId(this.getProductId());
        command.setExternalProductId(this.getExternalProductId());
        command.setQuantity(this.getQuantity());
        command.setCancelQuantity(this.getCancelQuantity());
        command.setSelectedAmount(this.getSelectedAmount());
        command.setExternalId(this.getExternalId());
        command.setOrderItemTypeId(this.getOrderItemTypeId());
        command.setOrderItemGroupSeqId(this.getOrderItemGroupSeqId());
        command.setIsItemGroupPrimary(this.getIsItemGroupPrimary());
        command.setFromInventoryItemId(this.getFromInventoryItemId());
        command.setIsPromo(this.getIsPromo());
        command.setQuoteId(this.getQuoteId());
        command.setQuoteItemSeqId(this.getQuoteItemSeqId());
        command.setShoppingListId(this.getShoppingListId());
        command.setShoppingListItemSeqId(this.getShoppingListItemSeqId());
        command.setUnitPrice(this.getUnitPrice());
        command.setUnitListPrice(this.getUnitListPrice());
        command.setUnitAverageCost(this.getUnitAverageCost());
        command.setUnitRecurringPrice(this.getUnitRecurringPrice());
        command.setIsModifiedPrice(this.getIsModifiedPrice());
        command.setRecurringFreqUomId(this.getRecurringFreqUomId());
        command.setItemDescription(this.getItemDescription());
        command.setComments(this.getComments());
        command.setCorrespondingPoId(this.getCorrespondingPoId());
        command.setStatusId(this.getStatusId());
        command.setSyncStatusId(this.getSyncStatusId());
        command.setEstimatedShipDate(this.getEstimatedShipDate());
        command.setEstimatedDeliveryDate(this.getEstimatedDeliveryDate());
        command.setAutoCancelDate(this.getAutoCancelDate());
        command.setDontCancelSetDate(this.getDontCancelSetDate());
        command.setDontCancelSetBy(this.getDontCancelSetBy());
        command.setShipBeforeDate(this.getShipBeforeDate());
        command.setShipAfterDate(this.getShipAfterDate());
        command.setCancelBackOrderDate(this.getCancelBackOrderDate());
        command.setOverrideGlAccountId(this.getOverrideGlAccountId());
        command.setActive(this.getActive());
    }

    public OrderItemCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractOrderItemCommand.SimpleCreateOrderItem command = new AbstractOrderItemCommand.SimpleCreateOrderItem();
            copyTo((AbstractOrderItemCommand.AbstractCreateOrderItem) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractOrderItemCommand.SimpleMergePatchOrderItem command = new AbstractOrderItemCommand.SimpleMergePatchOrderItem();
            copyTo((AbstractOrderItemCommand.SimpleMergePatchOrderItem) command);
            return command;
        } 
        else if (COMMAND_TYPE_REMOVE.equals(getCommandType())) {
            AbstractOrderItemCommand.SimpleRemoveOrderItem command = new AbstractOrderItemCommand.SimpleRemoveOrderItem();
            ((AbstractOrderItemCommandDto) this).copyTo(command);
            return command;
        }
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractOrderItemCommand.AbstractCreateOrderItem command)
    {
        copyTo((AbstractOrderItemCommand.AbstractCreateOrMergePatchOrderItem) command);
    }

    public void copyTo(AbstractOrderItemCommand.AbstractMergePatchOrderItem command)
    {
        copyTo((AbstractOrderItemCommand.AbstractCreateOrMergePatchOrderItem) command);
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyExternalProductIdRemoved(this.getIsPropertyExternalProductIdRemoved());
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertyCancelQuantityRemoved(this.getIsPropertyCancelQuantityRemoved());
        command.setIsPropertySelectedAmountRemoved(this.getIsPropertySelectedAmountRemoved());
        command.setIsPropertyExternalIdRemoved(this.getIsPropertyExternalIdRemoved());
        command.setIsPropertyOrderItemTypeIdRemoved(this.getIsPropertyOrderItemTypeIdRemoved());
        command.setIsPropertyOrderItemGroupSeqIdRemoved(this.getIsPropertyOrderItemGroupSeqIdRemoved());
        command.setIsPropertyIsItemGroupPrimaryRemoved(this.getIsPropertyIsItemGroupPrimaryRemoved());
        command.setIsPropertyFromInventoryItemIdRemoved(this.getIsPropertyFromInventoryItemIdRemoved());
        command.setIsPropertyIsPromoRemoved(this.getIsPropertyIsPromoRemoved());
        command.setIsPropertyQuoteIdRemoved(this.getIsPropertyQuoteIdRemoved());
        command.setIsPropertyQuoteItemSeqIdRemoved(this.getIsPropertyQuoteItemSeqIdRemoved());
        command.setIsPropertyShoppingListIdRemoved(this.getIsPropertyShoppingListIdRemoved());
        command.setIsPropertyShoppingListItemSeqIdRemoved(this.getIsPropertyShoppingListItemSeqIdRemoved());
        command.setIsPropertyUnitPriceRemoved(this.getIsPropertyUnitPriceRemoved());
        command.setIsPropertyUnitListPriceRemoved(this.getIsPropertyUnitListPriceRemoved());
        command.setIsPropertyUnitAverageCostRemoved(this.getIsPropertyUnitAverageCostRemoved());
        command.setIsPropertyUnitRecurringPriceRemoved(this.getIsPropertyUnitRecurringPriceRemoved());
        command.setIsPropertyIsModifiedPriceRemoved(this.getIsPropertyIsModifiedPriceRemoved());
        command.setIsPropertyRecurringFreqUomIdRemoved(this.getIsPropertyRecurringFreqUomIdRemoved());
        command.setIsPropertyItemDescriptionRemoved(this.getIsPropertyItemDescriptionRemoved());
        command.setIsPropertyCommentsRemoved(this.getIsPropertyCommentsRemoved());
        command.setIsPropertyCorrespondingPoIdRemoved(this.getIsPropertyCorrespondingPoIdRemoved());
        command.setIsPropertyStatusIdRemoved(this.getIsPropertyStatusIdRemoved());
        command.setIsPropertySyncStatusIdRemoved(this.getIsPropertySyncStatusIdRemoved());
        command.setIsPropertyEstimatedShipDateRemoved(this.getIsPropertyEstimatedShipDateRemoved());
        command.setIsPropertyEstimatedDeliveryDateRemoved(this.getIsPropertyEstimatedDeliveryDateRemoved());
        command.setIsPropertyAutoCancelDateRemoved(this.getIsPropertyAutoCancelDateRemoved());
        command.setIsPropertyDontCancelSetDateRemoved(this.getIsPropertyDontCancelSetDateRemoved());
        command.setIsPropertyDontCancelSetByRemoved(this.getIsPropertyDontCancelSetByRemoved());
        command.setIsPropertyShipBeforeDateRemoved(this.getIsPropertyShipBeforeDateRemoved());
        command.setIsPropertyShipAfterDateRemoved(this.getIsPropertyShipAfterDateRemoved());
        command.setIsPropertyCancelBackOrderDateRemoved(this.getIsPropertyCancelBackOrderDateRemoved());
        command.setIsPropertyOverrideGlAccountIdRemoved(this.getIsPropertyOverrideGlAccountIdRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
    }

    public static class CreateOrderItemDto extends CreateOrMergePatchOrderItemDto
    {
        public CreateOrderItemDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public OrderItemCommand.CreateOrderItem toCreateOrderItem()
        {
            return (OrderItemCommand.CreateOrderItem) toCommand();
        }

    }

    public static class MergePatchOrderItemDto extends CreateOrMergePatchOrderItemDto
    {
        public MergePatchOrderItemDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public OrderItemCommand.MergePatchOrderItem toMergePatchOrderItem()
        {
            return (OrderItemCommand.MergePatchOrderItem) toCommand();
        }

    }

}

