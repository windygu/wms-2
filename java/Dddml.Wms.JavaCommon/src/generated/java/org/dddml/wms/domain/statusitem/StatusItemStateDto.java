package org.dddml.wms.domain.statusitem;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class StatusItemStateDto
{

    private String statusId;

    public String getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(String statusId)
    {
        this.statusId = statusId;
    }

    private String statusTypeId;

    public String getStatusTypeId()
    {
        return this.statusTypeId;
    }

    public void setStatusTypeId(String statusTypeId)
    {
        this.statusTypeId = statusTypeId;
    }

    private String statusCode;

    public String getStatusCode()
    {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode)
    {
        this.statusCode = statusCode;
    }

    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
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


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public StatusItemStateDto[] toStatusItemStateDtoArray(Iterable<StatusItemState> states) {
            return toStatusItemStateDtoList(states).toArray(new StatusItemStateDto[0]);
        }

        public List<StatusItemStateDto> toStatusItemStateDtoList(Iterable<StatusItemState> states) {
            ArrayList<StatusItemStateDto> stateDtos = new ArrayList();
            for (StatusItemState s : states) {
                StatusItemStateDto dto = toStatusItemStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public StatusItemStateDto toStatusItemStateDto(StatusItemState state)
        {
            if(state == null) {
                return null;
            }
            StatusItemStateDto dto = new StatusItemStateDto();
            if (returnedFieldsContains("StatusId")) {
                dto.setStatusId(state.getStatusId());
            }
            if (returnedFieldsContains("StatusTypeId")) {
                dto.setStatusTypeId(state.getStatusTypeId());
            }
            if (returnedFieldsContains("StatusCode")) {
                dto.setStatusCode(state.getStatusCode());
            }
            if (returnedFieldsContains("SequenceId")) {
                dto.setSequenceId(state.getSequenceId());
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
            return dto;
        }

    }
}

