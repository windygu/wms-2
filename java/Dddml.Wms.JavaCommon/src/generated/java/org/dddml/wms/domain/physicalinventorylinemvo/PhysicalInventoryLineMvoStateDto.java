package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.*;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PhysicalInventoryLineMvoStateDto
{

    private PhysicalInventoryLineId physicalInventoryLineId;

    public PhysicalInventoryLineId getPhysicalInventoryLineId()
    {
        return this.physicalInventoryLineId;
    }

    public void setPhysicalInventoryLineId(PhysicalInventoryLineId physicalInventoryLineId)
    {
        this.physicalInventoryLineId = physicalInventoryLineId;
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

    private Long reversalLineNumber;

    public Long getReversalLineNumber()
    {
        return this.reversalLineNumber;
    }

    public void setReversalLineNumber(Long reversalLineNumber)
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

    private String physicalInventoryDocumentStatusId;

    public String getPhysicalInventoryDocumentStatusId()
    {
        return this.physicalInventoryDocumentStatusId;
    }

    public void setPhysicalInventoryDocumentStatusId(String physicalInventoryDocumentStatusId)
    {
        this.physicalInventoryDocumentStatusId = physicalInventoryDocumentStatusId;
    }

    private String physicalInventoryWarehouseId;

    public String getPhysicalInventoryWarehouseId()
    {
        return this.physicalInventoryWarehouseId;
    }

    public void setPhysicalInventoryWarehouseId(String physicalInventoryWarehouseId)
    {
        this.physicalInventoryWarehouseId = physicalInventoryWarehouseId;
    }

    private String physicalInventoryLocatorIdPattern;

    public String getPhysicalInventoryLocatorIdPattern()
    {
        return this.physicalInventoryLocatorIdPattern;
    }

    public void setPhysicalInventoryLocatorIdPattern(String physicalInventoryLocatorIdPattern)
    {
        this.physicalInventoryLocatorIdPattern = physicalInventoryLocatorIdPattern;
    }

    private String physicalInventoryProductIdPattern;

    public String getPhysicalInventoryProductIdPattern()
    {
        return this.physicalInventoryProductIdPattern;
    }

    public void setPhysicalInventoryProductIdPattern(String physicalInventoryProductIdPattern)
    {
        this.physicalInventoryProductIdPattern = physicalInventoryProductIdPattern;
    }

    private Boolean physicalInventoryPosted;

    public Boolean getPhysicalInventoryPosted()
    {
        return this.physicalInventoryPosted;
    }

    public void setPhysicalInventoryPosted(Boolean physicalInventoryPosted)
    {
        this.physicalInventoryPosted = physicalInventoryPosted;
    }

    private Boolean physicalInventoryProcessed;

    public Boolean getPhysicalInventoryProcessed()
    {
        return this.physicalInventoryProcessed;
    }

    public void setPhysicalInventoryProcessed(Boolean physicalInventoryProcessed)
    {
        this.physicalInventoryProcessed = physicalInventoryProcessed;
    }

    private String physicalInventoryProcessing;

    public String getPhysicalInventoryProcessing()
    {
        return this.physicalInventoryProcessing;
    }

    public void setPhysicalInventoryProcessing(String physicalInventoryProcessing)
    {
        this.physicalInventoryProcessing = physicalInventoryProcessing;
    }

    private String physicalInventoryDocumentTypeId;

    public String getPhysicalInventoryDocumentTypeId()
    {
        return this.physicalInventoryDocumentTypeId;
    }

    public void setPhysicalInventoryDocumentTypeId(String physicalInventoryDocumentTypeId)
    {
        this.physicalInventoryDocumentTypeId = physicalInventoryDocumentTypeId;
    }

    private Date physicalInventoryMovementDate;

    public Date getPhysicalInventoryMovementDate()
    {
        return this.physicalInventoryMovementDate;
    }

    public void setPhysicalInventoryMovementDate(Date physicalInventoryMovementDate)
    {
        this.physicalInventoryMovementDate = physicalInventoryMovementDate;
    }

    private String physicalInventoryDescription;

    public String getPhysicalInventoryDescription()
    {
        return this.physicalInventoryDescription;
    }

    public void setPhysicalInventoryDescription(String physicalInventoryDescription)
    {
        this.physicalInventoryDescription = physicalInventoryDescription;
    }

    private Boolean physicalInventoryIsApproved;

    public Boolean getPhysicalInventoryIsApproved()
    {
        return this.physicalInventoryIsApproved;
    }

    public void setPhysicalInventoryIsApproved(Boolean physicalInventoryIsApproved)
    {
        this.physicalInventoryIsApproved = physicalInventoryIsApproved;
    }

    private BigDecimal physicalInventoryApprovalAmount;

    public BigDecimal getPhysicalInventoryApprovalAmount()
    {
        return this.physicalInventoryApprovalAmount;
    }

    public void setPhysicalInventoryApprovalAmount(BigDecimal physicalInventoryApprovalAmount)
    {
        this.physicalInventoryApprovalAmount = physicalInventoryApprovalAmount;
    }

    private Boolean physicalInventoryIsQuantityUpdated;

    public Boolean getPhysicalInventoryIsQuantityUpdated()
    {
        return this.physicalInventoryIsQuantityUpdated;
    }

    public void setPhysicalInventoryIsQuantityUpdated(Boolean physicalInventoryIsQuantityUpdated)
    {
        this.physicalInventoryIsQuantityUpdated = physicalInventoryIsQuantityUpdated;
    }

    private String physicalInventoryReversalDocumentNumber;

    public String getPhysicalInventoryReversalDocumentNumber()
    {
        return this.physicalInventoryReversalDocumentNumber;
    }

    public void setPhysicalInventoryReversalDocumentNumber(String physicalInventoryReversalDocumentNumber)
    {
        this.physicalInventoryReversalDocumentNumber = physicalInventoryReversalDocumentNumber;
    }

    private String physicalInventoryCreatedBy;

    public String getPhysicalInventoryCreatedBy()
    {
        return this.physicalInventoryCreatedBy;
    }

    public void setPhysicalInventoryCreatedBy(String physicalInventoryCreatedBy)
    {
        this.physicalInventoryCreatedBy = physicalInventoryCreatedBy;
    }

    private Date physicalInventoryCreatedAt;

    public Date getPhysicalInventoryCreatedAt()
    {
        return this.physicalInventoryCreatedAt;
    }

    public void setPhysicalInventoryCreatedAt(Date physicalInventoryCreatedAt)
    {
        this.physicalInventoryCreatedAt = physicalInventoryCreatedAt;
    }

    private String physicalInventoryUpdatedBy;

    public String getPhysicalInventoryUpdatedBy()
    {
        return this.physicalInventoryUpdatedBy;
    }

    public void setPhysicalInventoryUpdatedBy(String physicalInventoryUpdatedBy)
    {
        this.physicalInventoryUpdatedBy = physicalInventoryUpdatedBy;
    }

    private Date physicalInventoryUpdatedAt;

    public Date getPhysicalInventoryUpdatedAt()
    {
        return this.physicalInventoryUpdatedAt;
    }

    public void setPhysicalInventoryUpdatedAt(Date physicalInventoryUpdatedAt)
    {
        this.physicalInventoryUpdatedAt = physicalInventoryUpdatedAt;
    }

    private Boolean physicalInventoryActive;

    public Boolean getPhysicalInventoryActive()
    {
        return this.physicalInventoryActive;
    }

    public void setPhysicalInventoryActive(Boolean physicalInventoryActive)
    {
        this.physicalInventoryActive = physicalInventoryActive;
    }

    private Long physicalInventoryVersion;

    public Long getPhysicalInventoryVersion()
    {
        return this.physicalInventoryVersion;
    }

    public void setPhysicalInventoryVersion(Long physicalInventoryVersion)
    {
        this.physicalInventoryVersion = physicalInventoryVersion;
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

        public PhysicalInventoryLineMvoStateDto[] toPhysicalInventoryLineMvoStateDtoArray(Iterable<PhysicalInventoryLineMvoState> states) 
        {
            ArrayList<PhysicalInventoryLineMvoStateDto> stateDtos = new ArrayList();
            for (PhysicalInventoryLineMvoState s : states) {
                PhysicalInventoryLineMvoStateDto dto = toPhysicalInventoryLineMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new PhysicalInventoryLineMvoStateDto[0]);
        }

        public PhysicalInventoryLineMvoStateDto toPhysicalInventoryLineMvoStateDto(PhysicalInventoryLineMvoState state)
        {
            if(state == null) {
                return null;
            }
            PhysicalInventoryLineMvoStateDto dto = new PhysicalInventoryLineMvoStateDto();
            if (returnedFieldsContains("PhysicalInventoryLineId")) {
                dto.setPhysicalInventoryLineId(state.getPhysicalInventoryLineId());
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
            if (returnedFieldsContains("PhysicalInventoryDocumentStatusId")) {
                dto.setPhysicalInventoryDocumentStatusId(state.getPhysicalInventoryDocumentStatusId());
            }
            if (returnedFieldsContains("PhysicalInventoryWarehouseId")) {
                dto.setPhysicalInventoryWarehouseId(state.getPhysicalInventoryWarehouseId());
            }
            if (returnedFieldsContains("PhysicalInventoryLocatorIdPattern")) {
                dto.setPhysicalInventoryLocatorIdPattern(state.getPhysicalInventoryLocatorIdPattern());
            }
            if (returnedFieldsContains("PhysicalInventoryProductIdPattern")) {
                dto.setPhysicalInventoryProductIdPattern(state.getPhysicalInventoryProductIdPattern());
            }
            if (returnedFieldsContains("PhysicalInventoryPosted")) {
                dto.setPhysicalInventoryPosted(state.getPhysicalInventoryPosted());
            }
            if (returnedFieldsContains("PhysicalInventoryProcessed")) {
                dto.setPhysicalInventoryProcessed(state.getPhysicalInventoryProcessed());
            }
            if (returnedFieldsContains("PhysicalInventoryProcessing")) {
                dto.setPhysicalInventoryProcessing(state.getPhysicalInventoryProcessing());
            }
            if (returnedFieldsContains("PhysicalInventoryDocumentTypeId")) {
                dto.setPhysicalInventoryDocumentTypeId(state.getPhysicalInventoryDocumentTypeId());
            }
            if (returnedFieldsContains("PhysicalInventoryMovementDate")) {
                dto.setPhysicalInventoryMovementDate(state.getPhysicalInventoryMovementDate());
            }
            if (returnedFieldsContains("PhysicalInventoryDescription")) {
                dto.setPhysicalInventoryDescription(state.getPhysicalInventoryDescription());
            }
            if (returnedFieldsContains("PhysicalInventoryIsApproved")) {
                dto.setPhysicalInventoryIsApproved(state.getPhysicalInventoryIsApproved());
            }
            if (returnedFieldsContains("PhysicalInventoryApprovalAmount")) {
                dto.setPhysicalInventoryApprovalAmount(state.getPhysicalInventoryApprovalAmount());
            }
            if (returnedFieldsContains("PhysicalInventoryIsQuantityUpdated")) {
                dto.setPhysicalInventoryIsQuantityUpdated(state.getPhysicalInventoryIsQuantityUpdated());
            }
            if (returnedFieldsContains("PhysicalInventoryReversalDocumentNumber")) {
                dto.setPhysicalInventoryReversalDocumentNumber(state.getPhysicalInventoryReversalDocumentNumber());
            }
            if (returnedFieldsContains("PhysicalInventoryCreatedBy")) {
                dto.setPhysicalInventoryCreatedBy(state.getPhysicalInventoryCreatedBy());
            }
            if (returnedFieldsContains("PhysicalInventoryCreatedAt")) {
                dto.setPhysicalInventoryCreatedAt(state.getPhysicalInventoryCreatedAt());
            }
            if (returnedFieldsContains("PhysicalInventoryUpdatedBy")) {
                dto.setPhysicalInventoryUpdatedBy(state.getPhysicalInventoryUpdatedBy());
            }
            if (returnedFieldsContains("PhysicalInventoryUpdatedAt")) {
                dto.setPhysicalInventoryUpdatedAt(state.getPhysicalInventoryUpdatedAt());
            }
            if (returnedFieldsContains("PhysicalInventoryActive")) {
                dto.setPhysicalInventoryActive(state.getPhysicalInventoryActive());
            }
            if (returnedFieldsContains("PhysicalInventoryVersion")) {
                dto.setPhysicalInventoryVersion(state.getPhysicalInventoryVersion());
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

