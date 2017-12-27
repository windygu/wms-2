package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InOutLineMvoStateDto
{

    private InOutLineIdDto inOutLineId;

    public InOutLineIdDto getInOutLineId()
    {
        return this.inOutLineId;
    }

    public void setInOutLineId(InOutLineIdDto inOutLineId)
    {
        this.inOutLineId = inOutLineId;
    }

    private String locatorId;

    public String getLocatorId()
    {
        return this.locatorId;
    }

    public void setLocatorId(String locatorId)
    {
        this.locatorId = locatorId;
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

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    private String quantityUomId;

    public String getQuantityUomId()
    {
        return this.quantityUomId;
    }

    public void setQuantityUomId(String quantityUomId)
    {
        this.quantityUomId = quantityUomId;
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

    private BigDecimal pickedQuantity;

    public BigDecimal getPickedQuantity()
    {
        return this.pickedQuantity;
    }

    public void setPickedQuantity(BigDecimal pickedQuantity)
    {
        this.pickedQuantity = pickedQuantity;
    }

    private Boolean isInvoiced;

    public Boolean getIsInvoiced()
    {
        return this.isInvoiced;
    }

    public void setIsInvoiced(Boolean isInvoiced)
    {
        this.isInvoiced = isInvoiced;
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

    private Long rmaLineNumber;

    public Long getRmaLineNumber()
    {
        return this.rmaLineNumber;
    }

    public void setRmaLineNumber(Long rmaLineNumber)
    {
        this.rmaLineNumber = rmaLineNumber;
    }

    private Long reversalLineNumber;

    public Long getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber)
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

    private String inOutDocumentStatusId;

    public String getInOutDocumentStatusId()
    {
        return this.inOutDocumentStatusId;
    }

    public void setInOutDocumentStatusId(String inOutDocumentStatusId)
    {
        this.inOutDocumentStatusId = inOutDocumentStatusId;
    }

    private Boolean inOutPosted;

    public Boolean getInOutPosted()
    {
        return this.inOutPosted;
    }

    public void setInOutPosted(Boolean inOutPosted)
    {
        this.inOutPosted = inOutPosted;
    }

    private Boolean inOutProcessed;

    public Boolean getInOutProcessed()
    {
        return this.inOutProcessed;
    }

    public void setInOutProcessed(Boolean inOutProcessed)
    {
        this.inOutProcessed = inOutProcessed;
    }

    private String inOutProcessing;

    public String getInOutProcessing()
    {
        return this.inOutProcessing;
    }

    public void setInOutProcessing(String inOutProcessing)
    {
        this.inOutProcessing = inOutProcessing;
    }

    private String inOutDocumentTypeId;

    public String getInOutDocumentTypeId()
    {
        return this.inOutDocumentTypeId;
    }

    public void setInOutDocumentTypeId(String inOutDocumentTypeId)
    {
        this.inOutDocumentTypeId = inOutDocumentTypeId;
    }

    private String inOutDescription;

    public String getInOutDescription()
    {
        return this.inOutDescription;
    }

    public void setInOutDescription(String inOutDescription)
    {
        this.inOutDescription = inOutDescription;
    }

    private String inOutOrderId;

    public String getInOutOrderId()
    {
        return this.inOutOrderId;
    }

    public void setInOutOrderId(String inOutOrderId)
    {
        this.inOutOrderId = inOutOrderId;
    }

    private Date inOutDateOrdered;

    public Date getInOutDateOrdered()
    {
        return this.inOutDateOrdered;
    }

    public void setInOutDateOrdered(Date inOutDateOrdered)
    {
        this.inOutDateOrdered = inOutDateOrdered;
    }

    private Boolean inOutIsPrinted;

    public Boolean getInOutIsPrinted()
    {
        return this.inOutIsPrinted;
    }

    public void setInOutIsPrinted(Boolean inOutIsPrinted)
    {
        this.inOutIsPrinted = inOutIsPrinted;
    }

    private String inOutMovementTypeId;

    public String getInOutMovementTypeId()
    {
        return this.inOutMovementTypeId;
    }

    public void setInOutMovementTypeId(String inOutMovementTypeId)
    {
        this.inOutMovementTypeId = inOutMovementTypeId;
    }

    private Date inOutMovementDate;

    public Date getInOutMovementDate()
    {
        return this.inOutMovementDate;
    }

    public void setInOutMovementDate(Date inOutMovementDate)
    {
        this.inOutMovementDate = inOutMovementDate;
    }

    private String inOutBusinessPartnerId;

    public String getInOutBusinessPartnerId()
    {
        return this.inOutBusinessPartnerId;
    }

    public void setInOutBusinessPartnerId(String inOutBusinessPartnerId)
    {
        this.inOutBusinessPartnerId = inOutBusinessPartnerId;
    }

    private String inOutWarehouseId;

    public String getInOutWarehouseId()
    {
        return this.inOutWarehouseId;
    }

    public void setInOutWarehouseId(String inOutWarehouseId)
    {
        this.inOutWarehouseId = inOutWarehouseId;
    }

    private String inOutPOReference;

    public String getInOutPOReference()
    {
        return this.inOutPOReference;
    }

    public void setInOutPOReference(String inOutPOReference)
    {
        this.inOutPOReference = inOutPOReference;
    }

    private BigDecimal inOutFreightAmount;

    public BigDecimal getInOutFreightAmount()
    {
        return this.inOutFreightAmount;
    }

    public void setInOutFreightAmount(BigDecimal inOutFreightAmount)
    {
        this.inOutFreightAmount = inOutFreightAmount;
    }

    private String inOutShipperId;

    public String getInOutShipperId()
    {
        return this.inOutShipperId;
    }

    public void setInOutShipperId(String inOutShipperId)
    {
        this.inOutShipperId = inOutShipperId;
    }

    private BigDecimal inOutChargeAmount;

    public BigDecimal getInOutChargeAmount()
    {
        return this.inOutChargeAmount;
    }

    public void setInOutChargeAmount(BigDecimal inOutChargeAmount)
    {
        this.inOutChargeAmount = inOutChargeAmount;
    }

    private Date inOutDatePrinted;

    public Date getInOutDatePrinted()
    {
        return this.inOutDatePrinted;
    }

    public void setInOutDatePrinted(Date inOutDatePrinted)
    {
        this.inOutDatePrinted = inOutDatePrinted;
    }

    private String inOutCreatedFrom;

    public String getInOutCreatedFrom()
    {
        return this.inOutCreatedFrom;
    }

    public void setInOutCreatedFrom(String inOutCreatedFrom)
    {
        this.inOutCreatedFrom = inOutCreatedFrom;
    }

    private String inOutSalesRepresentativeId;

    public String getInOutSalesRepresentativeId()
    {
        return this.inOutSalesRepresentativeId;
    }

    public void setInOutSalesRepresentativeId(String inOutSalesRepresentativeId)
    {
        this.inOutSalesRepresentativeId = inOutSalesRepresentativeId;
    }

    private Integer inOutNumberOfPackages;

    public Integer getInOutNumberOfPackages()
    {
        return this.inOutNumberOfPackages;
    }

    public void setInOutNumberOfPackages(Integer inOutNumberOfPackages)
    {
        this.inOutNumberOfPackages = inOutNumberOfPackages;
    }

    private Date inOutPickDate;

    public Date getInOutPickDate()
    {
        return this.inOutPickDate;
    }

    public void setInOutPickDate(Date inOutPickDate)
    {
        this.inOutPickDate = inOutPickDate;
    }

    private Date inOutShipDate;

    public Date getInOutShipDate()
    {
        return this.inOutShipDate;
    }

    public void setInOutShipDate(Date inOutShipDate)
    {
        this.inOutShipDate = inOutShipDate;
    }

    private String inOutTrackingNumber;

    public String getInOutTrackingNumber()
    {
        return this.inOutTrackingNumber;
    }

    public void setInOutTrackingNumber(String inOutTrackingNumber)
    {
        this.inOutTrackingNumber = inOutTrackingNumber;
    }

    private Date inOutDateReceived;

    public Date getInOutDateReceived()
    {
        return this.inOutDateReceived;
    }

    public void setInOutDateReceived(Date inOutDateReceived)
    {
        this.inOutDateReceived = inOutDateReceived;
    }

    private Boolean inOutIsInTransit;

    public Boolean getInOutIsInTransit()
    {
        return this.inOutIsInTransit;
    }

    public void setInOutIsInTransit(Boolean inOutIsInTransit)
    {
        this.inOutIsInTransit = inOutIsInTransit;
    }

    private Boolean inOutIsApproved;

    public Boolean getInOutIsApproved()
    {
        return this.inOutIsApproved;
    }

    public void setInOutIsApproved(Boolean inOutIsApproved)
    {
        this.inOutIsApproved = inOutIsApproved;
    }

    private Boolean inOutIsInDispute;

    public Boolean getInOutIsInDispute()
    {
        return this.inOutIsInDispute;
    }

    public void setInOutIsInDispute(Boolean inOutIsInDispute)
    {
        this.inOutIsInDispute = inOutIsInDispute;
    }

    private String inOutRmaDocumentNumber;

    public String getInOutRmaDocumentNumber()
    {
        return this.inOutRmaDocumentNumber;
    }

    public void setInOutRmaDocumentNumber(String inOutRmaDocumentNumber)
    {
        this.inOutRmaDocumentNumber = inOutRmaDocumentNumber;
    }

    private String inOutReversalDocumentNumber;

    public String getInOutReversalDocumentNumber()
    {
        return this.inOutReversalDocumentNumber;
    }

    public void setInOutReversalDocumentNumber(String inOutReversalDocumentNumber)
    {
        this.inOutReversalDocumentNumber = inOutReversalDocumentNumber;
    }

    private String inOutCreatedBy;

    public String getInOutCreatedBy()
    {
        return this.inOutCreatedBy;
    }

    public void setInOutCreatedBy(String inOutCreatedBy)
    {
        this.inOutCreatedBy = inOutCreatedBy;
    }

    private Date inOutCreatedAt;

    public Date getInOutCreatedAt()
    {
        return this.inOutCreatedAt;
    }

    public void setInOutCreatedAt(Date inOutCreatedAt)
    {
        this.inOutCreatedAt = inOutCreatedAt;
    }

    private String inOutUpdatedBy;

    public String getInOutUpdatedBy()
    {
        return this.inOutUpdatedBy;
    }

    public void setInOutUpdatedBy(String inOutUpdatedBy)
    {
        this.inOutUpdatedBy = inOutUpdatedBy;
    }

    private Date inOutUpdatedAt;

    public Date getInOutUpdatedAt()
    {
        return this.inOutUpdatedAt;
    }

    public void setInOutUpdatedAt(Date inOutUpdatedAt)
    {
        this.inOutUpdatedAt = inOutUpdatedAt;
    }

    private Boolean inOutActive;

    public Boolean getInOutActive()
    {
        return this.inOutActive;
    }

    public void setInOutActive(Boolean inOutActive)
    {
        this.inOutActive = inOutActive;
    }

    private Boolean inOutDeleted;

    public Boolean getInOutDeleted()
    {
        return this.inOutDeleted;
    }

    public void setInOutDeleted(Boolean inOutDeleted)
    {
        this.inOutDeleted = inOutDeleted;
    }

    private Long inOutVersion;

    public Long getInOutVersion()
    {
        return this.inOutVersion;
    }

    public void setInOutVersion(Long inOutVersion)
    {
        this.inOutVersion = inOutVersion;
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

        public InOutLineMvoStateDto[] toInOutLineMvoStateDtoArray(Iterable<InOutLineMvoState> states) 
        {
            ArrayList<InOutLineMvoStateDto> stateDtos = new ArrayList();
            for (InOutLineMvoState s : states) {
                InOutLineMvoStateDto dto = toInOutLineMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InOutLineMvoStateDto[0]);
        }

        public InOutLineMvoStateDto toInOutLineMvoStateDto(InOutLineMvoState state)
        {
            if(state == null) {
                return null;
            }
            InOutLineMvoStateDto dto = new InOutLineMvoStateDto();
            if (returnedFieldsContains("InOutLineId")) {
                dto.setInOutLineId((state.getInOutLineId() == null) ? null : new InOutLineIdDtoWrapper(state.getInOutLineId()));
            }
            if (returnedFieldsContains("LocatorId")) {
                dto.setLocatorId(state.getLocatorId());
            }
            if (returnedFieldsContains("ProductId")) {
                dto.setProductId(state.getProductId());
            }
            if (returnedFieldsContains("AttributeSetInstanceId")) {
                dto.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("QuantityUomId")) {
                dto.setQuantityUomId(state.getQuantityUomId());
            }
            if (returnedFieldsContains("MovementQuantity")) {
                dto.setMovementQuantity(state.getMovementQuantity());
            }
            if (returnedFieldsContains("PickedQuantity")) {
                dto.setPickedQuantity(state.getPickedQuantity());
            }
            if (returnedFieldsContains("IsInvoiced")) {
                dto.setIsInvoiced(state.getIsInvoiced());
            }
            if (returnedFieldsContains("Processed")) {
                dto.setProcessed(state.getProcessed());
            }
            if (returnedFieldsContains("RmaLineNumber")) {
                dto.setRmaLineNumber(state.getRmaLineNumber());
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
            if (returnedFieldsContains("InOutDocumentStatusId")) {
                dto.setInOutDocumentStatusId(state.getInOutDocumentStatusId());
            }
            if (returnedFieldsContains("InOutPosted")) {
                dto.setInOutPosted(state.getInOutPosted());
            }
            if (returnedFieldsContains("InOutProcessed")) {
                dto.setInOutProcessed(state.getInOutProcessed());
            }
            if (returnedFieldsContains("InOutProcessing")) {
                dto.setInOutProcessing(state.getInOutProcessing());
            }
            if (returnedFieldsContains("InOutDocumentTypeId")) {
                dto.setInOutDocumentTypeId(state.getInOutDocumentTypeId());
            }
            if (returnedFieldsContains("InOutDescription")) {
                dto.setInOutDescription(state.getInOutDescription());
            }
            if (returnedFieldsContains("InOutOrderId")) {
                dto.setInOutOrderId(state.getInOutOrderId());
            }
            if (returnedFieldsContains("InOutDateOrdered")) {
                dto.setInOutDateOrdered(state.getInOutDateOrdered());
            }
            if (returnedFieldsContains("InOutIsPrinted")) {
                dto.setInOutIsPrinted(state.getInOutIsPrinted());
            }
            if (returnedFieldsContains("InOutMovementTypeId")) {
                dto.setInOutMovementTypeId(state.getInOutMovementTypeId());
            }
            if (returnedFieldsContains("InOutMovementDate")) {
                dto.setInOutMovementDate(state.getInOutMovementDate());
            }
            if (returnedFieldsContains("InOutBusinessPartnerId")) {
                dto.setInOutBusinessPartnerId(state.getInOutBusinessPartnerId());
            }
            if (returnedFieldsContains("InOutWarehouseId")) {
                dto.setInOutWarehouseId(state.getInOutWarehouseId());
            }
            if (returnedFieldsContains("InOutPOReference")) {
                dto.setInOutPOReference(state.getInOutPOReference());
            }
            if (returnedFieldsContains("InOutFreightAmount")) {
                dto.setInOutFreightAmount(state.getInOutFreightAmount());
            }
            if (returnedFieldsContains("InOutShipperId")) {
                dto.setInOutShipperId(state.getInOutShipperId());
            }
            if (returnedFieldsContains("InOutChargeAmount")) {
                dto.setInOutChargeAmount(state.getInOutChargeAmount());
            }
            if (returnedFieldsContains("InOutDatePrinted")) {
                dto.setInOutDatePrinted(state.getInOutDatePrinted());
            }
            if (returnedFieldsContains("InOutCreatedFrom")) {
                dto.setInOutCreatedFrom(state.getInOutCreatedFrom());
            }
            if (returnedFieldsContains("InOutSalesRepresentativeId")) {
                dto.setInOutSalesRepresentativeId(state.getInOutSalesRepresentativeId());
            }
            if (returnedFieldsContains("InOutNumberOfPackages")) {
                dto.setInOutNumberOfPackages(state.getInOutNumberOfPackages());
            }
            if (returnedFieldsContains("InOutPickDate")) {
                dto.setInOutPickDate(state.getInOutPickDate());
            }
            if (returnedFieldsContains("InOutShipDate")) {
                dto.setInOutShipDate(state.getInOutShipDate());
            }
            if (returnedFieldsContains("InOutTrackingNumber")) {
                dto.setInOutTrackingNumber(state.getInOutTrackingNumber());
            }
            if (returnedFieldsContains("InOutDateReceived")) {
                dto.setInOutDateReceived(state.getInOutDateReceived());
            }
            if (returnedFieldsContains("InOutIsInTransit")) {
                dto.setInOutIsInTransit(state.getInOutIsInTransit());
            }
            if (returnedFieldsContains("InOutIsApproved")) {
                dto.setInOutIsApproved(state.getInOutIsApproved());
            }
            if (returnedFieldsContains("InOutIsInDispute")) {
                dto.setInOutIsInDispute(state.getInOutIsInDispute());
            }
            if (returnedFieldsContains("InOutRmaDocumentNumber")) {
                dto.setInOutRmaDocumentNumber(state.getInOutRmaDocumentNumber());
            }
            if (returnedFieldsContains("InOutReversalDocumentNumber")) {
                dto.setInOutReversalDocumentNumber(state.getInOutReversalDocumentNumber());
            }
            if (returnedFieldsContains("InOutCreatedBy")) {
                dto.setInOutCreatedBy(state.getInOutCreatedBy());
            }
            if (returnedFieldsContains("InOutCreatedAt")) {
                dto.setInOutCreatedAt(state.getInOutCreatedAt());
            }
            if (returnedFieldsContains("InOutUpdatedBy")) {
                dto.setInOutUpdatedBy(state.getInOutUpdatedBy());
            }
            if (returnedFieldsContains("InOutUpdatedAt")) {
                dto.setInOutUpdatedAt(state.getInOutUpdatedAt());
            }
            if (returnedFieldsContains("InOutActive")) {
                dto.setInOutActive(state.getInOutActive());
            }
            if (returnedFieldsContains("InOutDeleted")) {
                dto.setInOutDeleted(state.getInOutDeleted());
            }
            if (returnedFieldsContains("InOutVersion")) {
                dto.setInOutVersion(state.getInOutVersion());
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

