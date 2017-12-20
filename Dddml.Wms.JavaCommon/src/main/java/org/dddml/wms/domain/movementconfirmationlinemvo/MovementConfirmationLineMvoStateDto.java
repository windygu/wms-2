package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.*;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class MovementConfirmationLineMvoStateDto
{

    private MovementConfirmationLineIdDto movementConfirmationLineId;

    public MovementConfirmationLineIdDto getMovementConfirmationLineId()
    {
        return this.movementConfirmationLineId;
    }

    public void setMovementConfirmationLineId(MovementConfirmationLineIdDto movementConfirmationLineId)
    {
        this.movementConfirmationLineId = movementConfirmationLineId;
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

    private BigDecimal confirmedQuantity;

    public BigDecimal getConfirmedQuantity()
    {
        return this.confirmedQuantity;
    }

    public void setConfirmedQuantity(BigDecimal confirmedQuantity)
    {
        this.confirmedQuantity = confirmedQuantity;
    }

    private BigDecimal differenceQuantity;

    public BigDecimal getDifferenceQuantity()
    {
        return this.differenceQuantity;
    }

    public void setDifferenceQuantity(BigDecimal differenceQuantity)
    {
        this.differenceQuantity = differenceQuantity;
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

        public MovementConfirmationLineMvoStateDto[] toMovementConfirmationLineMvoStateDtoArray(Iterable<MovementConfirmationLineMvoState> states) 
        {
            ArrayList<MovementConfirmationLineMvoStateDto> stateDtos = new ArrayList();
            for (MovementConfirmationLineMvoState s : states) {
                MovementConfirmationLineMvoStateDto dto = toMovementConfirmationLineMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new MovementConfirmationLineMvoStateDto[0]);
        }

        public MovementConfirmationLineMvoStateDto toMovementConfirmationLineMvoStateDto(MovementConfirmationLineMvoState state)
        {
            if(state == null) {
                return null;
            }
            MovementConfirmationLineMvoStateDto dto = new MovementConfirmationLineMvoStateDto();
            if (returnedFieldsContains("MovementConfirmationLineId")) {
                dto.setMovementConfirmationLineId((state.getMovementConfirmationLineId() == null) ? null : new MovementConfirmationLineIdDtoWrapper(state.getMovementConfirmationLineId()));
            }
            if (returnedFieldsContains("TargetQuantity")) {
                dto.setTargetQuantity(state.getTargetQuantity());
            }
            if (returnedFieldsContains("ConfirmedQuantity")) {
                dto.setConfirmedQuantity(state.getConfirmedQuantity());
            }
            if (returnedFieldsContains("DifferenceQuantity")) {
                dto.setDifferenceQuantity(state.getDifferenceQuantity());
            }
            if (returnedFieldsContains("ScrappedQuantity")) {
                dto.setScrappedQuantity(state.getScrappedQuantity());
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

