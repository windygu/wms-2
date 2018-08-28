package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PicklistBinStateDto
{

    private String picklistBinId;

    public String getPicklistBinId()
    {
        return this.picklistBinId;
    }

    public void setPicklistBinId(String picklistBinId)
    {
        this.picklistBinId = picklistBinId;
    }

    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
    }

    private Long binLocationNumber;

    public Long getBinLocationNumber()
    {
        return this.binLocationNumber;
    }

    public void setBinLocationNumber(Long binLocationNumber)
    {
        this.binLocationNumber = binLocationNumber;
    }

    private String primaryOrderId;

    public String getPrimaryOrderId()
    {
        return this.primaryOrderId;
    }

    public void setPrimaryOrderId(String primaryOrderId)
    {
        this.primaryOrderId = primaryOrderId;
    }

    private String primaryShipGroupSeqId;

    public String getPrimaryShipGroupSeqId()
    {
        return this.primaryShipGroupSeqId;
    }

    public void setPrimaryShipGroupSeqId(String primaryShipGroupSeqId)
    {
        this.primaryShipGroupSeqId = primaryShipGroupSeqId;
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

    private PicklistItemStateDto[] picklistItems;

    public PicklistItemStateDto[] getPicklistItems()
    {
        return this.picklistItems;
    }	

    public void setPicklistItems(PicklistItemStateDto[] picklistItems)
    {
        this.picklistItems = picklistItems;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"PicklistItems"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public PicklistBinStateDto[] toPicklistBinStateDtoArray(Iterable<PicklistBinState> states) {
            return toPicklistBinStateDtoList(states).toArray(new PicklistBinStateDto[0]);
        }

        public List<PicklistBinStateDto> toPicklistBinStateDtoList(Iterable<PicklistBinState> states) {
            ArrayList<PicklistBinStateDto> stateDtos = new ArrayList();
            for (PicklistBinState s : states) {
                PicklistBinStateDto dto = toPicklistBinStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public PicklistBinStateDto toPicklistBinStateDto(PicklistBinState state)
        {
            if(state == null) {
                return null;
            }
            PicklistBinStateDto dto = new PicklistBinStateDto();
            if (returnedFieldsContains("PicklistBinId")) {
                dto.setPicklistBinId(state.getPicklistBinId());
            }
            if (returnedFieldsContains("PicklistId")) {
                dto.setPicklistId(state.getPicklistId());
            }
            if (returnedFieldsContains("BinLocationNumber")) {
                dto.setBinLocationNumber(state.getBinLocationNumber());
            }
            if (returnedFieldsContains("PrimaryOrderId")) {
                dto.setPrimaryOrderId(state.getPrimaryOrderId());
            }
            if (returnedFieldsContains("PrimaryShipGroupSeqId")) {
                dto.setPrimaryShipGroupSeqId(state.getPrimaryShipGroupSeqId());
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
            if (returnedFieldsContains("PicklistItems")) {
                ArrayList<PicklistItemStateDto> arrayList = new ArrayList();
                if (state.getPicklistItems() != null) {
                    PicklistItemStateDto.DtoConverter conv = new PicklistItemStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "PicklistItems");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (PicklistItemState s : state.getPicklistItems()) {
                        arrayList.add(conv.toPicklistItemStateDto(s));
                    }
                }
                dto.setPicklistItems(arrayList.toArray(new PicklistItemStateDto[0]));
            }
            return dto;
        }

    }
}

