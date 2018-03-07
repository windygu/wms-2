package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class MovementLineMvoStateDto
{

    private MovementLineId movementLineId;

    public MovementLineId getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineId movementLineId)
    {
        this.movementLineId = movementLineId;
    }

    private BigDecimal movementQuantity;

    public BigDecimal getMovementQuantity()
    {
        return this.movementQuantity;
    }

    public void setMovementQuantity(BigDecimal movementQuantity)
    {
        this.movementQuantity = movementQuantity;
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

    private String locatorIdFrom;

    public String getLocatorIdFrom()
    {
        return this.locatorIdFrom;
    }

    public void setLocatorIdFrom(String locatorIdFrom)
    {
        this.locatorIdFrom = locatorIdFrom;
    }

    private String locatorIdTo;

    public String getLocatorIdTo()
    {
        return this.locatorIdTo;
    }

    public void setLocatorIdTo(String locatorIdTo)
    {
        this.locatorIdTo = locatorIdTo;
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

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    private String reversalLineNumber;

    public String getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(String reversalLineNumber)
    {
        this.reversalLineNumber = reversalLineNumber;
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

    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId()
    {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId)
    {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    private Date movementMovementDate;

    public Date getMovementMovementDate()
    {
        return this.movementMovementDate;
    }

    public void setMovementMovementDate(Date movementMovementDate)
    {
        this.movementMovementDate = movementMovementDate;
    }

    private Boolean movementPosted;

    public Boolean getMovementPosted()
    {
        return this.movementPosted;
    }

    public void setMovementPosted(Boolean movementPosted)
    {
        this.movementPosted = movementPosted;
    }

    private Boolean movementProcessed;

    public Boolean getMovementProcessed()
    {
        return this.movementProcessed;
    }

    public void setMovementProcessed(Boolean movementProcessed)
    {
        this.movementProcessed = movementProcessed;
    }

    private String movementProcessing;

    public String getMovementProcessing()
    {
        return this.movementProcessing;
    }

    public void setMovementProcessing(String movementProcessing)
    {
        this.movementProcessing = movementProcessing;
    }

    private Date movementDateReceived;

    public Date getMovementDateReceived()
    {
        return this.movementDateReceived;
    }

    public void setMovementDateReceived(Date movementDateReceived)
    {
        this.movementDateReceived = movementDateReceived;
    }

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    private Boolean movementIsInTransit;

    public Boolean getMovementIsInTransit()
    {
        return this.movementIsInTransit;
    }

    public void setMovementIsInTransit(Boolean movementIsInTransit)
    {
        this.movementIsInTransit = movementIsInTransit;
    }

    private Boolean movementIsApproved;

    public Boolean getMovementIsApproved()
    {
        return this.movementIsApproved;
    }

    public void setMovementIsApproved(Boolean movementIsApproved)
    {
        this.movementIsApproved = movementIsApproved;
    }

    private BigDecimal movementApprovalAmount;

    public BigDecimal getMovementApprovalAmount()
    {
        return this.movementApprovalAmount;
    }

    public void setMovementApprovalAmount(BigDecimal movementApprovalAmount)
    {
        this.movementApprovalAmount = movementApprovalAmount;
    }

    private String movementShipperId;

    public String getMovementShipperId()
    {
        return this.movementShipperId;
    }

    public void setMovementShipperId(String movementShipperId)
    {
        this.movementShipperId = movementShipperId;
    }

    private String movementSalesRepresentativeId;

    public String getMovementSalesRepresentativeId()
    {
        return this.movementSalesRepresentativeId;
    }

    public void setMovementSalesRepresentativeId(String movementSalesRepresentativeId)
    {
        this.movementSalesRepresentativeId = movementSalesRepresentativeId;
    }

    private String movementBusinessPartnerId;

    public String getMovementBusinessPartnerId()
    {
        return this.movementBusinessPartnerId;
    }

    public void setMovementBusinessPartnerId(String movementBusinessPartnerId)
    {
        this.movementBusinessPartnerId = movementBusinessPartnerId;
    }

    private BigDecimal movementChargeAmount;

    public BigDecimal getMovementChargeAmount()
    {
        return this.movementChargeAmount;
    }

    public void setMovementChargeAmount(BigDecimal movementChargeAmount)
    {
        this.movementChargeAmount = movementChargeAmount;
    }

    private String movementCreateFrom;

    public String getMovementCreateFrom()
    {
        return this.movementCreateFrom;
    }

    public void setMovementCreateFrom(String movementCreateFrom)
    {
        this.movementCreateFrom = movementCreateFrom;
    }

    private BigDecimal movementFreightAmount;

    public BigDecimal getMovementFreightAmount()
    {
        return this.movementFreightAmount;
    }

    public void setMovementFreightAmount(BigDecimal movementFreightAmount)
    {
        this.movementFreightAmount = movementFreightAmount;
    }

    private String movementReversalDocumentNumber;

    public String getMovementReversalDocumentNumber()
    {
        return this.movementReversalDocumentNumber;
    }

    public void setMovementReversalDocumentNumber(String movementReversalDocumentNumber)
    {
        this.movementReversalDocumentNumber = movementReversalDocumentNumber;
    }

    private String movementWarehouseIdFrom;

    public String getMovementWarehouseIdFrom()
    {
        return this.movementWarehouseIdFrom;
    }

    public void setMovementWarehouseIdFrom(String movementWarehouseIdFrom)
    {
        this.movementWarehouseIdFrom = movementWarehouseIdFrom;
    }

    private String movementWarehouseIdTo;

    public String getMovementWarehouseIdTo()
    {
        return this.movementWarehouseIdTo;
    }

    public void setMovementWarehouseIdTo(String movementWarehouseIdTo)
    {
        this.movementWarehouseIdTo = movementWarehouseIdTo;
    }

    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
    }

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
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

        public MovementLineMvoStateDto[] toMovementLineMvoStateDtoArray(Iterable<MovementLineMvoState> states) 
        {
            ArrayList<MovementLineMvoStateDto> stateDtos = new ArrayList();
            for (MovementLineMvoState s : states) {
                MovementLineMvoStateDto dto = toMovementLineMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new MovementLineMvoStateDto[0]);
        }

        public MovementLineMvoStateDto toMovementLineMvoStateDto(MovementLineMvoState state)
        {
            if(state == null) {
                return null;
            }
            MovementLineMvoStateDto dto = new MovementLineMvoStateDto();
            if (returnedFieldsContains("MovementLineId")) {
                dto.setMovementLineId(state.getMovementLineId());
            }
            if (returnedFieldsContains("MovementQuantity")) {
                dto.setMovementQuantity(state.getMovementQuantity());
            }
            if (returnedFieldsContains("ProductId")) {
                dto.setProductId(state.getProductId());
            }
            if (returnedFieldsContains("LocatorIdFrom")) {
                dto.setLocatorIdFrom(state.getLocatorIdFrom());
            }
            if (returnedFieldsContains("LocatorIdTo")) {
                dto.setLocatorIdTo(state.getLocatorIdTo());
            }
            if (returnedFieldsContains("AttributeSetInstanceId")) {
                dto.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
            }
            if (returnedFieldsContains("Processed")) {
                dto.setProcessed(state.getProcessed());
            }
            if (returnedFieldsContains("ReversalLineNumber")) {
                dto.setReversalLineNumber(state.getReversalLineNumber());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("MovementDocumentStatusId")) {
                dto.setMovementDocumentStatusId(state.getMovementDocumentStatusId());
            }
            if (returnedFieldsContains("MovementMovementDate")) {
                dto.setMovementMovementDate(state.getMovementMovementDate());
            }
            if (returnedFieldsContains("MovementPosted")) {
                dto.setMovementPosted(state.getMovementPosted());
            }
            if (returnedFieldsContains("MovementProcessed")) {
                dto.setMovementProcessed(state.getMovementProcessed());
            }
            if (returnedFieldsContains("MovementProcessing")) {
                dto.setMovementProcessing(state.getMovementProcessing());
            }
            if (returnedFieldsContains("MovementDateReceived")) {
                dto.setMovementDateReceived(state.getMovementDateReceived());
            }
            if (returnedFieldsContains("MovementDocumentTypeId")) {
                dto.setMovementDocumentTypeId(state.getMovementDocumentTypeId());
            }
            if (returnedFieldsContains("MovementIsInTransit")) {
                dto.setMovementIsInTransit(state.getMovementIsInTransit());
            }
            if (returnedFieldsContains("MovementIsApproved")) {
                dto.setMovementIsApproved(state.getMovementIsApproved());
            }
            if (returnedFieldsContains("MovementApprovalAmount")) {
                dto.setMovementApprovalAmount(state.getMovementApprovalAmount());
            }
            if (returnedFieldsContains("MovementShipperId")) {
                dto.setMovementShipperId(state.getMovementShipperId());
            }
            if (returnedFieldsContains("MovementSalesRepresentativeId")) {
                dto.setMovementSalesRepresentativeId(state.getMovementSalesRepresentativeId());
            }
            if (returnedFieldsContains("MovementBusinessPartnerId")) {
                dto.setMovementBusinessPartnerId(state.getMovementBusinessPartnerId());
            }
            if (returnedFieldsContains("MovementChargeAmount")) {
                dto.setMovementChargeAmount(state.getMovementChargeAmount());
            }
            if (returnedFieldsContains("MovementCreateFrom")) {
                dto.setMovementCreateFrom(state.getMovementCreateFrom());
            }
            if (returnedFieldsContains("MovementFreightAmount")) {
                dto.setMovementFreightAmount(state.getMovementFreightAmount());
            }
            if (returnedFieldsContains("MovementReversalDocumentNumber")) {
                dto.setMovementReversalDocumentNumber(state.getMovementReversalDocumentNumber());
            }
            if (returnedFieldsContains("MovementWarehouseIdFrom")) {
                dto.setMovementWarehouseIdFrom(state.getMovementWarehouseIdFrom());
            }
            if (returnedFieldsContains("MovementWarehouseIdTo")) {
                dto.setMovementWarehouseIdTo(state.getMovementWarehouseIdTo());
            }
            if (returnedFieldsContains("MovementDescription")) {
                dto.setMovementDescription(state.getMovementDescription());
            }
            if (returnedFieldsContains("MovementCreatedBy")) {
                dto.setMovementCreatedBy(state.getMovementCreatedBy());
            }
            if (returnedFieldsContains("MovementCreatedAt")) {
                dto.setMovementCreatedAt(state.getMovementCreatedAt());
            }
            if (returnedFieldsContains("MovementUpdatedBy")) {
                dto.setMovementUpdatedBy(state.getMovementUpdatedBy());
            }
            if (returnedFieldsContains("MovementUpdatedAt")) {
                dto.setMovementUpdatedAt(state.getMovementUpdatedAt());
            }
            if (returnedFieldsContains("MovementActive")) {
                dto.setMovementActive(state.getMovementActive());
            }
            if (returnedFieldsContains("MovementDeleted")) {
                dto.setMovementDeleted(state.getMovementDeleted());
            }
            if (returnedFieldsContains("MovementVersion")) {
                dto.setMovementVersion(state.getMovementVersion());
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

