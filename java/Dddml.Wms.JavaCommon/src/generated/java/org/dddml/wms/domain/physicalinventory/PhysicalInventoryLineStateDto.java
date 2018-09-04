package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PhysicalInventoryLineStateDto
{

    private InventoryItemId inventoryItemId;

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    private BigDecimal bookQuantity;

    public BigDecimal getBookQuantity()
    {
        return this.bookQuantity;
    }

    public void setBookQuantity(BigDecimal bookQuantity)
    {
        this.bookQuantity = bookQuantity;
    }

    private BigDecimal countedQuantity;

    public BigDecimal getCountedQuantity()
    {
        return this.countedQuantity;
    }

    public void setCountedQuantity(BigDecimal countedQuantity)
    {
        this.countedQuantity = countedQuantity;
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

    private String lineNumber;

    public String getLineNumber()
    {
        return this.lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
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

    private String description;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    private String physicalInventoryDocumentNumber;

    public String getPhysicalInventoryDocumentNumber()
    {
        return this.physicalInventoryDocumentNumber;
    }

    public void setPhysicalInventoryDocumentNumber(String physicalInventoryDocumentNumber)
    {
        this.physicalInventoryDocumentNumber = physicalInventoryDocumentNumber;
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

        public PhysicalInventoryLineStateDto[] toPhysicalInventoryLineStateDtoArray(Iterable<PhysicalInventoryLineState> states) {
            return toPhysicalInventoryLineStateDtoList(states).toArray(new PhysicalInventoryLineStateDto[0]);
        }

        public List<PhysicalInventoryLineStateDto> toPhysicalInventoryLineStateDtoList(Iterable<PhysicalInventoryLineState> states) {
            ArrayList<PhysicalInventoryLineStateDto> stateDtos = new ArrayList();
            for (PhysicalInventoryLineState s : states) {
                PhysicalInventoryLineStateDto dto = toPhysicalInventoryLineStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public PhysicalInventoryLineStateDto toPhysicalInventoryLineStateDto(PhysicalInventoryLineState state)
        {
            if(state == null) {
                return null;
            }
            PhysicalInventoryLineStateDto dto = new PhysicalInventoryLineStateDto();
            if (returnedFieldsContains("InventoryItemId")) {
                dto.setInventoryItemId(state.getInventoryItemId());
            }
            if (returnedFieldsContains("BookQuantity")) {
                dto.setBookQuantity(state.getBookQuantity());
            }
            if (returnedFieldsContains("CountedQuantity")) {
                dto.setCountedQuantity(state.getCountedQuantity());
            }
            if (returnedFieldsContains("Processed")) {
                dto.setProcessed(state.getProcessed());
            }
            if (returnedFieldsContains("LineNumber")) {
                dto.setLineNumber(state.getLineNumber());
            }
            if (returnedFieldsContains("ReversalLineNumber")) {
                dto.setReversalLineNumber(state.getReversalLineNumber());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("PhysicalInventoryDocumentNumber")) {
                dto.setPhysicalInventoryDocumentNumber(state.getPhysicalInventoryDocumentNumber());
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

