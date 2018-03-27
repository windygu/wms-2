package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PicklistItemStateDto
{

    private PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId;

    public PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId()
    {
        return this.picklistItemOrderShipGrpInvId;
    }

    public void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId)
    {
        this.picklistItemOrderShipGrpInvId = picklistItemOrderShipGrpInvId;
    }

    private String itemStatusId;

    public String getItemStatusId()
    {
        return this.itemStatusId;
    }

    public void setItemStatusId(String itemStatusId)
    {
        this.itemStatusId = itemStatusId;
    }

    private java.math.BigDecimal quantity;

    public java.math.BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(java.math.BigDecimal quantity)
    {
        this.quantity = quantity;
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

    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
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

        public PicklistItemStateDto[] toPicklistItemStateDtoArray(Iterable<PicklistItemState> states) 
        {
            ArrayList<PicklistItemStateDto> stateDtos = new ArrayList();
            for (PicklistItemState s : states) {
                PicklistItemStateDto dto = toPicklistItemStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new PicklistItemStateDto[0]);
        }

        public PicklistItemStateDto toPicklistItemStateDto(PicklistItemState state)
        {
            if(state == null) {
                return null;
            }
            PicklistItemStateDto dto = new PicklistItemStateDto();
            if (returnedFieldsContains("PicklistItemOrderShipGrpInvId")) {
                dto.setPicklistItemOrderShipGrpInvId(state.getPicklistItemOrderShipGrpInvId());
            }
            if (returnedFieldsContains("ItemStatusId")) {
                dto.setItemStatusId(state.getItemStatusId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("PicklistBinId")) {
                dto.setPicklistBinId(state.getPicklistBinId());
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

