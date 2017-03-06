package org.dddml.wms.domain.inoutlinemvo;

import java.util.*;
import org.dddml.wms.domain.inout.*;
import java.math.BigDecimal;
import java.util.Date;
import org.joda.money.Money;
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

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private String uomId;

    public String getUomId()
    {
        return this.uomId;
    }

    public void setUomId(String uomId)
    {
        this.uomId = uomId;
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

    private BigDecimal confirmedQuantity;

    public BigDecimal getConfirmedQuantity()
    {
        return this.confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
    }

    private BigDecimal scrappedQuantity;

    public BigDecimal getScrappedQuantity()
    {
        return this.scrappedQuantity;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity)
    {
        this.scrappedQuantity = scrappedQuantity;
    }

    private BigDecimal targetQuantity;

    public BigDecimal getTargetQuantity()
    {
        return this.targetQuantity;
    }

    public void setTargetQuantity(BigDecimal targetQuantity)
    {
        this.targetQuantity = targetQuantity;
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

    private String attributeSetInstanceId;

    public String getAttributeSetInstanceId()
    {
        return this.attributeSetInstanceId;
    }

    public void setAttributeSetInstanceId(String attributeSetInstanceId)
    {
        this.attributeSetInstanceId = attributeSetInstanceId;
    }

    private Boolean isDescription;

    public Boolean getIsDescription()
    {
        return this.isDescription;
    }

    public void setIsDescription(Boolean isDescription)
    {
        this.isDescription = isDescription;
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

    private BigDecimal quantityEntered;

    public BigDecimal getQuantityEntered()
    {
        return this.quantityEntered;
    }

    public void setQuantityEntered(BigDecimal quantityEntered)
    {
        this.quantityEntered = quantityEntered;
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

    private Boolean inOutIsSOTransaction;

    public Boolean getInOutIsSOTransaction()
    {
        return this.inOutIsSOTransaction;
    }

    public void setInOutIsSOTransaction(Boolean inOutIsSOTransaction)
    {
        this.inOutIsSOTransaction = inOutIsSOTransaction;
    }

    private String inOutDocumentStatus;

    public String getInOutDocumentStatus()
    {
        return this.inOutDocumentStatus;
    }

    public void setInOutDocumentStatus(String inOutDocumentStatus)
    {
        this.inOutDocumentStatus = inOutDocumentStatus;
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

    private Boolean inOutProcessing;

    public Boolean getInOutProcessing()
    {
        return this.inOutProcessing;
    }

    public void setInOutProcessing(Boolean inOutProcessing)
    {
        this.inOutProcessing = inOutProcessing;
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

    private Integer inOutDocumentType;

    public Integer getInOutDocumentType()
    {
        return this.inOutDocumentType;
    }

    public void setInOutDocumentType(Integer inOutDocumentType)
    {
        this.inOutDocumentType = inOutDocumentType;
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

    private String inOutOrderNumber;

    public String getInOutOrderNumber()
    {
        return this.inOutOrderNumber;
    }

    public void setInOutOrderNumber(String inOutOrderNumber)
    {
        this.inOutOrderNumber = inOutOrderNumber;
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

    private String inOutMovementType;

    public String getInOutMovementType()
    {
        return this.inOutMovementType;
    }

    public void setInOutMovementType(String inOutMovementType)
    {
        this.inOutMovementType = inOutMovementType;
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

    private Money inOutFreightAmount;

    public Money getInOutFreightAmount()
    {
        return this.inOutFreightAmount;
    }

    public void setInOutFreightAmount(Money inOutFreightAmount)
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

    private Money inOutChargeAmount;

    public Money getInOutChargeAmount()
    {
        return this.inOutChargeAmount;
    }

    public void setInOutChargeAmount(Money inOutChargeAmount)
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

    private String inOutSalesRepresentative;

    public String getInOutSalesRepresentative()
    {
        return this.inOutSalesRepresentative;
    }

    public void setInOutSalesRepresentative(String inOutSalesRepresentative)
    {
        this.inOutSalesRepresentative = inOutSalesRepresentative;
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

    private BigDecimal inOutVolume;

    public BigDecimal getInOutVolume()
    {
        return this.inOutVolume;
    }

    public void setInOutVolume(BigDecimal inOutVolume)
    {
        this.inOutVolume = inOutVolume;
    }

    private BigDecimal inOutWeight;

    public BigDecimal getInOutWeight()
    {
        return this.inOutWeight;
    }

    public void setInOutWeight(BigDecimal inOutWeight)
    {
        this.inOutWeight = inOutWeight;
    }

    private String inOutRmaNumber;

    public String getInOutRmaNumber()
    {
        return this.inOutRmaNumber;
    }

    public void setInOutRmaNumber(String inOutRmaNumber)
    {
        this.inOutRmaNumber = inOutRmaNumber;
    }

    private String inOutReversalNumber;

    public String getInOutReversalNumber()
    {
        return this.inOutReversalNumber;
    }

    public void setInOutReversalNumber(String inOutReversalNumber)
    {
        this.inOutReversalNumber = inOutReversalNumber;
    }

    private Boolean inOutIsDropShip;

    public Boolean getInOutIsDropShip()
    {
        return this.inOutIsDropShip;
    }

    public void setInOutIsDropShip(Boolean inOutIsDropShip)
    {
        this.inOutIsDropShip = inOutIsDropShip;
    }

    private String inOutDropShipBusinessPartnerId;

    public String getInOutDropShipBusinessPartnerId()
    {
        return this.inOutDropShipBusinessPartnerId;
    }

    public void setInOutDropShipBusinessPartnerId(String inOutDropShipBusinessPartnerId)
    {
        this.inOutDropShipBusinessPartnerId = inOutDropShipBusinessPartnerId;
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
            InOutLineMvoStateDto dto = new InOutLineMvoStateDto();
            if (returnedFieldsContains("InOutLineId")) {
                dto.setInOutLineId((state.getInOutLineId() == null) ? null : new InOutLineIdDtoWrapper(state.getInOutLineId()));
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("LocatorId")) {
                dto.setLocatorId(state.getLocatorId());
            }
            if (returnedFieldsContains("ProductId")) {
                dto.setProductId(state.getProductId());
            }
            if (returnedFieldsContains("UomId")) {
                dto.setUomId(state.getUomId());
            }
            if (returnedFieldsContains("MovementQuantity")) {
                dto.setMovementQuantity(state.getMovementQuantity());
            }
            if (returnedFieldsContains("ConfirmedQuantity")) {
                dto.setConfirmedQuantity(state.getConfirmedQuantity());
            }
            if (returnedFieldsContains("ScrappedQuantity")) {
                dto.setScrappedQuantity(state.getScrappedQuantity());
            }
            if (returnedFieldsContains("TargetQuantity")) {
                dto.setTargetQuantity(state.getTargetQuantity());
            }
            if (returnedFieldsContains("PickedQuantity")) {
                dto.setPickedQuantity(state.getPickedQuantity());
            }
            if (returnedFieldsContains("IsInvoiced")) {
                dto.setIsInvoiced(state.getIsInvoiced());
            }
            if (returnedFieldsContains("AttributeSetInstanceId")) {
                dto.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
            }
            if (returnedFieldsContains("IsDescription")) {
                dto.setIsDescription(state.getIsDescription());
            }
            if (returnedFieldsContains("Processed")) {
                dto.setProcessed(state.getProcessed());
            }
            if (returnedFieldsContains("QuantityEntered")) {
                dto.setQuantityEntered(state.getQuantityEntered());
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
            if (returnedFieldsContains("InOutIsSOTransaction")) {
                dto.setInOutIsSOTransaction(state.getInOutIsSOTransaction());
            }
            if (returnedFieldsContains("InOutDocumentStatus")) {
                dto.setInOutDocumentStatus(state.getInOutDocumentStatus());
            }
            if (returnedFieldsContains("InOutPosted")) {
                dto.setInOutPosted(state.getInOutPosted());
            }
            if (returnedFieldsContains("InOutProcessing")) {
                dto.setInOutProcessing(state.getInOutProcessing());
            }
            if (returnedFieldsContains("InOutProcessed")) {
                dto.setInOutProcessed(state.getInOutProcessed());
            }
            if (returnedFieldsContains("InOutDocumentType")) {
                dto.setInOutDocumentType(state.getInOutDocumentType());
            }
            if (returnedFieldsContains("InOutDescription")) {
                dto.setInOutDescription(state.getInOutDescription());
            }
            if (returnedFieldsContains("InOutOrderNumber")) {
                dto.setInOutOrderNumber(state.getInOutOrderNumber());
            }
            if (returnedFieldsContains("InOutDateOrdered")) {
                dto.setInOutDateOrdered(state.getInOutDateOrdered());
            }
            if (returnedFieldsContains("InOutIsPrinted")) {
                dto.setInOutIsPrinted(state.getInOutIsPrinted());
            }
            if (returnedFieldsContains("InOutMovementType")) {
                dto.setInOutMovementType(state.getInOutMovementType());
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
            if (returnedFieldsContains("InOutSalesRepresentative")) {
                dto.setInOutSalesRepresentative(state.getInOutSalesRepresentative());
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
            if (returnedFieldsContains("InOutVolume")) {
                dto.setInOutVolume(state.getInOutVolume());
            }
            if (returnedFieldsContains("InOutWeight")) {
                dto.setInOutWeight(state.getInOutWeight());
            }
            if (returnedFieldsContains("InOutRmaNumber")) {
                dto.setInOutRmaNumber(state.getInOutRmaNumber());
            }
            if (returnedFieldsContains("InOutReversalNumber")) {
                dto.setInOutReversalNumber(state.getInOutReversalNumber());
            }
            if (returnedFieldsContains("InOutIsDropShip")) {
                dto.setInOutIsDropShip(state.getInOutIsDropShip());
            }
            if (returnedFieldsContains("InOutDropShipBusinessPartnerId")) {
                dto.setInOutDropShipBusinessPartnerId(state.getInOutDropShipBusinessPartnerId());
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

