package org.dddml.wms.domain.inout;

import java.util.*;
import org.joda.money.Money;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InOutStateDto
{

    private String documentNumber;

    public String getDocumentNumber()
    {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    private Boolean isSOTransaction;

    public Boolean getIsSOTransaction()
    {
        return this.isSOTransaction;
    }

    public void setIsSOTransaction(Boolean isSOTransaction)
    {
        this.isSOTransaction = isSOTransaction;
    }

    private String documentStatus;

    public String getDocumentStatus()
    {
        return this.documentStatus;
    }

    public void setDocumentStatus(String documentStatus)
    {
        this.documentStatus = documentStatus;
    }

    private Boolean posted;

    public Boolean getPosted()
    {
        return this.posted;
    }

    public void setPosted(Boolean posted)
    {
        this.posted = posted;
    }

    private Boolean processing;

    public Boolean getProcessing()
    {
        return this.processing;
    }

    public void setProcessing(Boolean processing)
    {
        this.processing = processing;
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

    private Integer documentType;

    public Integer getDocumentType()
    {
        return this.documentType;
    }

    public void setDocumentType(Integer documentType)
    {
        this.documentType = documentType;
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

    private String orderNumber;

    public String getOrderNumber()
    {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    private Date dateOrdered;

    public Date getDateOrdered()
    {
        return this.dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered)
    {
        this.dateOrdered = dateOrdered;
    }

    private Boolean isPrinted;

    public Boolean getIsPrinted()
    {
        return this.isPrinted;
    }

    public void setIsPrinted(Boolean isPrinted)
    {
        this.isPrinted = isPrinted;
    }

    private String movementType;

    public String getMovementType()
    {
        return this.movementType;
    }

    public void setMovementType(String movementType)
    {
        this.movementType = movementType;
    }

    private Date movementDate;

    public Date getMovementDate()
    {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate)
    {
        this.movementDate = movementDate;
    }

    private String businessPartnerId;

    public String getBusinessPartnerId()
    {
        return this.businessPartnerId;
    }

    public void setBusinessPartnerId(String businessPartnerId)
    {
        this.businessPartnerId = businessPartnerId;
    }

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    private String POReference;

    public String getPOReference()
    {
        return this.POReference;
    }

    public void setPOReference(String poReference)
    {
        this.POReference = poReference;
    }

    private Money freightAmount;

    public Money getFreightAmount()
    {
        return this.freightAmount;
    }

    public void setFreightAmount(Money freightAmount)
    {
        this.freightAmount = freightAmount;
    }

    private String shipperId;

    public String getShipperId()
    {
        return this.shipperId;
    }

    public void setShipperId(String shipperId)
    {
        this.shipperId = shipperId;
    }

    private Money chargeAmount;

    public Money getChargeAmount()
    {
        return this.chargeAmount;
    }

    public void setChargeAmount(Money chargeAmount)
    {
        this.chargeAmount = chargeAmount;
    }

    private Date datePrinted;

    public Date getDatePrinted()
    {
        return this.datePrinted;
    }

    public void setDatePrinted(Date datePrinted)
    {
        this.datePrinted = datePrinted;
    }

    private String salesRepresentative;

    public String getSalesRepresentative()
    {
        return this.salesRepresentative;
    }

    public void setSalesRepresentative(String salesRepresentative)
    {
        this.salesRepresentative = salesRepresentative;
    }

    private Integer numberOfPackages;

    public Integer getNumberOfPackages()
    {
        return this.numberOfPackages;
    }

    public void setNumberOfPackages(Integer numberOfPackages)
    {
        this.numberOfPackages = numberOfPackages;
    }

    private Date pickDate;

    public Date getPickDate()
    {
        return this.pickDate;
    }

    public void setPickDate(Date pickDate)
    {
        this.pickDate = pickDate;
    }

    private Date shipDate;

    public Date getShipDate()
    {
        return this.shipDate;
    }

    public void setShipDate(Date shipDate)
    {
        this.shipDate = shipDate;
    }

    private String trackingNumber;

    public String getTrackingNumber()
    {
        return this.trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    private Date dateReceived;

    public Date getDateReceived()
    {
        return this.dateReceived;
    }

    public void setDateReceived(Date dateReceived)
    {
        this.dateReceived = dateReceived;
    }

    private Boolean isInTransit;

    public Boolean getIsInTransit()
    {
        return this.isInTransit;
    }

    public void setIsInTransit(Boolean isInTransit)
    {
        this.isInTransit = isInTransit;
    }

    private Boolean isApproved;

    public Boolean getIsApproved()
    {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved)
    {
        this.isApproved = isApproved;
    }

    private Boolean isInDispute;

    public Boolean getIsInDispute()
    {
        return this.isInDispute;
    }

    public void setIsInDispute(Boolean isInDispute)
    {
        this.isInDispute = isInDispute;
    }

    private BigDecimal volume;

    public BigDecimal getVolume()
    {
        return this.volume;
    }

    public void setVolume(BigDecimal volume)
    {
        this.volume = volume;
    }

    private BigDecimal weight;

    public BigDecimal getWeight()
    {
        return this.weight;
    }

    public void setWeight(BigDecimal weight)
    {
        this.weight = weight;
    }

    private String rmaNumber;

    public String getRmaNumber()
    {
        return this.rmaNumber;
    }

    public void setRmaNumber(String rmaNumber)
    {
        this.rmaNumber = rmaNumber;
    }

    private String reversalNumber;

    public String getReversalNumber()
    {
        return this.reversalNumber;
    }

    public void setReversalNumber(String reversalNumber)
    {
        this.reversalNumber = reversalNumber;
    }

    private Boolean isDropShip;

    public Boolean getIsDropShip()
    {
        return this.isDropShip;
    }

    public void setIsDropShip(Boolean isDropShip)
    {
        this.isDropShip = isDropShip;
    }

    private String dropShipBusinessPartnerId;

    public String getDropShipBusinessPartnerId()
    {
        return this.dropShipBusinessPartnerId;
    }

    public void setDropShipBusinessPartnerId(String dropShipBusinessPartnerId)
    {
        this.dropShipBusinessPartnerId = dropShipBusinessPartnerId;
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

    private InOutLineStateDto[] inOutLines;

    public InOutLineStateDto[] getInOutLines()
    {
        return this.inOutLines;
    }	

    public void setInOutLines(InOutLineStateDto[] inOutLines)
    {
        this.inOutLines = inOutLines;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"InOutLines"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public InOutStateDto[] toInOutStateDtoArray(Iterable<InOutState> states) 
        {
            ArrayList<InOutStateDto> stateDtos = new ArrayList();
            for (InOutState s : states) {
                InOutStateDto dto = toInOutStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InOutStateDto[0]);
        }

        public InOutStateDto toInOutStateDto(InOutState state)
        {
            InOutStateDto dto = new InOutStateDto();
            if (returnedFieldsContains("DocumentNumber")) {
                dto.setDocumentNumber(state.getDocumentNumber());
            }
            if (returnedFieldsContains("IsSOTransaction")) {
                dto.setIsSOTransaction(state.getIsSOTransaction());
            }
            if (returnedFieldsContains("DocumentStatus")) {
                dto.setDocumentStatus(state.getDocumentStatus());
            }
            if (returnedFieldsContains("Posted")) {
                dto.setPosted(state.getPosted());
            }
            if (returnedFieldsContains("Processing")) {
                dto.setProcessing(state.getProcessing());
            }
            if (returnedFieldsContains("Processed")) {
                dto.setProcessed(state.getProcessed());
            }
            if (returnedFieldsContains("DocumentType")) {
                dto.setDocumentType(state.getDocumentType());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("OrderNumber")) {
                dto.setOrderNumber(state.getOrderNumber());
            }
            if (returnedFieldsContains("DateOrdered")) {
                dto.setDateOrdered(state.getDateOrdered());
            }
            if (returnedFieldsContains("IsPrinted")) {
                dto.setIsPrinted(state.getIsPrinted());
            }
            if (returnedFieldsContains("MovementType")) {
                dto.setMovementType(state.getMovementType());
            }
            if (returnedFieldsContains("MovementDate")) {
                dto.setMovementDate(state.getMovementDate());
            }
            if (returnedFieldsContains("BusinessPartnerId")) {
                dto.setBusinessPartnerId(state.getBusinessPartnerId());
            }
            if (returnedFieldsContains("WarehouseId")) {
                dto.setWarehouseId(state.getWarehouseId());
            }
            if (returnedFieldsContains("POReference")) {
                dto.setPOReference(state.getPOReference());
            }
            if (returnedFieldsContains("FreightAmount")) {
                dto.setFreightAmount(state.getFreightAmount());
            }
            if (returnedFieldsContains("ShipperId")) {
                dto.setShipperId(state.getShipperId());
            }
            if (returnedFieldsContains("ChargeAmount")) {
                dto.setChargeAmount(state.getChargeAmount());
            }
            if (returnedFieldsContains("DatePrinted")) {
                dto.setDatePrinted(state.getDatePrinted());
            }
            if (returnedFieldsContains("SalesRepresentative")) {
                dto.setSalesRepresentative(state.getSalesRepresentative());
            }
            if (returnedFieldsContains("NumberOfPackages")) {
                dto.setNumberOfPackages(state.getNumberOfPackages());
            }
            if (returnedFieldsContains("PickDate")) {
                dto.setPickDate(state.getPickDate());
            }
            if (returnedFieldsContains("ShipDate")) {
                dto.setShipDate(state.getShipDate());
            }
            if (returnedFieldsContains("TrackingNumber")) {
                dto.setTrackingNumber(state.getTrackingNumber());
            }
            if (returnedFieldsContains("DateReceived")) {
                dto.setDateReceived(state.getDateReceived());
            }
            if (returnedFieldsContains("IsInTransit")) {
                dto.setIsInTransit(state.getIsInTransit());
            }
            if (returnedFieldsContains("IsApproved")) {
                dto.setIsApproved(state.getIsApproved());
            }
            if (returnedFieldsContains("IsInDispute")) {
                dto.setIsInDispute(state.getIsInDispute());
            }
            if (returnedFieldsContains("Volume")) {
                dto.setVolume(state.getVolume());
            }
            if (returnedFieldsContains("Weight")) {
                dto.setWeight(state.getWeight());
            }
            if (returnedFieldsContains("RmaNumber")) {
                dto.setRmaNumber(state.getRmaNumber());
            }
            if (returnedFieldsContains("ReversalNumber")) {
                dto.setReversalNumber(state.getReversalNumber());
            }
            if (returnedFieldsContains("IsDropShip")) {
                dto.setIsDropShip(state.getIsDropShip());
            }
            if (returnedFieldsContains("DropShipBusinessPartnerId")) {
                dto.setDropShipBusinessPartnerId(state.getDropShipBusinessPartnerId());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
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
            if (returnedFieldsContains("InOutLines")) {
                ArrayList<InOutLineStateDto> arrayList = new ArrayList();
                if (state.getInOutLines() != null) {
                    InOutLineStateDto.DtoConverter conv = new InOutLineStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "InOutLines");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (InOutLineState s : state.getInOutLines()) {
                        arrayList.add(conv.toInOutLineStateDto(s));
                    }
                }
                dto.setInOutLines(arrayList.toArray(new InOutLineStateDto[0]));
            }
            return dto;
        }

    }
}

