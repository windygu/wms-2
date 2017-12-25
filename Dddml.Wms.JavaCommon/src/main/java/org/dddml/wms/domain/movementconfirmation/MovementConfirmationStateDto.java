package org.dddml.wms.domain.movementconfirmation;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class MovementConfirmationStateDto
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

    private String movementDocumentNumber;

    public String getMovementDocumentNumber()
    {
        return this.movementDocumentNumber;
    }

    public void setMovementDocumentNumber(String movementDocumentNumber)
    {
        this.movementDocumentNumber = movementDocumentNumber;
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

    private MovementConfirmationLineStateDto[] movementConfirmationLines;

    public MovementConfirmationLineStateDto[] getMovementConfirmationLines()
    {
        return this.movementConfirmationLines;
    }	

    public void setMovementConfirmationLines(MovementConfirmationLineStateDto[] movementConfirmationLines)
    {
        this.movementConfirmationLines = movementConfirmationLines;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"MovementConfirmationLines"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public MovementConfirmationStateDto[] toMovementConfirmationStateDtoArray(Iterable<MovementConfirmationState> states) 
        {
            ArrayList<MovementConfirmationStateDto> stateDtos = new ArrayList();
            for (MovementConfirmationState s : states) {
                MovementConfirmationStateDto dto = toMovementConfirmationStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new MovementConfirmationStateDto[0]);
        }

        public MovementConfirmationStateDto toMovementConfirmationStateDto(MovementConfirmationState state)
        {
            if(state == null) {
                return null;
            }
            MovementConfirmationStateDto dto = new MovementConfirmationStateDto();
            if (returnedFieldsContains("DocumentNumber")) {
                dto.setDocumentNumber(state.getDocumentNumber());
            }
            if (returnedFieldsContains("DocumentStatusId")) {
                dto.setDocumentStatusId(state.getDocumentStatusId());
            }
            if (returnedFieldsContains("MovementDocumentNumber")) {
                dto.setMovementDocumentNumber(state.getMovementDocumentNumber());
            }
            if (returnedFieldsContains("IsApproved")) {
                dto.setIsApproved(state.getIsApproved());
            }
            if (returnedFieldsContains("ApprovalAmount")) {
                dto.setApprovalAmount(state.getApprovalAmount());
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
            if (returnedFieldsContains("MovementConfirmationLines")) {
                ArrayList<MovementConfirmationLineStateDto> arrayList = new ArrayList();
                if (state.getMovementConfirmationLines() != null) {
                    MovementConfirmationLineStateDto.DtoConverter conv = new MovementConfirmationLineStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "MovementConfirmationLines");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (MovementConfirmationLineState s : state.getMovementConfirmationLines()) {
                        arrayList.add(conv.toMovementConfirmationLineStateDto(s));
                    }
                }
                dto.setMovementConfirmationLines(arrayList.toArray(new MovementConfirmationLineStateDto[0]));
            }
            return dto;
        }

    }
}

