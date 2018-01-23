package org.dddml.wms.domain.damagetype;

import org.dddml.wms.specialization.AbstractStateDtoConverter;
import org.dddml.wms.specialization.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


public class DamageTypeStateDto {

    private String damageTypeId;
    private String description;
    private String sequenceId;
    private String defaultHandlingMethodId;
    private Boolean active;
    private Long version;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;

    public String getDamageTypeId() {
        return this.damageTypeId;
    }

    public void setDamageTypeId(String damageTypeId) {
        this.damageTypeId = damageTypeId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSequenceId() {
        return this.sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getDefaultHandlingMethodId() {
        return this.defaultHandlingMethodId;
    }

    public void setDefaultHandlingMethodId(String defaultHandlingMethodId) {
        this.defaultHandlingMethodId = defaultHandlingMethodId;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public static class DtoConverter extends AbstractStateDtoConverter {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public DamageTypeStateDto[] toDamageTypeStateDtoArray(Iterable<DamageTypeState> states) {
            ArrayList<DamageTypeStateDto> stateDtos = new ArrayList();
            for (DamageTypeState s : states) {
                DamageTypeStateDto dto = toDamageTypeStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new DamageTypeStateDto[0]);
        }

        public DamageTypeStateDto toDamageTypeStateDto(DamageTypeState state) {
            if (state == null) {
                return null;
            }
            DamageTypeStateDto dto = new DamageTypeStateDto();
            if (returnedFieldsContains("DamageTypeId")) {
                dto.setDamageTypeId(state.getDamageTypeId());
            }
            if (returnedFieldsContains("Description")) {
                dto.setDescription(state.getDescription());
            }
            if (returnedFieldsContains("SequenceId")) {
                dto.setSequenceId(state.getSequenceId());
            }
            if (returnedFieldsContains("DefaultHandlingMethodId")) {
                dto.setDefaultHandlingMethodId(state.getDefaultHandlingMethodId());
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

