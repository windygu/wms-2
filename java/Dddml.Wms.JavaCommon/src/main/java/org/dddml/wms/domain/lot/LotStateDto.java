package org.dddml.wms.domain.lot;

import org.dddml.wms.specialization.AbstractStateDtoConverter;
import org.dddml.wms.specialization.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


public class LotStateDto {

    private String lotId;

    public String getLotId() {
        return this.lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    private java.sql.Timestamp creationDate;

    public java.sql.Timestamp getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(java.sql.Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity) {
        this.quantity = quantity;
    }

    private java.sql.Timestamp expirationDate;

    public java.sql.Timestamp getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(java.sql.Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Long version;

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

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

        public LotStateDto[] toLotStateDtoArray(Iterable<LotState> states) {
            ArrayList<LotStateDto> stateDtos = new ArrayList();
            for (LotState s : states) {
                LotStateDto dto = toLotStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new LotStateDto[0]);
        }

        public LotStateDto toLotStateDto(LotState state) {
            if (state == null) {
                return null;
            }
            LotStateDto dto = new LotStateDto();
            if (returnedFieldsContains("LotId")) {
                dto.setLotId(state.getLotId());
            }
            if (returnedFieldsContains("CreationDate")) {
                dto.setCreationDate(state.getCreationDate());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("ExpirationDate")) {
                dto.setExpirationDate(state.getExpirationDate());
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

