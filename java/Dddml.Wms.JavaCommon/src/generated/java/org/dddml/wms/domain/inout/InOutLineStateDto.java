package org.dddml.wms.domain.inout;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InOutLineStateDto
{

    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
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

    private String damageStatusId;

    public String getDamageStatusId()
    {
        return this.damageStatusId;
    }

    public void setDamageStatusId(String damageStatusId)
    {
        this.damageStatusId = damageStatusId;
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

    private String rmaLineNumber;

    public String getRmaLineNumber()
    {
        return this.rmaLineNumber;
    }

    public void setRmaLineNumber(String rmaLineNumber)
    {
        this.rmaLineNumber = rmaLineNumber;
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

    private String inOutDocumentNumber;

    public String getInOutDocumentNumber()
    {
        return this.inOutDocumentNumber;
    }

    public void setInOutDocumentNumber(String inOutDocumentNumber)
    {
        this.inOutDocumentNumber = inOutDocumentNumber;
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

    private InOutLineImageStateDto[] inOutLineImages;

    public InOutLineImageStateDto[] getInOutLineImages()
    {
        return this.inOutLineImages;
    }	

    public void setInOutLineImages(InOutLineImageStateDto[] inOutLineImages)
    {
        this.inOutLineImages = inOutLineImages;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"InOutLineImages"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public InOutLineStateDto[] toInOutLineStateDtoArray(Iterable<InOutLineState> states) 
        {
            ArrayList<InOutLineStateDto> stateDtos = new ArrayList();
            for (InOutLineState s : states) {
                InOutLineStateDto dto = toInOutLineStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InOutLineStateDto[0]);
        }

        public InOutLineStateDto toInOutLineStateDto(InOutLineState state)
        {
            if(state == null) {
                return null;
            }
            InOutLineStateDto dto = new InOutLineStateDto();
            if (returnedFieldsContains("LineNumber")) {
                dto.setLineNumber(state.getLineNumber());
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
            if (returnedFieldsContains("DamageStatusId")) {
                dto.setDamageStatusId(state.getDamageStatusId());
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
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("InOutDocumentNumber")) {
                dto.setInOutDocumentNumber(state.getInOutDocumentNumber());
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
            if (returnedFieldsContains("InOutLineImages")) {
                ArrayList<InOutLineImageStateDto> arrayList = new ArrayList();
                if (state.getInOutLineImages() != null) {
                    InOutLineImageStateDto.DtoConverter conv = new InOutLineImageStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "InOutLineImages");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (InOutLineImageState s : state.getInOutLineImages()) {
                        arrayList.add(conv.toInOutLineImageStateDto(s));
                    }
                }
                dto.setInOutLineImages(arrayList.toArray(new InOutLineImageStateDto[0]));
            }
            return dto;
        }

    }
}

