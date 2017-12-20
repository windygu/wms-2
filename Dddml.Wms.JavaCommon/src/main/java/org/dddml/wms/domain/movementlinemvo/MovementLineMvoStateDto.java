package org.dddml.wms.domain.movementlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class MovementLineMvoStateDto
{

    private MovementLineIdDto movementLineId;

    public MovementLineIdDto getMovementLineId()
    {
        return this.movementLineId;
    }

    public void setMovementLineId(MovementLineIdDto movementLineId)
    {
        this.movementLineId = movementLineId;
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

    private String movementDocumentTypeId;

    public String getMovementDocumentTypeId()
    {
        return this.movementDocumentTypeId;
    }

    public void setMovementDocumentTypeId(String movementDocumentTypeId)
    {
        this.movementDocumentTypeId = movementDocumentTypeId;
    }

    private String movementDocumentStatusId;

    public String getMovementDocumentStatusId()
    {
        return this.movementDocumentStatusId;
    }

    public void setMovementDocumentStatusId(String movementDocumentStatusId)
    {
        this.movementDocumentStatusId = movementDocumentStatusId;
    }

    private String movementMovementTypeId;

    public String getMovementMovementTypeId()
    {
        return this.movementMovementTypeId;
    }

    public void setMovementMovementTypeId(String movementMovementTypeId)
    {
        this.movementMovementTypeId = movementMovementTypeId;
    }

    private String movementDescription;

    public String getMovementDescription()
    {
        return this.movementDescription;
    }

    public void setMovementDescription(String movementDescription)
    {
        this.movementDescription = movementDescription;
    }

    private String movementCreatedBy;

    public String getMovementCreatedBy()
    {
        return this.movementCreatedBy;
    }

    public void setMovementCreatedBy(String movementCreatedBy)
    {
        this.movementCreatedBy = movementCreatedBy;
    }

    private Date movementCreatedAt;

    public Date getMovementCreatedAt()
    {
        return this.movementCreatedAt;
    }

    public void setMovementCreatedAt(Date movementCreatedAt)
    {
        this.movementCreatedAt = movementCreatedAt;
    }

    private String movementUpdatedBy;

    public String getMovementUpdatedBy()
    {
        return this.movementUpdatedBy;
    }

    public void setMovementUpdatedBy(String movementUpdatedBy)
    {
        this.movementUpdatedBy = movementUpdatedBy;
    }

    private Date movementUpdatedAt;

    public Date getMovementUpdatedAt()
    {
        return this.movementUpdatedAt;
    }

    public void setMovementUpdatedAt(Date movementUpdatedAt)
    {
        this.movementUpdatedAt = movementUpdatedAt;
    }

    private Boolean movementActive;

    public Boolean getMovementActive()
    {
        return this.movementActive;
    }

    public void setMovementActive(Boolean movementActive)
    {
        this.movementActive = movementActive;
    }

    private Boolean movementDeleted;

    public Boolean getMovementDeleted()
    {
        return this.movementDeleted;
    }

    public void setMovementDeleted(Boolean movementDeleted)
    {
        this.movementDeleted = movementDeleted;
    }

    private Long movementVersion;

    public Long getMovementVersion()
    {
        return this.movementVersion;
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.movementVersion = movementVersion;
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

        public MovementLineMvoStateDto[] toMovementLineMvoStateDtoArray(Iterable<MovementLineMvoState> states) 
        {
            ArrayList<MovementLineMvoStateDto> stateDtos = new ArrayList();
            for (MovementLineMvoState s : states) {
                MovementLineMvoStateDto dto = toMovementLineMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new MovementLineMvoStateDto[0]);
        }

        public MovementLineMvoStateDto toMovementLineMvoStateDto(MovementLineMvoState state)
        {
            if(state == null) {
                return null;
            }
            MovementLineMvoStateDto dto = new MovementLineMvoStateDto();
            if (returnedFieldsContains("MovementLineId")) {
                dto.setMovementLineId((state.getMovementLineId() == null) ? null : new MovementLineIdDtoWrapper(state.getMovementLineId()));
            }
            if (returnedFieldsContains("MovementQuantity")) {
                dto.setMovementQuantity(state.getMovementQuantity());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("MovementDocumentTypeId")) {
                dto.setMovementDocumentTypeId(state.getMovementDocumentTypeId());
            }
            if (returnedFieldsContains("MovementDocumentStatusId")) {
                dto.setMovementDocumentStatusId(state.getMovementDocumentStatusId());
            }
            if (returnedFieldsContains("MovementMovementTypeId")) {
                dto.setMovementMovementTypeId(state.getMovementMovementTypeId());
            }
            if (returnedFieldsContains("MovementDescription")) {
                dto.setMovementDescription(state.getMovementDescription());
            }
            if (returnedFieldsContains("MovementCreatedBy")) {
                dto.setMovementCreatedBy(state.getMovementCreatedBy());
            }
            if (returnedFieldsContains("MovementCreatedAt")) {
                dto.setMovementCreatedAt(state.getMovementCreatedAt());
            }
            if (returnedFieldsContains("MovementUpdatedBy")) {
                dto.setMovementUpdatedBy(state.getMovementUpdatedBy());
            }
            if (returnedFieldsContains("MovementUpdatedAt")) {
                dto.setMovementUpdatedAt(state.getMovementUpdatedAt());
            }
            if (returnedFieldsContains("MovementActive")) {
                dto.setMovementActive(state.getMovementActive());
            }
            if (returnedFieldsContains("MovementDeleted")) {
                dto.setMovementDeleted(state.getMovementDeleted());
            }
            if (returnedFieldsContains("MovementVersion")) {
                dto.setMovementVersion(state.getMovementVersion());
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

