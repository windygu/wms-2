package org.dddml.wms.domain.shipmentitemmvo;

import java.util.*;
import org.dddml.wms.domain.shipment.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentitemmvo.ShipmentItemMvoStateEvent.*;

public abstract class AbstractShipmentItemMvoState implements ShipmentItemMvoState
{

    private ShipmentItemId shipmentItemId;

    public ShipmentItemId getShipmentItemId()
    {
        return this.shipmentItemId;
    }

    public void setShipmentItemId(ShipmentItemId shipmentItemId)
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

    private Long shipmentVersion;

    public Long getShipmentVersion()
    {
        return this.shipmentVersion;
    }

    public void setShipmentVersion(Long shipmentVersion)
    {
        this.shipmentVersion = shipmentVersion;
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

    public boolean isStateUnsaved() 
    {
        return this.getShipmentVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractShipmentItemMvoState(List<Event> events) {
        this(true);
        if (events != null && events.size() > 0) {
            this.setShipmentItemId(((ShipmentItemMvoStateEvent) events.get(0)).getStateEventId().getShipmentItemId());
            for (Event e : events) {
                mutate(e);
                this.setShipmentVersion(this.getShipmentVersion() + 1);
            }
        }
    }


    public AbstractShipmentItemMvoState() {
        this(false);
    }

    public AbstractShipmentItemMvoState(boolean forReapplying) {
        this.forReapplying = forReapplying;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (e instanceof ShipmentItemMvoStateCreated) {
            when((ShipmentItemMvoStateCreated) e);
        } else if (e instanceof ShipmentItemMvoStateMergePatched) {
            when((ShipmentItemMvoStateMergePatched) e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void when(ShipmentItemMvoStateCreated e)
    {
        throwOnWrongEvent(e);

        this.setProductId(e.getProductId());
        this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        this.setQuantity(e.getQuantity());
        this.setShipmentContentDescription(e.getShipmentContentDescription());
        this.setVersion(e.getVersion());
        this.setActive(e.getActive());
        this.setShipmentShipmentTypeId(e.getShipmentShipmentTypeId());
        this.setShipmentStatusId(e.getShipmentStatusId());
        this.setShipmentPrimaryOrderId(e.getShipmentPrimaryOrderId());
        this.setShipmentPrimaryReturnId(e.getShipmentPrimaryReturnId());
        this.setShipmentPicklistBinId(e.getShipmentPicklistBinId());
        this.setShipmentEstimatedReadyDate(e.getShipmentEstimatedReadyDate());
        this.setShipmentEstimatedShipDate(e.getShipmentEstimatedShipDate());
        this.setShipmentEstimatedShipWorkEffId(e.getShipmentEstimatedShipWorkEffId());
        this.setShipmentEstimatedArrivalDate(e.getShipmentEstimatedArrivalDate());
        this.setShipmentEstimatedArrivalWorkEffId(e.getShipmentEstimatedArrivalWorkEffId());
        this.setShipmentLatestCancelDate(e.getShipmentLatestCancelDate());
        this.setShipmentEstimatedShipCost(e.getShipmentEstimatedShipCost());
        this.setShipmentCurrencyUomId(e.getShipmentCurrencyUomId());
        this.setShipmentHandlingInstructions(e.getShipmentHandlingInstructions());
        this.setShipmentOriginFacilityId(e.getShipmentOriginFacilityId());
        this.setShipmentDestinationFacilityId(e.getShipmentDestinationFacilityId());
        this.setShipmentOriginContactMechId(e.getShipmentOriginContactMechId());
        this.setShipmentOriginTelecomNumberId(e.getShipmentOriginTelecomNumberId());
        this.setShipmentDestinationContactMechId(e.getShipmentDestinationContactMechId());
        this.setShipmentDestinationTelecomNumberId(e.getShipmentDestinationTelecomNumberId());
        this.setShipmentPartyIdTo(e.getShipmentPartyIdTo());
        this.setShipmentPartyIdFrom(e.getShipmentPartyIdFrom());
        this.setShipmentAdditionalShippingCharge(e.getShipmentAdditionalShippingCharge());
        this.setShipmentAddtlShippingChargeDesc(e.getShipmentAddtlShippingChargeDesc());
        this.setShipmentCreatedBy(e.getShipmentCreatedBy());
        this.setShipmentCreatedAt(e.getShipmentCreatedAt());
        this.setShipmentUpdatedBy(e.getShipmentUpdatedBy());
        this.setShipmentUpdatedAt(e.getShipmentUpdatedAt());
        this.setShipmentActive(e.getShipmentActive());

        this.setCreatedBy(e.getCreatedBy());
        this.setCreatedAt(e.getCreatedAt());

    }

    public void when(ShipmentItemMvoStateMergePatched e)
    {
        throwOnWrongEvent(e);

        if (e.getProductId() == null)
        {
            if (e.getIsPropertyProductIdRemoved() != null && e.getIsPropertyProductIdRemoved())
            {
                this.setProductId(null);
            }
        }
        else
        {
            this.setProductId(e.getProductId());
        }
        if (e.getAttributeSetInstanceId() == null)
        {
            if (e.getIsPropertyAttributeSetInstanceIdRemoved() != null && e.getIsPropertyAttributeSetInstanceIdRemoved())
            {
                this.setAttributeSetInstanceId(null);
            }
        }
        else
        {
            this.setAttributeSetInstanceId(e.getAttributeSetInstanceId());
        }
        if (e.getQuantity() == null)
        {
            if (e.getIsPropertyQuantityRemoved() != null && e.getIsPropertyQuantityRemoved())
            {
                this.setQuantity(null);
            }
        }
        else
        {
            this.setQuantity(e.getQuantity());
        }
        if (e.getShipmentContentDescription() == null)
        {
            if (e.getIsPropertyShipmentContentDescriptionRemoved() != null && e.getIsPropertyShipmentContentDescriptionRemoved())
            {
                this.setShipmentContentDescription(null);
            }
        }
        else
        {
            this.setShipmentContentDescription(e.getShipmentContentDescription());
        }
        if (e.getVersion() == null)
        {
            if (e.getIsPropertyVersionRemoved() != null && e.getIsPropertyVersionRemoved())
            {
                this.setVersion(null);
            }
        }
        else
        {
            this.setVersion(e.getVersion());
        }
        if (e.getActive() == null)
        {
            if (e.getIsPropertyActiveRemoved() != null && e.getIsPropertyActiveRemoved())
            {
                this.setActive(null);
            }
        }
        else
        {
            this.setActive(e.getActive());
        }
        if (e.getShipmentShipmentTypeId() == null)
        {
            if (e.getIsPropertyShipmentShipmentTypeIdRemoved() != null && e.getIsPropertyShipmentShipmentTypeIdRemoved())
            {
                this.setShipmentShipmentTypeId(null);
            }
        }
        else
        {
            this.setShipmentShipmentTypeId(e.getShipmentShipmentTypeId());
        }
        if (e.getShipmentStatusId() == null)
        {
            if (e.getIsPropertyShipmentStatusIdRemoved() != null && e.getIsPropertyShipmentStatusIdRemoved())
            {
                this.setShipmentStatusId(null);
            }
        }
        else
        {
            this.setShipmentStatusId(e.getShipmentStatusId());
        }
        if (e.getShipmentPrimaryOrderId() == null)
        {
            if (e.getIsPropertyShipmentPrimaryOrderIdRemoved() != null && e.getIsPropertyShipmentPrimaryOrderIdRemoved())
            {
                this.setShipmentPrimaryOrderId(null);
            }
        }
        else
        {
            this.setShipmentPrimaryOrderId(e.getShipmentPrimaryOrderId());
        }
        if (e.getShipmentPrimaryReturnId() == null)
        {
            if (e.getIsPropertyShipmentPrimaryReturnIdRemoved() != null && e.getIsPropertyShipmentPrimaryReturnIdRemoved())
            {
                this.setShipmentPrimaryReturnId(null);
            }
        }
        else
        {
            this.setShipmentPrimaryReturnId(e.getShipmentPrimaryReturnId());
        }
        if (e.getShipmentPicklistBinId() == null)
        {
            if (e.getIsPropertyShipmentPicklistBinIdRemoved() != null && e.getIsPropertyShipmentPicklistBinIdRemoved())
            {
                this.setShipmentPicklistBinId(null);
            }
        }
        else
        {
            this.setShipmentPicklistBinId(e.getShipmentPicklistBinId());
        }
        if (e.getShipmentEstimatedReadyDate() == null)
        {
            if (e.getIsPropertyShipmentEstimatedReadyDateRemoved() != null && e.getIsPropertyShipmentEstimatedReadyDateRemoved())
            {
                this.setShipmentEstimatedReadyDate(null);
            }
        }
        else
        {
            this.setShipmentEstimatedReadyDate(e.getShipmentEstimatedReadyDate());
        }
        if (e.getShipmentEstimatedShipDate() == null)
        {
            if (e.getIsPropertyShipmentEstimatedShipDateRemoved() != null && e.getIsPropertyShipmentEstimatedShipDateRemoved())
            {
                this.setShipmentEstimatedShipDate(null);
            }
        }
        else
        {
            this.setShipmentEstimatedShipDate(e.getShipmentEstimatedShipDate());
        }
        if (e.getShipmentEstimatedShipWorkEffId() == null)
        {
            if (e.getIsPropertyShipmentEstimatedShipWorkEffIdRemoved() != null && e.getIsPropertyShipmentEstimatedShipWorkEffIdRemoved())
            {
                this.setShipmentEstimatedShipWorkEffId(null);
            }
        }
        else
        {
            this.setShipmentEstimatedShipWorkEffId(e.getShipmentEstimatedShipWorkEffId());
        }
        if (e.getShipmentEstimatedArrivalDate() == null)
        {
            if (e.getIsPropertyShipmentEstimatedArrivalDateRemoved() != null && e.getIsPropertyShipmentEstimatedArrivalDateRemoved())
            {
                this.setShipmentEstimatedArrivalDate(null);
            }
        }
        else
        {
            this.setShipmentEstimatedArrivalDate(e.getShipmentEstimatedArrivalDate());
        }
        if (e.getShipmentEstimatedArrivalWorkEffId() == null)
        {
            if (e.getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved() != null && e.getIsPropertyShipmentEstimatedArrivalWorkEffIdRemoved())
            {
                this.setShipmentEstimatedArrivalWorkEffId(null);
            }
        }
        else
        {
            this.setShipmentEstimatedArrivalWorkEffId(e.getShipmentEstimatedArrivalWorkEffId());
        }
        if (e.getShipmentLatestCancelDate() == null)
        {
            if (e.getIsPropertyShipmentLatestCancelDateRemoved() != null && e.getIsPropertyShipmentLatestCancelDateRemoved())
            {
                this.setShipmentLatestCancelDate(null);
            }
        }
        else
        {
            this.setShipmentLatestCancelDate(e.getShipmentLatestCancelDate());
        }
        if (e.getShipmentEstimatedShipCost() == null)
        {
            if (e.getIsPropertyShipmentEstimatedShipCostRemoved() != null && e.getIsPropertyShipmentEstimatedShipCostRemoved())
            {
                this.setShipmentEstimatedShipCost(null);
            }
        }
        else
        {
            this.setShipmentEstimatedShipCost(e.getShipmentEstimatedShipCost());
        }
        if (e.getShipmentCurrencyUomId() == null)
        {
            if (e.getIsPropertyShipmentCurrencyUomIdRemoved() != null && e.getIsPropertyShipmentCurrencyUomIdRemoved())
            {
                this.setShipmentCurrencyUomId(null);
            }
        }
        else
        {
            this.setShipmentCurrencyUomId(e.getShipmentCurrencyUomId());
        }
        if (e.getShipmentHandlingInstructions() == null)
        {
            if (e.getIsPropertyShipmentHandlingInstructionsRemoved() != null && e.getIsPropertyShipmentHandlingInstructionsRemoved())
            {
                this.setShipmentHandlingInstructions(null);
            }
        }
        else
        {
            this.setShipmentHandlingInstructions(e.getShipmentHandlingInstructions());
        }
        if (e.getShipmentOriginFacilityId() == null)
        {
            if (e.getIsPropertyShipmentOriginFacilityIdRemoved() != null && e.getIsPropertyShipmentOriginFacilityIdRemoved())
            {
                this.setShipmentOriginFacilityId(null);
            }
        }
        else
        {
            this.setShipmentOriginFacilityId(e.getShipmentOriginFacilityId());
        }
        if (e.getShipmentDestinationFacilityId() == null)
        {
            if (e.getIsPropertyShipmentDestinationFacilityIdRemoved() != null && e.getIsPropertyShipmentDestinationFacilityIdRemoved())
            {
                this.setShipmentDestinationFacilityId(null);
            }
        }
        else
        {
            this.setShipmentDestinationFacilityId(e.getShipmentDestinationFacilityId());
        }
        if (e.getShipmentOriginContactMechId() == null)
        {
            if (e.getIsPropertyShipmentOriginContactMechIdRemoved() != null && e.getIsPropertyShipmentOriginContactMechIdRemoved())
            {
                this.setShipmentOriginContactMechId(null);
            }
        }
        else
        {
            this.setShipmentOriginContactMechId(e.getShipmentOriginContactMechId());
        }
        if (e.getShipmentOriginTelecomNumberId() == null)
        {
            if (e.getIsPropertyShipmentOriginTelecomNumberIdRemoved() != null && e.getIsPropertyShipmentOriginTelecomNumberIdRemoved())
            {
                this.setShipmentOriginTelecomNumberId(null);
            }
        }
        else
        {
            this.setShipmentOriginTelecomNumberId(e.getShipmentOriginTelecomNumberId());
        }
        if (e.getShipmentDestinationContactMechId() == null)
        {
            if (e.getIsPropertyShipmentDestinationContactMechIdRemoved() != null && e.getIsPropertyShipmentDestinationContactMechIdRemoved())
            {
                this.setShipmentDestinationContactMechId(null);
            }
        }
        else
        {
            this.setShipmentDestinationContactMechId(e.getShipmentDestinationContactMechId());
        }
        if (e.getShipmentDestinationTelecomNumberId() == null)
        {
            if (e.getIsPropertyShipmentDestinationTelecomNumberIdRemoved() != null && e.getIsPropertyShipmentDestinationTelecomNumberIdRemoved())
            {
                this.setShipmentDestinationTelecomNumberId(null);
            }
        }
        else
        {
            this.setShipmentDestinationTelecomNumberId(e.getShipmentDestinationTelecomNumberId());
        }
        if (e.getShipmentPartyIdTo() == null)
        {
            if (e.getIsPropertyShipmentPartyIdToRemoved() != null && e.getIsPropertyShipmentPartyIdToRemoved())
            {
                this.setShipmentPartyIdTo(null);
            }
        }
        else
        {
            this.setShipmentPartyIdTo(e.getShipmentPartyIdTo());
        }
        if (e.getShipmentPartyIdFrom() == null)
        {
            if (e.getIsPropertyShipmentPartyIdFromRemoved() != null && e.getIsPropertyShipmentPartyIdFromRemoved())
            {
                this.setShipmentPartyIdFrom(null);
            }
        }
        else
        {
            this.setShipmentPartyIdFrom(e.getShipmentPartyIdFrom());
        }
        if (e.getShipmentAdditionalShippingCharge() == null)
        {
            if (e.getIsPropertyShipmentAdditionalShippingChargeRemoved() != null && e.getIsPropertyShipmentAdditionalShippingChargeRemoved())
            {
                this.setShipmentAdditionalShippingCharge(null);
            }
        }
        else
        {
            this.setShipmentAdditionalShippingCharge(e.getShipmentAdditionalShippingCharge());
        }
        if (e.getShipmentAddtlShippingChargeDesc() == null)
        {
            if (e.getIsPropertyShipmentAddtlShippingChargeDescRemoved() != null && e.getIsPropertyShipmentAddtlShippingChargeDescRemoved())
            {
                this.setShipmentAddtlShippingChargeDesc(null);
            }
        }
        else
        {
            this.setShipmentAddtlShippingChargeDesc(e.getShipmentAddtlShippingChargeDesc());
        }
        if (e.getShipmentCreatedBy() == null)
        {
            if (e.getIsPropertyShipmentCreatedByRemoved() != null && e.getIsPropertyShipmentCreatedByRemoved())
            {
                this.setShipmentCreatedBy(null);
            }
        }
        else
        {
            this.setShipmentCreatedBy(e.getShipmentCreatedBy());
        }
        if (e.getShipmentCreatedAt() == null)
        {
            if (e.getIsPropertyShipmentCreatedAtRemoved() != null && e.getIsPropertyShipmentCreatedAtRemoved())
            {
                this.setShipmentCreatedAt(null);
            }
        }
        else
        {
            this.setShipmentCreatedAt(e.getShipmentCreatedAt());
        }
        if (e.getShipmentUpdatedBy() == null)
        {
            if (e.getIsPropertyShipmentUpdatedByRemoved() != null && e.getIsPropertyShipmentUpdatedByRemoved())
            {
                this.setShipmentUpdatedBy(null);
            }
        }
        else
        {
            this.setShipmentUpdatedBy(e.getShipmentUpdatedBy());
        }
        if (e.getShipmentUpdatedAt() == null)
        {
            if (e.getIsPropertyShipmentUpdatedAtRemoved() != null && e.getIsPropertyShipmentUpdatedAtRemoved())
            {
                this.setShipmentUpdatedAt(null);
            }
        }
        else
        {
            this.setShipmentUpdatedAt(e.getShipmentUpdatedAt());
        }
        if (e.getShipmentActive() == null)
        {
            if (e.getIsPropertyShipmentActiveRemoved() != null && e.getIsPropertyShipmentActiveRemoved())
            {
                this.setShipmentActive(null);
            }
        }
        else
        {
            this.setShipmentActive(e.getShipmentActive());
        }

        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

    }

    public void save()
    {
    }

    protected void throwOnWrongEvent(ShipmentItemMvoStateEvent stateEvent)
    {
        ShipmentItemId stateEntityId = this.getShipmentItemId(); // Aggregate Id
        ShipmentItemId eventEntityId = stateEvent.getStateEventId().getShipmentItemId(); // EntityBase.Aggregate.GetStateEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId))
        {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }

        Long stateVersion = this.getShipmentVersion();
        Long eventVersion = stateEvent.getStateEventId().getShipmentVersion();// Aggregate Version
        if (eventVersion == null) {
            throw new NullPointerException("stateEvent.getStateEventId().getShipmentVersion() == null");
        }
        if (!(stateVersion == null && eventVersion.equals(ShipmentItemMvoState.VERSION_NULL)) && !eventVersion.equals(stateVersion))
        {
            throw DomainError.named("concurrencyConflict", "Conflict between state version (%1$s) and event version (%2$s)", stateVersion, eventVersion);
        }

    }

    public static class SimpleShipmentItemMvoState extends AbstractShipmentItemMvoState
    {

        public SimpleShipmentItemMvoState() {
        }

        public SimpleShipmentItemMvoState(boolean forReapplying) {
            super(forReapplying);
        }

        public SimpleShipmentItemMvoState(List<Event> events) {
            super(events);
        }

    }


}

