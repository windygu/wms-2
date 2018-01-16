package org.dddml.wms.domain.inout;

import java.util.*;
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

    private String documentStatusId;

    public String getDocumentStatusId()
    {
        return this.documentStatusId;
    }

    public void setDocumentStatusId(String documentStatusId)
    {
        this.documentStatusId = documentStatusId;
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

    private Boolean processed;

    public Boolean getProcessed()
    {
        return this.processed;
    }

    public void setProcessed(Boolean processed)
    {
        this.processed = processed;
    }

    private String processing;

    public String getProcessing()
    {
        return this.processing;
    }

    public void setProcessing(String processing)
    {
        this.processing = processing;
    }

    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
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

    private String orderId;

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
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

    private String movementTypeId;

    public String getMovementTypeId()
    {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.movementTypeId = movementTypeId;
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

    private BigDecimal freightAmount;

    public BigDecimal getFreightAmount()
    {
        return this.freightAmount;
    }

    public void setFreightAmount(BigDecimal freightAmount)
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

    private BigDecimal chargeAmount;

    public BigDecimal getChargeAmount()
    {
        return this.chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount)
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

    private String createdFrom;

    public String getCreatedFrom()
    {
        return this.createdFrom;
    }

    public void setCreatedFrom(String createdFrom)
    {
        this.createdFrom = createdFrom;
    }

    private String salesRepresentativeId;

    public String getSalesRepresentativeId()
    {
        return this.salesRepresentativeId;
    }

    public void setSalesRepresentativeId(String salesRepresentativeId)
    {
        this.salesRepresentativeId = salesRepresentativeId;
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

    private String rmaDocumentNumber;

    public String getRmaDocumentNumber()
    {
        return this.rmaDocumentNumber;
    }

    public void setRmaDocumentNumber(String rmaDocumentNumber)
    {
        this.rmaDocumentNumber = rmaDocumentNumber;
    }

    private String reversalDocumentNumber;

    public String getReversalDocumentNumber()
    {
        return this.reversalDocumentNumber;
    }

    public void setReversalDocumentNumber(String reversalDocumentNumber)
    {
        this.reversalDocumentNumber = reversalDocumentNumber;
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
            if(state == null) {
                return null;
            }
            InOutStateDto dto = new InOutStateDto();
            if (returnedFieldsContains("DocumentNumber")) {
                dto.setDocumentNumber(state.getDocumentNumber());
            }
            if (returnedFieldsContains("DocumentStatusId")) {
                dto.setDocumentStatusId(state.getDocumentStatusId());
            }
            if (returnedFieldsContains("Posted")) {
                dto.setPosted(state.getPosted());
            }
            if (returnedFieldsContains("Processed")) {
                dto.setProcessed(state.getProcessed());
            }
            if (returnedFieldsContains("Processing")) {
                dto.setProcessing(state.getProcessing());
            }
            if (returnedFieldsContains("DocumentTypeId")) {
                dto.setDocumentTypeId(state.getDocumentTypeId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("OrderId")) {
                dto.setOrderId(state.getOrderId());
            }
            if (returnedFieldsContains("DateOrdered")) {
                dto.setDateOrdered(state.getDateOrdered());
            }
            if (returnedFieldsContains("IsPrinted")) {
                dto.setIsPrinted(state.getIsPrinted());
            }
            if (returnedFieldsContains("MovementTypeId")) {
                dto.setMovementTypeId(state.getMovementTypeId());
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
            if (returnedFieldsContains("CreatedFrom")) {
                dto.setCreatedFrom(state.getCreatedFrom());
            }
            if (returnedFieldsContains("SalesRepresentativeId")) {
                dto.setSalesRepresentativeId(state.getSalesRepresentativeId());
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
            if (returnedFieldsContains("RmaDocumentNumber")) {
                dto.setRmaDocumentNumber(state.getRmaDocumentNumber());
            }
            if (returnedFieldsContains("ReversalDocumentNumber")) {
                dto.setReversalDocumentNumber(state.getReversalDocumentNumber());
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

