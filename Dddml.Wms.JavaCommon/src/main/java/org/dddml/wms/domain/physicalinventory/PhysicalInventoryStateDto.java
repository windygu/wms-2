package org.dddml.wms.domain.physicalinventory;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PhysicalInventoryStateDto
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

    private String warehouseId;

    public String getWarehouseId()
    {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId)
    {
        this.warehouseId = warehouseId;
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

    private Date movementDate;

    public Date getMovementDate()
    {
        return this.movementDate;
    }

    public void setMovementDate(Date movementDate)
    {
        this.movementDate = movementDate;
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

    private Boolean isApproved;

    public Boolean getIsApproved()
    {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved)
    {
        this.isApproved = isApproved;
    }

    private BigDecimal approvalAmount;

    public BigDecimal getApprovalAmount()
    {
        return this.approvalAmount;
    }

    public void setApprovalAmount(BigDecimal approvalAmount)
    {
        this.approvalAmount = approvalAmount;
    }

    private Boolean isQuantityUpdated;

    public Boolean getIsQuantityUpdated()
    {
        return this.isQuantityUpdated;
    }

    public void setIsQuantityUpdated(Boolean isQuantityUpdated)
    {
        this.isQuantityUpdated = isQuantityUpdated;
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

    private PhysicalInventoryLineStateDto[] physicalInventoryLines;

    public PhysicalInventoryLineStateDto[] getPhysicalInventoryLines()
    {
        return this.physicalInventoryLines;
    }	

    public void setPhysicalInventoryLines(PhysicalInventoryLineStateDto[] physicalInventoryLines)
    {
        this.physicalInventoryLines = physicalInventoryLines;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"PhysicalInventoryLines"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public PhysicalInventoryStateDto[] toPhysicalInventoryStateDtoArray(Iterable<PhysicalInventoryState> states) 
        {
            ArrayList<PhysicalInventoryStateDto> stateDtos = new ArrayList();
            for (PhysicalInventoryState s : states) {
                PhysicalInventoryStateDto dto = toPhysicalInventoryStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new PhysicalInventoryStateDto[0]);
        }

        public PhysicalInventoryStateDto toPhysicalInventoryStateDto(PhysicalInventoryState state)
        {
            if(state == null) {
                return null;
            }
            PhysicalInventoryStateDto dto = new PhysicalInventoryStateDto();
            if (returnedFieldsContains("DocumentNumber")) {
                dto.setDocumentNumber(state.getDocumentNumber());
            }
            if (returnedFieldsContains("DocumentStatusId")) {
                dto.setDocumentStatusId(state.getDocumentStatusId());
            }
            if (returnedFieldsContains("WarehouseId")) {
                dto.setWarehouseId(state.getWarehouseId());
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
            if (returnedFieldsContains("MovementDate")) {
                dto.setMovementDate(state.getMovementDate());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("IsApproved")) {
                dto.setIsApproved(state.getIsApproved());
            }
            if (returnedFieldsContains("ApprovalAmount")) {
                dto.setApprovalAmount(state.getApprovalAmount());
            }
            if (returnedFieldsContains("IsQuantityUpdated")) {
                dto.setIsQuantityUpdated(state.getIsQuantityUpdated());
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
            if (returnedFieldsContains("PhysicalInventoryLines")) {
                ArrayList<PhysicalInventoryLineStateDto> arrayList = new ArrayList();
                if (state.getPhysicalInventoryLines() != null) {
                    PhysicalInventoryLineStateDto.DtoConverter conv = new PhysicalInventoryLineStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "PhysicalInventoryLines");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (PhysicalInventoryLineState s : state.getPhysicalInventoryLines()) {
                        arrayList.add(conv.toPhysicalInventoryLineStateDto(s));
                    }
                }
                dto.setPhysicalInventoryLines(arrayList.toArray(new PhysicalInventoryLineStateDto[0]));
            }
            return dto;
        }

    }
}

