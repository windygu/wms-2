package org.dddml.wms.domain.inout;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InOutLineImageStateDto
{

    private String sequenceId;

    public String getSequenceId()
    {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId)
    {
        this.sequenceId = sequenceId;
    }

    private String url;

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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

    private String inOutLineLineNumber;

    public String getInOutLineLineNumber()
    {
        return this.inOutLineLineNumber;
    }

    public void setInOutLineLineNumber(String inOutLineLineNumber)
    {
        this.inOutLineLineNumber = inOutLineLineNumber;
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

        public InOutLineImageStateDto[] toInOutLineImageStateDtoArray(Iterable<InOutLineImageState> states) {
            return toInOutLineImageStateDtoList(states).toArray(new InOutLineImageStateDto[0]);
        }

        public List<InOutLineImageStateDto> toInOutLineImageStateDtoList(Iterable<InOutLineImageState> states) {
            ArrayList<InOutLineImageStateDto> stateDtos = new ArrayList();
            for (InOutLineImageState s : states) {
                InOutLineImageStateDto dto = toInOutLineImageStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public InOutLineImageStateDto toInOutLineImageStateDto(InOutLineImageState state)
        {
            if(state == null) {
                return null;
            }
            InOutLineImageStateDto dto = new InOutLineImageStateDto();
            if (returnedFieldsContains("SequenceId")) {
                dto.setSequenceId(state.getSequenceId());
            }
            if (returnedFieldsContains("Url")) {
                dto.setUrl(state.getUrl());
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
            if (returnedFieldsContains("InOutLineLineNumber")) {
                dto.setInOutLineLineNumber(state.getInOutLineLineNumber());
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

