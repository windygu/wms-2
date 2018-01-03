package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class ShipmentItemMvoStateDto
{

    private ShipmentItemIdDto shipmentItemId;

    public ShipmentItemIdDto getShipmentItemId()
    {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemIdDto shipmentItemId)
    {
        this.shipmentItemId = shipmentItemId;
    }

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

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private java.math.BigDecimal targetQuantity;

    public java.math.BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(java.math.BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
    }

    private String shipmentContentDescription;

    public String getShipmentContentDescription()
    {
        return this.shipmentContentDescription;
    }

    public void setShipmentContentDescription(String shipmentContentDescription)
    {
        this.shipmentContentDescription = shipmentContentDescription;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
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

    private String shipmentShipmentTypeId;

    public String getShipmentShipmentTypeId()
    {
        return this.shipmentShipmentTypeId;
    }

    public void setShipmentShipmentTypeId(String shipmentShipmentTypeId)
    {
        this.shipmentShipmentTypeId = shipmentShipmentTypeId;
    }

    private String shipmentStatusId;

    public String getShipmentStatusId()
    {
        return this.shipmentStatusId;
    }

    public void setShipmentStatusId(String shipmentStatusId)
    {
        this.shipmentStatusId = shipmentStatusId;
    }

    private String shipmentPrimaryOrderId;

    public String getShipmentPrimaryOrderId()
    {
        return this.shipmentPrimaryOrderId;
    }

    public void setShipmentPrimaryOrderId(String shipmentPrimaryOrderId)
    {
        this.shipmentPrimaryOrderId = shipmentPrimaryOrderId;
    }

    private String shipmentPrimaryReturnId;

    public String getShipmentPrimaryReturnId()
    {
        return this.shipmentPrimaryReturnId;
    }

    public void setShipmentPrimaryReturnId(String shipmentPrimaryReturnId)
    {
        this.shipmentPrimaryReturnId = shipmentPrimaryReturnId;
    }

    private String shipmentPicklistBinId;

    public String getShipmentPicklistBinId()
    {
        return this.shipmentPicklistBinId;
    }

    public void setShipmentPicklistBinId(String shipmentPicklistBinId)
    {
        this.shipmentPicklistBinId = shipmentPicklistBinId;
    }

    private java.sql.Timestamp shipmentEstimatedReadyDate;

    public java.sql.Timestamp getShipmentEstimatedReadyDate()
    {
        return this.shipmentEstimatedReadyDate;
    }

    public void setShipmentEstimatedReadyDate(java.sql.Timestamp shipmentEstimatedReadyDate)
    {
        this.shipmentEstimatedReadyDate = shipmentEstimatedReadyDate;
    }

    private java.sql.Timestamp shipmentEstimatedShipDate;

    public java.sql.Timestamp getShipmentEstimatedShipDate()
    {
        return this.shipmentEstimatedShipDate;
    }

    public void setShipmentEstimatedShipDate(java.sql.Timestamp shipmentEstimatedShipDate)
    {
        this.shipmentEstimatedShipDate = shipmentEstimatedShipDate;
    }

    private String shipmentEstimatedShipWorkEffId;

    public String getShipmentEstimatedShipWorkEffId()
    {
        return this.shipmentEstimatedShipWorkEffId;
    }

    public void setShipmentEstimatedShipWorkEffId(String shipmentEstimatedShipWorkEffId)
    {
        this.shipmentEstimatedShipWorkEffId = shipmentEstimatedShipWorkEffId;
    }

    private java.sql.Timestamp shipmentEstimatedArrivalDate;

    public java.sql.Timestamp getShipmentEstimatedArrivalDate()
    {
        return this.shipmentEstimatedArrivalDate;
    }

    public void setShipmentEstimatedArrivalDate(java.sql.Timestamp shipmentEstimatedArrivalDate)
    {
        this.shipmentEstimatedArrivalDate = shipmentEstimatedArrivalDate;
    }

    private String shipmentEstimatedArrivalWorkEffId;

    public String getShipmentEstimatedArrivalWorkEffId()
    {
        return this.shipmentEstimatedArrivalWorkEffId;
    }

    public void setShipmentEstimatedArrivalWorkEffId(String shipmentEstimatedArrivalWorkEffId)
    {
        this.shipmentEstimatedArrivalWorkEffId = shipmentEstimatedArrivalWorkEffId;
    }

    private java.sql.Timestamp shipmentLatestCancelDate;

    public java.sql.Timestamp getShipmentLatestCancelDate()
    {
        return this.shipmentLatestCancelDate;
    }

    public void setShipmentLatestCancelDate(java.sql.Timestamp shipmentLatestCancelDate)
    {
        this.shipmentLatestCancelDate = shipmentLatestCancelDate;
    }

    private java.math.BigDecimal shipmentEstimatedShipCost;

    public java.math.BigDecimal getShipmentEstimatedShipCost()
    {
        return this.shipmentEstimatedShipCost;
    }

    public void setShipmentEstimatedShipCost(java.math.BigDecimal shipmentEstimatedShipCost)
    {
        this.shipmentEstimatedShipCost = shipmentEstimatedShipCost;
    }

    private String shipmentCurrencyUomId;

    public String getShipmentCurrencyUomId()
    {
        return this.shipmentCurrencyUomId;
    }

    public void setShipmentCurrencyUomId(String shipmentCurrencyUomId)
    {
        this.shipmentCurrencyUomId = shipmentCurrencyUomId;
    }

    private String shipmentHandlingInstructions;

    public String getShipmentHandlingInstructions()
    {
        return this.shipmentHandlingInstructions;
    }

    public void setShipmentHandlingInstructions(String shipmentHandlingInstructions)
    {
        this.shipmentHandlingInstructions = shipmentHandlingInstructions;
    }

    private String shipmentOriginFacilityId;

    public String getShipmentOriginFacilityId()
    {
        return this.shipmentOriginFacilityId;
    }

    public void setShipmentOriginFacilityId(String shipmentOriginFacilityId)
    {
        this.shipmentOriginFacilityId = shipmentOriginFacilityId;
    }

    private String shipmentDestinationFacilityId;

    public String getShipmentDestinationFacilityId()
    {
        return this.shipmentDestinationFacilityId;
    }

    public void setShipmentDestinationFacilityId(String shipmentDestinationFacilityId)
    {
        this.shipmentDestinationFacilityId = shipmentDestinationFacilityId;
    }

    private String shipmentOriginContactMechId;

    public String getShipmentOriginContactMechId()
    {
        return this.shipmentOriginContactMechId;
    }

    public void setShipmentOriginContactMechId(String shipmentOriginContactMechId)
    {
        this.shipmentOriginContactMechId = shipmentOriginContactMechId;
    }

    private String shipmentOriginTelecomNumberId;

    public String getShipmentOriginTelecomNumberId()
    {
        return this.shipmentOriginTelecomNumberId;
    }

    public void setShipmentOriginTelecomNumberId(String shipmentOriginTelecomNumberId)
    {
        this.shipmentOriginTelecomNumberId = shipmentOriginTelecomNumberId;
    }

    private String shipmentDestinationContactMechId;

    public String getShipmentDestinationContactMechId()
    {
        return this.shipmentDestinationContactMechId;
    }

    public void setShipmentDestinationContactMechId(String shipmentDestinationContactMechId)
    {
        this.shipmentDestinationContactMechId = shipmentDestinationContactMechId;
    }

    private String shipmentDestinationTelecomNumberId;

    public String getShipmentDestinationTelecomNumberId()
    {
        return this.shipmentDestinationTelecomNumberId;
    }

    public void setShipmentDestinationTelecomNumberId(String shipmentDestinationTelecomNumberId)
    {
        this.shipmentDestinationTelecomNumberId = shipmentDestinationTelecomNumberId;
    }

    private String shipmentPartyIdTo;

    public String getShipmentPartyIdTo()
    {
        return this.shipmentPartyIdTo;
    }

    public void setShipmentPartyIdTo(String shipmentPartyIdTo)
    {
        this.shipmentPartyIdTo = shipmentPartyIdTo;
    }

    private String shipmentPartyIdFrom;

    public String getShipmentPartyIdFrom()
    {
        return this.shipmentPartyIdFrom;
    }

    public void setShipmentPartyIdFrom(String shipmentPartyIdFrom)
    {
        this.shipmentPartyIdFrom = shipmentPartyIdFrom;
    }

    private java.math.BigDecimal shipmentAdditionalShippingCharge;

    public java.math.BigDecimal getShipmentAdditionalShippingCharge()
    {
        return this.shipmentAdditionalShippingCharge;
    }

    public void setShipmentAdditionalShippingCharge(java.math.BigDecimal shipmentAdditionalShippingCharge)
    {
        this.shipmentAdditionalShippingCharge = shipmentAdditionalShippingCharge;
    }

    private String shipmentAddtlShippingChargeDesc;

    public String getShipmentAddtlShippingChargeDesc()
    {
        return this.shipmentAddtlShippingChargeDesc;
    }

    public void setShipmentAddtlShippingChargeDesc(String shipmentAddtlShippingChargeDesc)
    {
        this.shipmentAddtlShippingChargeDesc = shipmentAddtlShippingChargeDesc;
    }

    private String shipmentShipperId;

    public String getShipmentShipperId()
    {
        return this.shipmentShipperId;
    }

    public void setShipmentShipperId(String shipmentShipperId)
    {
        this.shipmentShipperId = shipmentShipperId;
    }

    private String shipmentCreatedBy;

    public String getShipmentCreatedBy()
    {
        return this.shipmentCreatedBy;
    }

    public void setShipmentCreatedBy(String shipmentCreatedBy)
    {
        this.shipmentCreatedBy = shipmentCreatedBy;
    }

    private Date shipmentCreatedAt;

    public Date getShipmentCreatedAt()
    {
        return this.shipmentCreatedAt;
    }

    public void setShipmentCreatedAt(Date shipmentCreatedAt)
    {
        this.shipmentCreatedAt = shipmentCreatedAt;
    }

    private String shipmentUpdatedBy;

    public String getShipmentUpdatedBy()
    {
        return this.shipmentUpdatedBy;
    }

    public void setShipmentUpdatedBy(String shipmentUpdatedBy)
    {
        this.shipmentUpdatedBy = shipmentUpdatedBy;
    }

    private Date shipmentUpdatedAt;

    public Date getShipmentUpdatedAt()
    {
        return this.shipmentUpdatedAt;
    }

    public void setShipmentUpdatedAt(Date shipmentUpdatedAt)
    {
        this.shipmentUpdatedAt = shipmentUpdatedAt;
    }

    private Boolean shipmentActive;

    public Boolean getShipmentActive()
    {
        return this.shipmentActive;
    }

    public void setShipmentActive(Boolean shipmentActive)
    {
        this.shipmentActive = shipmentActive;
    }

    private Long shipmentVersion;

    public Long getShipmentVersion()
    {
        return this.shipmentVersion;
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.shipmentVersion = shipmentVersion;
    }

    private String createdBy;

    public String getCreatedBy()
    {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy()
    {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public ShipmentItemMvoStateDto[] toShipmentItemMvoStateDtoArray(Iterable<ShipmentItemMvoState> states) 
        {
            ArrayList<ShipmentItemMvoStateDto> stateDtos = new ArrayList();
            for (ShipmentItemMvoState s : states) {
                ShipmentItemMvoStateDto dto = toShipmentItemMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new ShipmentItemMvoStateDto[0]);
        }

        public ShipmentItemMvoStateDto toShipmentItemMvoStateDto(ShipmentItemMvoState state)
        {
            if(state == null) {
                return null;
            }
            ShipmentItemMvoStateDto dto = new ShipmentItemMvoStateDto();
            if (returnedFieldsContains("ShipmentItemId")) {
                dto.setShipmentItemId((state.getShipmentItemId() == null) ? null : new ShipmentItemIdDtoWrapper(state.getShipmentItemId()));
            }
            if (returnedFieldsContains("ProductId")) {
                dto.setProductId(state.getProductId());
            }
            if (returnedFieldsContains("AttributeSetInstanceId")) {
                dto.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("TargetQuantity")) {
                dto.setTargetQuantity(state.getTargetQuantity());
            }
            if (returnedFieldsContains("ShipmentContentDescription")) {
                dto.setShipmentContentDescription(state.getShipmentContentDescription());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("ShipmentShipmentTypeId")) {
                dto.setShipmentShipmentTypeId(state.getShipmentShipmentTypeId());
            }
            if (returnedFieldsContains("ShipmentStatusId")) {
                dto.setShipmentStatusId(state.getShipmentStatusId());
            }
            if (returnedFieldsContains("ShipmentPrimaryOrderId")) {
                dto.setShipmentPrimaryOrderId(state.getShipmentPrimaryOrderId());
            }
            if (returnedFieldsContains("ShipmentPrimaryReturnId")) {
                dto.setShipmentPrimaryReturnId(state.getShipmentPrimaryReturnId());
            }
            if (returnedFieldsContains("ShipmentPicklistBinId")) {
                dto.setShipmentPicklistBinId(state.getShipmentPicklistBinId());
            }
            if (returnedFieldsContains("ShipmentEstimatedReadyDate")) {
                dto.setShipmentEstimatedReadyDate(state.getShipmentEstimatedReadyDate());
            }
            if (returnedFieldsContains("ShipmentEstimatedShipDate")) {
                dto.setShipmentEstimatedShipDate(state.getShipmentEstimatedShipDate());
            }
            if (returnedFieldsContains("ShipmentEstimatedShipWorkEffId")) {
                dto.setShipmentEstimatedShipWorkEffId(state.getShipmentEstimatedShipWorkEffId());
            }
            if (returnedFieldsContains("ShipmentEstimatedArrivalDate")) {
                dto.setShipmentEstimatedArrivalDate(state.getShipmentEstimatedArrivalDate());
            }
            if (returnedFieldsContains("ShipmentEstimatedArrivalWorkEffId")) {
                dto.setShipmentEstimatedArrivalWorkEffId(state.getShipmentEstimatedArrivalWorkEffId());
            }
            if (returnedFieldsContains("ShipmentLatestCancelDate")) {
                dto.setShipmentLatestCancelDate(state.getShipmentLatestCancelDate());
            }
            if (returnedFieldsContains("ShipmentEstimatedShipCost")) {
                dto.setShipmentEstimatedShipCost(state.getShipmentEstimatedShipCost());
            }
            if (returnedFieldsContains("ShipmentCurrencyUomId")) {
                dto.setShipmentCurrencyUomId(state.getShipmentCurrencyUomId());
            }
            if (returnedFieldsContains("ShipmentHandlingInstructions")) {
                dto.setShipmentHandlingInstructions(state.getShipmentHandlingInstructions());
            }
            if (returnedFieldsContains("ShipmentOriginFacilityId")) {
                dto.setShipmentOriginFacilityId(state.getShipmentOriginFacilityId());
            }
            if (returnedFieldsContains("ShipmentDestinationFacilityId")) {
                dto.setShipmentDestinationFacilityId(state.getShipmentDestinationFacilityId());
            }
            if (returnedFieldsContains("ShipmentOriginContactMechId")) {
                dto.setShipmentOriginContactMechId(state.getShipmentOriginContactMechId());
            }
            if (returnedFieldsContains("ShipmentOriginTelecomNumberId")) {
                dto.setShipmentOriginTelecomNumberId(state.getShipmentOriginTelecomNumberId());
            }
            if (returnedFieldsContains("ShipmentDestinationContactMechId")) {
                dto.setShipmentDestinationContactMechId(state.getShipmentDestinationContactMechId());
            }
            if (returnedFieldsContains("ShipmentDestinationTelecomNumberId")) {
                dto.setShipmentDestinationTelecomNumberId(state.getShipmentDestinationTelecomNumberId());
            }
            if (returnedFieldsContains("ShipmentPartyIdTo")) {
                dto.setShipmentPartyIdTo(state.getShipmentPartyIdTo());
            }
            if (returnedFieldsContains("ShipmentPartyIdFrom")) {
                dto.setShipmentPartyIdFrom(state.getShipmentPartyIdFrom());
            }
            if (returnedFieldsContains("ShipmentAdditionalShippingCharge")) {
                dto.setShipmentAdditionalShippingCharge(state.getShipmentAdditionalShippingCharge());
            }
            if (returnedFieldsContains("ShipmentAddtlShippingChargeDesc")) {
                dto.setShipmentAddtlShippingChargeDesc(state.getShipmentAddtlShippingChargeDesc());
            }
            if (returnedFieldsContains("ShipmentShipperId")) {
                dto.setShipmentShipperId(state.getShipmentShipperId());
            }
            if (returnedFieldsContains("ShipmentCreatedBy")) {
                dto.setShipmentCreatedBy(state.getShipmentCreatedBy());
            }
            if (returnedFieldsContains("ShipmentCreatedAt")) {
                dto.setShipmentCreatedAt(state.getShipmentCreatedAt());
            }
            if (returnedFieldsContains("ShipmentUpdatedBy")) {
                dto.setShipmentUpdatedBy(state.getShipmentUpdatedBy());
            }
            if (returnedFieldsContains("ShipmentUpdatedAt")) {
                dto.setShipmentUpdatedAt(state.getShipmentUpdatedAt());
            }
            if (returnedFieldsContains("ShipmentActive")) {
                dto.setShipmentActive(state.getShipmentActive());
            }
            if (returnedFieldsContains("ShipmentVersion")) {
                dto.setShipmentVersion(state.getShipmentVersion());
            }
            if (returnedFieldsContains("CreatedBy")) {
                dto.setCreatedBy(state.getCreatedBy());
            }
            if (returnedFieldsContains("CreatedAt")) {
                dto.setCreatedAt(state.getCreatedAt());
            }
            if (returnedFieldsContains("UpdatedBy")) {
                dto.setUpdatedBy(state.getUpdatedBy());
            }
            if (returnedFieldsContains("UpdatedAt")) {
                dto.setUpdatedAt(state.getUpdatedAt());
            }
            return dto;
        }

    }
}

