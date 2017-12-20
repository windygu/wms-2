package org.dddml.wms.domain.movement;

import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class MovementStateDto
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

    private String documentTypeId;

    public String getDocumentTypeId()
    {
        return this.documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId)
    {
        this.documentTypeId = documentTypeId;
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

    private String movementTypeId;

    public String getMovementTypeId()
    {
        return this.movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.movementTypeId = movementTypeId;
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

    private MovementLineStateDto[] movementLines;

    public MovementLineStateDto[] getMovementLines()
    {
        return this.movementLines;
    }	

    public void setMovementLines(MovementLineStateDto[] movementLines)
    {
        this.movementLines = movementLines;
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
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"MovementLines", "MovementConfirmationLines"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public MovementStateDto[] toMovementStateDtoArray(Iterable<MovementState> states) 
        {
            ArrayList<MovementStateDto> stateDtos = new ArrayList();
            for (MovementState s : states) {
                MovementStateDto dto = toMovementStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new MovementStateDto[0]);
        }

        public MovementStateDto toMovementStateDto(MovementState state)
        {
            if(state == null) {
                return null;
            }
            MovementStateDto dto = new MovementStateDto();
            if (returnedFieldsContains("DocumentNumber")) {
                dto.setDocumentNumber(state.getDocumentNumber());
            }
            if (returnedFieldsContains("DocumentTypeId")) {
                dto.setDocumentTypeId(state.getDocumentTypeId());
            }
            if (returnedFieldsContains("DocumentStatusId")) {
                dto.setDocumentStatusId(state.getDocumentStatusId());
            }
            if (returnedFieldsContains("MovementTypeId")) {
                dto.setMovementTypeId(state.getMovementTypeId());
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
            if (returnedFieldsContains("MovementLines")) {
                ArrayList<MovementLineStateDto> arrayList = new ArrayList();
                if (state.getMovementLines() != null) {
                    MovementLineStateDto.DtoConverter conv = new MovementLineStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "MovementLines");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (MovementLineState s : state.getMovementLines()) {
                        arrayList.add(conv.toMovementLineStateDto(s));
                    }
                }
                dto.setMovementLines(arrayList.toArray(new MovementLineStateDto[0]));
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

