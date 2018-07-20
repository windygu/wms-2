package org.dddml.wms.domain.shipmentitemmvo;

import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public class CreateOrMergePatchShipmentItemMvoDto extends AbstractShipmentItemMvoCommandDto
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
     * Attribute Set Instance Id
     */
    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
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
     * Shipment Content Description
     */
    private String shipmentContentDescription;

    public String getShipmentContentDescription()
    {
        return this.shipmentContentDescription;
    }

    public void setShipmentContentDescription(String shipmentContentDescription)
    {
        this.shipmentContentDescription = shipmentContentDescription;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    /**
     * Shipment Shipment Type Id
     */
    private String shipmentShipmentTypeId;

    public String getShipmentShipmentTypeId()
    {
        return this.shipmentShipmentTypeId;
    }

    public void setShipmentShipmentTypeId(String shipmentShipmentTypeId)
    {
        this.shipmentShipmentTypeId = shipmentShipmentTypeId;
    }

    /**
     * Shipment Status Id
     */
    private String shipmentStatusId;

    public String getShipmentStatusId()
    {
        return this.shipmentStatusId;
    }

    public void setShipmentStatusId(String shipmentStatusId)
    {
        this.shipmentStatusId = shipmentStatusId;
    }

    /**
     * Shipment Primary Order Id
     */
    private String shipmentPrimaryOrderId;

    public String getShipmentPrimaryOrderId()
    {
        return this.shipmentPrimaryOrderId;
    }

    public void setShipmentPrimaryOrderId(String shipmentPrimaryOrderId)
    {
        this.shipmentPrimaryOrderId = shipmentPrimaryOrderId;
    }

    /**
     * Shipment Primary Return Id
     */
    private String shipmentPrimaryReturnId;

    public String getShipmentPrimaryReturnId()
    {
        return this.shipmentPrimaryReturnId;
    }

    public void setShipmentPrimaryReturnId(String shipmentPrimaryReturnId)
    {
        this.shipmentPrimaryReturnId = shipmentPrimaryReturnId;
    }

    /**
     * Shipment Primary Ship Group Seq Id
     */
    private Long shipmentPrimaryShipGroupSeqId;

    public Long getShipmentPrimaryShipGroupSeqId()
    {
        return this.shipmentPrimaryShipGroupSeqId;
    }

    public void setShipmentPrimaryShipGroupSeqId(Long shipmentPrimaryShipGroupSeqId)
    {
        this.shipmentPrimaryShipGroupSeqId = shipmentPrimaryShipGroupSeqId;
    }

    /**
     * Shipment Picklist Bin Id
     */
    private String shipmentPicklistBinId;

    public String getShipmentPicklistBinId()
    {
        return this.shipmentPicklistBinId;
    }

    public void setShipmentPicklistBinId(String shipmentPicklistBinId)
    {
        this.shipmentPicklistBinId = shipmentPicklistBinId;
    }

    /**
     * Shipment Estimated Ready Date
     */
    private java.sql.Timestamp shipmentEstimatedReadyDate;

    public java.sql.Timestamp getShipmentEstimatedReadyDate()
    {
        return this.shipmentEstimatedReadyDate;
    }

    public void setShipmentEstimatedReadyDate(java.sql.Timestamp shipmentEstimatedReadyDate)
    {
        this.shipmentEstimatedReadyDate = shipmentEstimatedReadyDate;
    }

    /**
     * Shipment Estimated Ship Date
     */
    private java.sql.Timestamp shipmentEstimatedShipDate;

    public java.sql.Timestamp getShipmentEstimatedShipDate()
    {
        return this.shipmentEstimatedShipDate;
    }

    public void setShipmentEstimatedShipDate(java.sql.Timestamp shipmentEstimatedShipDate)
    {
        this.shipmentEstimatedShipDate = shipmentEstimatedShipDate;
    }

    /**
     * Shipment Estimated Ship Work Eff Id
     */
    private String shipmentEstimatedShipWorkEffId;

    public String getShipmentEstimatedShipWorkEffId()
    {
        return this.shipmentEstimatedShipWorkEffId;
    }

    public void setShipmentEstimatedShipWorkEffId(String shipmentEstimatedShipWorkEffId)
    {
        this.shipmentEstimatedShipWorkEffId = shipmentEstimatedShipWorkEffId;
    }

    /**
     * Shipment Estimated Arrival Date
     */
    private java.sql.Timestamp shipmentEstimatedArrivalDate;

    public java.sql.Timestamp getShipmentEstimatedArrivalDate()
    {
        return this.shipmentEstimatedArrivalDate;
    }

    public void setShipmentEstimatedArrivalDate(java.sql.Timestamp shipmentEstimatedArrivalDate)
    {
        this.shipmentEstimatedArrivalDate = shipmentEstimatedArrivalDate;
    }

    /**
     * Shipment Estimated Arrival Work Eff Id
     */
    private String shipmentEstimatedArrivalWorkEffId;

    public String getShipmentEstimatedArrivalWorkEffId()
    {
        return this.shipmentEstimatedArrivalWorkEffId;
    }

    public void setShipmentEstimatedArrivalWorkEffId(String shipmentEstimatedArrivalWorkEffId)
    {
        this.shipmentEstimatedArrivalWorkEffId = shipmentEstimatedArrivalWorkEffId;
    }

    /**
     * Shipment Latest Cancel Date
     */
    private java.sql.Timestamp shipmentLatestCancelDate;

    public java.sql.Timestamp getShipmentLatestCancelDate()
    {
        return this.shipmentLatestCancelDate;
    }

    public void setShipmentLatestCancelDate(java.sql.Timestamp shipmentLatestCancelDate)
    {
        this.shipmentLatestCancelDate = shipmentLatestCancelDate;
    }

    /**
     * Shipment Estimated Ship Cost
     */
    private java.math.BigDecimal shipmentEstimatedShipCost;

    public java.math.BigDecimal getShipmentEstimatedShipCost()
    {
        return this.shipmentEstimatedShipCost;
    }

    public void setShipmentEstimatedShipCost(java.math.BigDecimal shipmentEstimatedShipCost)
    {
        this.shipmentEstimatedShipCost = shipmentEstimatedShipCost;
    }

    /**
     * Shipment Currency Uom Id
     */
    private String shipmentCurrencyUomId;

    public String getShipmentCurrencyUomId()
    {
        return this.shipmentCurrencyUomId;
    }

    public void setShipmentCurrencyUomId(String shipmentCurrencyUomId)
    {
        this.shipmentCurrencyUomId = shipmentCurrencyUomId;
    }

    /**
     * Shipment Handling Instructions
     */
    private String shipmentHandlingInstructions;

    public String getShipmentHandlingInstructions()
    {
        return this.shipmentHandlingInstructions;
    }

    public void setShipmentHandlingInstructions(String shipmentHandlingInstructions)
    {
        this.shipmentHandlingInstructions = shipmentHandlingInstructions;
    }

    /**
     * Shipment Origin Facility Id
     */
    private String shipmentOriginFacilityId;

    public String getShipmentOriginFacilityId()
    {
        return this.shipmentOriginFacilityId;
    }

    public void setShipmentOriginFacilityId(String shipmentOriginFacilityId)
    {
        this.shipmentOriginFacilityId = shipmentOriginFacilityId;
    }

    /**
     * Shipment Destination Facility Id
     */
    private String shipmentDestinationFacilityId;

    public String getShipmentDestinationFacilityId()
    {
        return this.shipmentDestinationFacilityId;
    }

    public void setShipmentDestinationFacilityId(String shipmentDestinationFacilityId)
    {
        this.shipmentDestinationFacilityId = shipmentDestinationFacilityId;
    }

    /**
     * Shipment Origin Contact Mech Id
     */
    private String shipmentOriginContactMechId;

    public String getShipmentOriginContactMechId()
    {
        return this.shipmentOriginContactMechId;
    }

    public void setShipmentOriginContactMechId(String shipmentOriginContactMechId)
    {
        this.shipmentOriginContactMechId = shipmentOriginContactMechId;
    }

    /**
     * Shipment Origin Telecom Number Id
     */
    private String shipmentOriginTelecomNumberId;

    public String getShipmentOriginTelecomNumberId()
    {
        return this.shipmentOriginTelecomNumberId;
    }

    public void setShipmentOriginTelecomNumberId(String shipmentOriginTelecomNumberId)
    {
        this.shipmentOriginTelecomNumberId = shipmentOriginTelecomNumberId;
    }

    /**
     * Shipment Destination Contact Mech Id
     */
    private String shipmentDestinationContactMechId;

    public String getShipmentDestinationContactMechId()
    {
        return this.shipmentDestinationContactMechId;
    }

    public void setShipmentDestinationContactMechId(String shipmentDestinationContactMechId)
    {
        this.shipmentDestinationContactMechId = shipmentDestinationContactMechId;
    }

    /**
     * Shipment Destination Telecom Number Id
     */
    private String shipmentDestinationTelecomNumberId;

    public String getShipmentDestinationTelecomNumberId()
    {
        return this.shipmentDestinationTelecomNumberId;
    }

    public void setShipmentDestinationTelecomNumberId(String shipmentDestinationTelecomNumberId)
    {
        this.shipmentDestinationTelecomNumberId = shipmentDestinationTelecomNumberId;
    }

    /**
     * Shipment Party Id To
     */
    private String shipmentPartyIdTo;

    public String getShipmentPartyIdTo()
    {
        return this.shipmentPartyIdTo;
    }

    public void setShipmentPartyIdTo(String shipmentPartyIdTo)
    {
        this.shipmentPartyIdTo = shipmentPartyIdTo;
    }

    /**
     * Shipment Party Id From
     */
    private String shipmentPartyIdFrom;

    public String getShipmentPartyIdFrom()
    {
        return this.shipmentPartyIdFrom;
    }

    public void setShipmentPartyIdFrom(String shipmentPartyIdFrom)
    {
        this.shipmentPartyIdFrom = shipmentPartyIdFrom;
    }

    /**
     * Shipment Additional Shipping Charge
     */
    private java.math.BigDecimal shipmentAdditionalShippingCharge;

    public java.math.BigDecimal getShipmentAdditionalShippingCharge()
    {
        return this.shipmentAdditionalShippingCharge;
    }

    public void setShipmentAdditionalShippingCharge(java.math.BigDecimal shipmentAdditionalShippingCharge)
    {
        this.shipmentAdditionalShippingCharge = shipmentAdditionalShippingCharge;
    }

    /**
     * Shipment Addtl Shipping Charge Desc
     */
    private String shipmentAddtlShippingChargeDesc;

    public String getShipmentAddtlShippingChargeDesc()
    {
        return this.shipmentAddtlShippingChargeDesc;
    }

    public void setShipmentAddtlShippingChargeDesc(String shipmentAddtlShippingChargeDesc)
    {
        this.shipmentAddtlShippingChargeDesc = shipmentAddtlShippingChargeDesc;
    }

    /**
     * Shipment Created By
     */
    private String shipmentCreatedBy;

    public String getShipmentCreatedBy()
    {
        return this.shipmentCreatedBy;
    }

    public void setShipmentCreatedBy(String shipmentCreatedBy)
    {
        this.shipmentCreatedBy = shipmentCreatedBy;
    }

    /**
     * Shipment Created At
     */
    private Date shipmentCreatedAt;

    public Date getShipmentCreatedAt()
    {
        return this.shipmentCreatedAt;
    }

    public void setShipmentCreatedAt(Date shipmentCreatedAt)
    {
        this.shipmentCreatedAt = shipmentCreatedAt;
    }

    /**
     * Shipment Updated By
     */
    private String shipmentUpdatedBy;

    public String getShipmentUpdatedBy()
    {
        return this.shipmentUpdatedBy;
    }

    public void setShipmentUpdatedBy(String shipmentUpdatedBy)
    {
        this.shipmentUpdatedBy = shipmentUpdatedBy;
    }

    /**
     * Shipment Updated At
     */
    private Date shipmentUpdatedAt;

    public Date getShipmentUpdatedAt()
    {
        return this.shipmentUpdatedAt;
    }

    public void setShipmentUpdatedAt(Date shipmentUpdatedAt)
    {
        this.shipmentUpdatedAt = shipmentUpdatedAt;
    }

    /**
     * Shipment Active
     */
    private Boolean shipmentActive;

    public Boolean getShipmentActive()
    {
        return this.shipmentActive;
    }

    public void setShipmentActive(Boolean shipmentActive)
    {
        this.shipmentActive = shipmentActive;
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

    private Boolean isPropertyQuantityRemoved;

    public Boolean getIsPropertyQuantityRemoved()
    {
        return this.isPropertyQuantityRemoved;
    }

    public void setIsPropertyQuantityRemoved(Boolean removed)
    {
        this.isPropertyQuantityRemoved = removed;
    }

    private Boolean isPropertyShipmentContentDescriptionRemoved;

    public Boolean getIsPropertyShipmentContentDescriptionRemoved()
    {
        return this.isPropertyShipmentContentDescriptionRemoved;
    }

    public void setIsPropertyShipmentContentDescriptionRemoved(Boolean removed)
    {
        this.isPropertyShipmentContentDescriptionRemoved = removed;
    }

    private Boolean isPropertyVersionRemoved;

    public Boolean getIsPropertyVersionRemoved()
    {
        return this.isPropertyVersionRemoved;
    }

    public void setIsPropertyVersionRemoved(Boolean removed)
    {
        this.isPropertyVersionRemoved = removed;
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

    private Boolean isPropertyShipmentShipmentTypeIdRemoved;

    public Boolean getIsPropertyShipmentShipmentTypeIdRemoved()
    {
        return this.isPropertyShipmentShipmentTypeIdRemoved;
    }

    public void setIsPropertyShipmentShipmentTypeIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentShipmentTypeIdRemoved = removed;
    }

    private Boolean isPropertyShipmentStatusIdRemoved;

    public Boolean getIsPropertyShipmentStatusIdRemoved()
    {
        return this.isPropertyShipmentStatusIdRemoved;
    }

    public void setIsPropertyShipmentStatusIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentStatusIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPrimaryOrderIdRemoved;

    public Boolean getIsPropertyShipmentPrimaryOrderIdRemoved()
    {
        return this.isPropertyShipmentPrimaryOrderIdRemoved;
    }

    public void setIsPropertyShipmentPrimaryOrderIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentPrimaryOrderIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPrimaryReturnIdRemoved;

    public Boolean getIsPropertyShipmentPrimaryReturnIdRemoved()
    {
        return this.isPropertyShipmentPrimaryReturnIdRemoved;
    }

    public void setIsPropertyShipmentPrimaryReturnIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentPrimaryReturnIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPrimaryShipGroupSeqIdRemoved;

    public Boolean getIsPropertyShipmentPrimaryShipGroupSeqIdRemoved()
    {
        return this.isPropertyShipmentPrimaryShipGroupSeqIdRemoved;
    }

    public void setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentPrimaryShipGroupSeqIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPicklistBinIdRemoved;

    public Boolean getIsPropertyShipmentPicklistBinIdRemoved()
    {
        return this.isPropertyShipmentPicklistBinIdRemoved;
    }

    public void setIsPropertyShipmentPicklistBinIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentPicklistBinIdRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedReadyDateRemoved;

    public Boolean getIsPropertyShipmentEstimatedReadyDateRemoved()
    {
        return this.isPropertyShipmentEstimatedReadyDateRemoved;
    }

    public void setIsPropertyShipmentEstimatedReadyDateRemoved(Boolean removed)
    {
        this.isPropertyShipmentEstimatedReadyDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedShipDateRemoved;

    public Boolean getIsPropertyShipmentEstimatedShipDateRemoved()
    {
        return this.isPropertyShipmentEstimatedShipDateRemoved;
    }

    public void setIsPropertyShipmentEstimatedShipDateRemoved(Boolean removed)
    {
        this.isPropertyShipmentEstimatedShipDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedShipWorkEffIdRemoved;

    public Boolean getIsPropertyShipmentEstimatedShipWorkEffIdRemoved()
    {
        return this.isPropertyShipmentEstimatedShipWorkEffIdRemoved;
    }

    public void setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentEstimatedShipWorkEffIdRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedArrivalDateRemoved;

    public Boolean getIsPropertyShipmentEstimatedArrivalDateRemoved()
    {
        return this.isPropertyShipmentEstimatedArrivalDateRemoved;
    }

    public void setIsPropertyShipmentEstimatedArrivalDateRemoved(Boolean removed)
    {
        this.isPropertyShipmentEstimatedArrivalDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedArrivalWorkEffIdRemoved;

    public Boolean getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved()
    {
        return this.isPropertyShipmentEstimatedArrivalWorkEffIdRemoved;
    }

    public void setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentEstimatedArrivalWorkEffIdRemoved = removed;
    }

    private Boolean isPropertyShipmentLatestCancelDateRemoved;

    public Boolean getIsPropertyShipmentLatestCancelDateRemoved()
    {
        return this.isPropertyShipmentLatestCancelDateRemoved;
    }

    public void setIsPropertyShipmentLatestCancelDateRemoved(Boolean removed)
    {
        this.isPropertyShipmentLatestCancelDateRemoved = removed;
    }

    private Boolean isPropertyShipmentEstimatedShipCostRemoved;

    public Boolean getIsPropertyShipmentEstimatedShipCostRemoved()
    {
        return this.isPropertyShipmentEstimatedShipCostRemoved;
    }

    public void setIsPropertyShipmentEstimatedShipCostRemoved(Boolean removed)
    {
        this.isPropertyShipmentEstimatedShipCostRemoved = removed;
    }

    private Boolean isPropertyShipmentCurrencyUomIdRemoved;

    public Boolean getIsPropertyShipmentCurrencyUomIdRemoved()
    {
        return this.isPropertyShipmentCurrencyUomIdRemoved;
    }

    public void setIsPropertyShipmentCurrencyUomIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentCurrencyUomIdRemoved = removed;
    }

    private Boolean isPropertyShipmentHandlingInstructionsRemoved;

    public Boolean getIsPropertyShipmentHandlingInstructionsRemoved()
    {
        return this.isPropertyShipmentHandlingInstructionsRemoved;
    }

    public void setIsPropertyShipmentHandlingInstructionsRemoved(Boolean removed)
    {
        this.isPropertyShipmentHandlingInstructionsRemoved = removed;
    }

    private Boolean isPropertyShipmentOriginFacilityIdRemoved;

    public Boolean getIsPropertyShipmentOriginFacilityIdRemoved()
    {
        return this.isPropertyShipmentOriginFacilityIdRemoved;
    }

    public void setIsPropertyShipmentOriginFacilityIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentOriginFacilityIdRemoved = removed;
    }

    private Boolean isPropertyShipmentDestinationFacilityIdRemoved;

    public Boolean getIsPropertyShipmentDestinationFacilityIdRemoved()
    {
        return this.isPropertyShipmentDestinationFacilityIdRemoved;
    }

    public void setIsPropertyShipmentDestinationFacilityIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentDestinationFacilityIdRemoved = removed;
    }

    private Boolean isPropertyShipmentOriginContactMechIdRemoved;

    public Boolean getIsPropertyShipmentOriginContactMechIdRemoved()
    {
        return this.isPropertyShipmentOriginContactMechIdRemoved;
    }

    public void setIsPropertyShipmentOriginContactMechIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentOriginContactMechIdRemoved = removed;
    }

    private Boolean isPropertyShipmentOriginTelecomNumberIdRemoved;

    public Boolean getIsPropertyShipmentOriginTelecomNumberIdRemoved()
    {
        return this.isPropertyShipmentOriginTelecomNumberIdRemoved;
    }

    public void setIsPropertyShipmentOriginTelecomNumberIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentOriginTelecomNumberIdRemoved = removed;
    }

    private Boolean isPropertyShipmentDestinationContactMechIdRemoved;

    public Boolean getIsPropertyShipmentDestinationContactMechIdRemoved()
    {
        return this.isPropertyShipmentDestinationContactMechIdRemoved;
    }

    public void setIsPropertyShipmentDestinationContactMechIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentDestinationContactMechIdRemoved = removed;
    }

    private Boolean isPropertyShipmentDestinationTelecomNumberIdRemoved;

    public Boolean getIsPropertyShipmentDestinationTelecomNumberIdRemoved()
    {
        return this.isPropertyShipmentDestinationTelecomNumberIdRemoved;
    }

    public void setIsPropertyShipmentDestinationTelecomNumberIdRemoved(Boolean removed)
    {
        this.isPropertyShipmentDestinationTelecomNumberIdRemoved = removed;
    }

    private Boolean isPropertyShipmentPartyIdToRemoved;

    public Boolean getIsPropertyShipmentPartyIdToRemoved()
    {
        return this.isPropertyShipmentPartyIdToRemoved;
    }

    public void setIsPropertyShipmentPartyIdToRemoved(Boolean removed)
    {
        this.isPropertyShipmentPartyIdToRemoved = removed;
    }

    private Boolean isPropertyShipmentPartyIdFromRemoved;

    public Boolean getIsPropertyShipmentPartyIdFromRemoved()
    {
        return this.isPropertyShipmentPartyIdFromRemoved;
    }

    public void setIsPropertyShipmentPartyIdFromRemoved(Boolean removed)
    {
        this.isPropertyShipmentPartyIdFromRemoved = removed;
    }

    private Boolean isPropertyShipmentAdditionalShippingChargeRemoved;

    public Boolean getIsPropertyShipmentAdditionalShippingChargeRemoved()
    {
        return this.isPropertyShipmentAdditionalShippingChargeRemoved;
    }

    public void setIsPropertyShipmentAdditionalShippingChargeRemoved(Boolean removed)
    {
        this.isPropertyShipmentAdditionalShippingChargeRemoved = removed;
    }

    private Boolean isPropertyShipmentAddtlShippingChargeDescRemoved;

    public Boolean getIsPropertyShipmentAddtlShippingChargeDescRemoved()
    {
        return this.isPropertyShipmentAddtlShippingChargeDescRemoved;
    }

    public void setIsPropertyShipmentAddtlShippingChargeDescRemoved(Boolean removed)
    {
        this.isPropertyShipmentAddtlShippingChargeDescRemoved = removed;
    }

    private Boolean isPropertyShipmentCreatedByRemoved;

    public Boolean getIsPropertyShipmentCreatedByRemoved()
    {
        return this.isPropertyShipmentCreatedByRemoved;
    }

    public void setIsPropertyShipmentCreatedByRemoved(Boolean removed)
    {
        this.isPropertyShipmentCreatedByRemoved = removed;
    }

    private Boolean isPropertyShipmentCreatedAtRemoved;

    public Boolean getIsPropertyShipmentCreatedAtRemoved()
    {
        return this.isPropertyShipmentCreatedAtRemoved;
    }

    public void setIsPropertyShipmentCreatedAtRemoved(Boolean removed)
    {
        this.isPropertyShipmentCreatedAtRemoved = removed;
    }

    private Boolean isPropertyShipmentUpdatedByRemoved;

    public Boolean getIsPropertyShipmentUpdatedByRemoved()
    {
        return this.isPropertyShipmentUpdatedByRemoved;
    }

    public void setIsPropertyShipmentUpdatedByRemoved(Boolean removed)
    {
        this.isPropertyShipmentUpdatedByRemoved = removed;
    }

    private Boolean isPropertyShipmentUpdatedAtRemoved;

    public Boolean getIsPropertyShipmentUpdatedAtRemoved()
    {
        return this.isPropertyShipmentUpdatedAtRemoved;
    }

    public void setIsPropertyShipmentUpdatedAtRemoved(Boolean removed)
    {
        this.isPropertyShipmentUpdatedAtRemoved = removed;
    }

    private Boolean isPropertyShipmentActiveRemoved;

    public Boolean getIsPropertyShipmentActiveRemoved()
    {
        return this.isPropertyShipmentActiveRemoved;
    }

    public void setIsPropertyShipmentActiveRemoved(Boolean removed)
    {
        this.isPropertyShipmentActiveRemoved = removed;
    }

    public void copyTo(AbstractShipmentItemMvoCommand.AbstractCreateOrMergePatchShipmentItemMvo command)
    {
        ((AbstractShipmentItemMvoCommandDto) this).copyTo(command);
        command.setProductId(this.getProductId());
        command.setAttributeSetInstanceId(this.getAttributeSetInstanceId());
        command.setQuantity(this.getQuantity());
        command.setShipmentContentDescription(this.getShipmentContentDescription());
        command.setVersion(this.getVersion());
        command.setActive(this.getActive());
        command.setShipmentShipmentTypeId(this.getShipmentShipmentTypeId());
        command.setShipmentStatusId(this.getShipmentStatusId());
        command.setShipmentPrimaryOrderId(this.getShipmentPrimaryOrderId());
        command.setShipmentPrimaryReturnId(this.getShipmentPrimaryReturnId());
        command.setShipmentPrimaryShipGroupSeqId(this.getShipmentPrimaryShipGroupSeqId());
        command.setShipmentPicklistBinId(this.getShipmentPicklistBinId());
        command.setShipmentEstimatedReadyDate(this.getShipmentEstimatedReadyDate());
        command.setShipmentEstimatedShipDate(this.getShipmentEstimatedShipDate());
        command.setShipmentEstimatedShipWorkEffId(this.getShipmentEstimatedShipWorkEffId());
        command.setShipmentEstimatedArrivalDate(this.getShipmentEstimatedArrivalDate());
        command.setShipmentEstimatedArrivalWorkEffId(this.getShipmentEstimatedArrivalWorkEffId());
        command.setShipmentLatestCancelDate(this.getShipmentLatestCancelDate());
        command.setShipmentEstimatedShipCost(this.getShipmentEstimatedShipCost());
        command.setShipmentCurrencyUomId(this.getShipmentCurrencyUomId());
        command.setShipmentHandlingInstructions(this.getShipmentHandlingInstructions());
        command.setShipmentOriginFacilityId(this.getShipmentOriginFacilityId());
        command.setShipmentDestinationFacilityId(this.getShipmentDestinationFacilityId());
        command.setShipmentOriginContactMechId(this.getShipmentOriginContactMechId());
        command.setShipmentOriginTelecomNumberId(this.getShipmentOriginTelecomNumberId());
        command.setShipmentDestinationContactMechId(this.getShipmentDestinationContactMechId());
        command.setShipmentDestinationTelecomNumberId(this.getShipmentDestinationTelecomNumberId());
        command.setShipmentPartyIdTo(this.getShipmentPartyIdTo());
        command.setShipmentPartyIdFrom(this.getShipmentPartyIdFrom());
        command.setShipmentAdditionalShippingCharge(this.getShipmentAdditionalShippingCharge());
        command.setShipmentAddtlShippingChargeDesc(this.getShipmentAddtlShippingChargeDesc());
        command.setShipmentCreatedBy(this.getShipmentCreatedBy());
        command.setShipmentCreatedAt(this.getShipmentCreatedAt());
        command.setShipmentUpdatedBy(this.getShipmentUpdatedBy());
        command.setShipmentUpdatedAt(this.getShipmentUpdatedAt());
        command.setShipmentActive(this.getShipmentActive());
    }

    public ShipmentItemMvoCommand toCommand()
    {
        if (getCommandType() == null) {
            setCommandType(COMMAND_TYPE_MERGE_PATCH);
        }
        if (COMMAND_TYPE_CREATE.equals(getCommandType())) {
            AbstractShipmentItemMvoCommand.SimpleCreateShipmentItemMvo command = new AbstractShipmentItemMvoCommand.SimpleCreateShipmentItemMvo();
            copyTo((AbstractShipmentItemMvoCommand.AbstractCreateShipmentItemMvo) command);
            return command;
        } else if (COMMAND_TYPE_MERGE_PATCH.equals(getCommandType())) {
            AbstractShipmentItemMvoCommand.SimpleMergePatchShipmentItemMvo command = new AbstractShipmentItemMvoCommand.SimpleMergePatchShipmentItemMvo();
            copyTo((AbstractShipmentItemMvoCommand.SimpleMergePatchShipmentItemMvo) command);
            return command;
        } 
        throw new IllegalStateException("Unknown command type:" + getCommandType());
    }

    public void copyTo(AbstractShipmentItemMvoCommand.AbstractCreateShipmentItemMvo command)
    {
        copyTo((AbstractShipmentItemMvoCommand.AbstractCreateOrMergePatchShipmentItemMvo) command);
    }

    public void copyTo(AbstractShipmentItemMvoCommand.AbstractMergePatchShipmentItemMvo command)
    {
        copyTo((AbstractShipmentItemMvoCommand.AbstractCreateOrMergePatchShipmentItemMvo) command);
        command.setIsPropertyProductIdRemoved(this.getIsPropertyProductIdRemoved());
        command.setIsPropertyAttributeSetInstanceIdRemoved(this.getIsPropertyAttributeSetInstanceIdRemoved());
        command.setIsPropertyQuantityRemoved(this.getIsPropertyQuantityRemoved());
        command.setIsPropertyShipmentContentDescriptionRemoved(this.getIsPropertyShipmentContentDescriptionRemoved());
        command.setIsPropertyVersionRemoved(this.getIsPropertyVersionRemoved());
        command.setIsPropertyActiveRemoved(this.getIsPropertyActiveRemoved());
        command.setIsPropertyShipmentShipmentTypeIdRemoved(this.getIsPropertyShipmentShipmentTypeIdRemoved());
        command.setIsPropertyShipmentStatusIdRemoved(this.getIsPropertyShipmentStatusIdRemoved());
        command.setIsPropertyShipmentPrimaryOrderIdRemoved(this.getIsPropertyShipmentPrimaryOrderIdRemoved());
        command.setIsPropertyShipmentPrimaryReturnIdRemoved(this.getIsPropertyShipmentPrimaryReturnIdRemoved());
        command.setIsPropertyShipmentPrimaryShipGroupSeqIdRemoved(this.getIsPropertyShipmentPrimaryShipGroupSeqIdRemoved());
        command.setIsPropertyShipmentPicklistBinIdRemoved(this.getIsPropertyShipmentPicklistBinIdRemoved());
        command.setIsPropertyShipmentEstimatedReadyDateRemoved(this.getIsPropertyShipmentEstimatedReadyDateRemoved());
        command.setIsPropertyShipmentEstimatedShipDateRemoved(this.getIsPropertyShipmentEstimatedShipDateRemoved());
        command.setIsPropertyShipmentEstimatedShipWorkEffIdRemoved(this.getIsPropertyShipmentEstimatedShipWorkEffIdRemoved());
        command.setIsPropertyShipmentEstimatedArrivalDateRemoved(this.getIsPropertyShipmentEstimatedArrivalDateRemoved());
        command.setIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved(this.getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved());
        command.setIsPropertyShipmentLatestCancelDateRemoved(this.getIsPropertyShipmentLatestCancelDateRemoved());
        command.setIsPropertyShipmentEstimatedShipCostRemoved(this.getIsPropertyShipmentEstimatedShipCostRemoved());
        command.setIsPropertyShipmentCurrencyUomIdRemoved(this.getIsPropertyShipmentCurrencyUomIdRemoved());
        command.setIsPropertyShipmentHandlingInstructionsRemoved(this.getIsPropertyShipmentHandlingInstructionsRemoved());
        command.setIsPropertyShipmentOriginFacilityIdRemoved(this.getIsPropertyShipmentOriginFacilityIdRemoved());
        command.setIsPropertyShipmentDestinationFacilityIdRemoved(this.getIsPropertyShipmentDestinationFacilityIdRemoved());
        command.setIsPropertyShipmentOriginContactMechIdRemoved(this.getIsPropertyShipmentOriginContactMechIdRemoved());
        command.setIsPropertyShipmentOriginTelecomNumberIdRemoved(this.getIsPropertyShipmentOriginTelecomNumberIdRemoved());
        command.setIsPropertyShipmentDestinationContactMechIdRemoved(this.getIsPropertyShipmentDestinationContactMechIdRemoved());
        command.setIsPropertyShipmentDestinationTelecomNumberIdRemoved(this.getIsPropertyShipmentDestinationTelecomNumberIdRemoved());
        command.setIsPropertyShipmentPartyIdToRemoved(this.getIsPropertyShipmentPartyIdToRemoved());
        command.setIsPropertyShipmentPartyIdFromRemoved(this.getIsPropertyShipmentPartyIdFromRemoved());
        command.setIsPropertyShipmentAdditionalShippingChargeRemoved(this.getIsPropertyShipmentAdditionalShippingChargeRemoved());
        command.setIsPropertyShipmentAddtlShippingChargeDescRemoved(this.getIsPropertyShipmentAddtlShippingChargeDescRemoved());
        command.setIsPropertyShipmentCreatedByRemoved(this.getIsPropertyShipmentCreatedByRemoved());
        command.setIsPropertyShipmentCreatedAtRemoved(this.getIsPropertyShipmentCreatedAtRemoved());
        command.setIsPropertyShipmentUpdatedByRemoved(this.getIsPropertyShipmentUpdatedByRemoved());
        command.setIsPropertyShipmentUpdatedAtRemoved(this.getIsPropertyShipmentUpdatedAtRemoved());
        command.setIsPropertyShipmentActiveRemoved(this.getIsPropertyShipmentActiveRemoved());
    }

    public static class CreateShipmentItemMvoDto extends CreateOrMergePatchShipmentItemMvoDto
    {
        public CreateShipmentItemMvoDto() {
            this.commandType = COMMAND_TYPE_CREATE;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_CREATE;
        }
        public ShipmentItemMvoCommand.CreateShipmentItemMvo toCreateShipmentItemMvo()
        {
            return (ShipmentItemMvoCommand.CreateShipmentItemMvo) toCommand();
        }

    }

    public static class MergePatchShipmentItemMvoDto extends CreateOrMergePatchShipmentItemMvoDto
    {
        public MergePatchShipmentItemMvoDto() {
            this.commandType = COMMAND_TYPE_MERGE_PATCH;
        }

        @Override
        public String getCommandType() {
            return COMMAND_TYPE_MERGE_PATCH;
        }
        public ShipmentItemMvoCommand.MergePatchShipmentItemMvo toMergePatchShipmentItemMvo()
        {
            return (ShipmentItemMvoCommand.MergePatchShipmentItemMvo) toCommand();
        }

    }

}

