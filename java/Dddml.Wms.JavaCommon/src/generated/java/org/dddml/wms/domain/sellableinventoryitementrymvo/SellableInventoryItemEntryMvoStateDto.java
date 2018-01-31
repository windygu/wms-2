package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class SellableInventoryItemEntryMvoStateDto
{

    private SellableInventoryItemEntryIdDto sellableInventoryItemEntryId;

    public SellableInventoryItemEntryIdDto getSellableInventoryItemEntryId()
    {
        return this.sellableInventoryItemEntryId;
    }

    public void setSellableInventoryItemEntryId(SellableInventoryItemEntryIdDto sellableInventoryItemEntryId)
    {
        this.sellableInventoryItemEntryId = sellableInventoryItemEntryId;
    }

    private BigDecimal sellableQuantity;

    public BigDecimal getSellableQuantity()
    {
        return this.sellableQuantity;
    }

    public void setSellableQuantity(BigDecimal sellableQuantity)
    {
        this.sellableQuantity = sellableQuantity;
    }

    private InventoryPRTriggeredIdDto sourceEventId;

    public InventoryPRTriggeredIdDto getSourceEventId()
    {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredIdDto sourceEventId)
    {
        this.sourceEventId = sourceEventId;
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

    private BigDecimal sellableInventoryItemSellableQuantity;

    public BigDecimal getSellableInventoryItemSellableQuantity()
    {
        return this.sellableInventoryItemSellableQuantity;
    }

    public void setSellableInventoryItemSellableQuantity(BigDecimal sellableInventoryItemSellableQuantity)
    {
        this.sellableInventoryItemSellableQuantity = sellableInventoryItemSellableQuantity;
    }

    private String sellableInventoryItemCreatedBy;

    public String getSellableInventoryItemCreatedBy()
    {
        return this.sellableInventoryItemCreatedBy;
    }

    public void setSellableInventoryItemCreatedBy(String sellableInventoryItemCreatedBy)
    {
        this.sellableInventoryItemCreatedBy = sellableInventoryItemCreatedBy;
    }

    private Date sellableInventoryItemCreatedAt;

    public Date getSellableInventoryItemCreatedAt()
    {
        return this.sellableInventoryItemCreatedAt;
    }

    public void setSellableInventoryItemCreatedAt(Date sellableInventoryItemCreatedAt)
    {
        this.sellableInventoryItemCreatedAt = sellableInventoryItemCreatedAt;
    }

    private String sellableInventoryItemUpdatedBy;

    public String getSellableInventoryItemUpdatedBy()
    {
        return this.sellableInventoryItemUpdatedBy;
    }

    public void setSellableInventoryItemUpdatedBy(String sellableInventoryItemUpdatedBy)
    {
        this.sellableInventoryItemUpdatedBy = sellableInventoryItemUpdatedBy;
    }

    private Date sellableInventoryItemUpdatedAt;

    public Date getSellableInventoryItemUpdatedAt()
    {
        return this.sellableInventoryItemUpdatedAt;
    }

    public void setSellableInventoryItemUpdatedAt(Date sellableInventoryItemUpdatedAt)
    {
        this.sellableInventoryItemUpdatedAt = sellableInventoryItemUpdatedAt;
    }

    private Long sellableInventoryItemVersion;

    public Long getSellableInventoryItemVersion()
    {
        return this.sellableInventoryItemVersion;
    }

    public void setSellableInventoryItemVersion(Long sellableInventoryItemVersion)
    {
        this.sellableInventoryItemVersion = sellableInventoryItemVersion;
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

        public SellableInventoryItemEntryMvoStateDto[] toSellableInventoryItemEntryMvoStateDtoArray(Iterable<SellableInventoryItemEntryMvoState> states) 
        {
            ArrayList<SellableInventoryItemEntryMvoStateDto> stateDtos = new ArrayList();
            for (SellableInventoryItemEntryMvoState s : states) {
                SellableInventoryItemEntryMvoStateDto dto = toSellableInventoryItemEntryMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new SellableInventoryItemEntryMvoStateDto[0]);
        }

        public SellableInventoryItemEntryMvoStateDto toSellableInventoryItemEntryMvoStateDto(SellableInventoryItemEntryMvoState state)
        {
            if(state == null) {
                return null;
            }
            SellableInventoryItemEntryMvoStateDto dto = new SellableInventoryItemEntryMvoStateDto();
            if (returnedFieldsContains("SellableInventoryItemEntryId")) {
                dto.setSellableInventoryItemEntryId((state.getSellableInventoryItemEntryId() == null) ? null : new SellableInventoryItemEntryIdDtoWrapper(state.getSellableInventoryItemEntryId()));
            }
            if (returnedFieldsContains("SellableQuantity")) {
                dto.setSellableQuantity(state.getSellableQuantity());
            }
            if (returnedFieldsContains("SourceEventId")) {
                dto.setSourceEventId((state.getSourceEventId() == null) ? null : new InventoryPRTriggeredIdDtoWrapper(state.getSourceEventId()));
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("SellableInventoryItemSellableQuantity")) {
                dto.setSellableInventoryItemSellableQuantity(state.getSellableInventoryItemSellableQuantity());
            }
            if (returnedFieldsContains("SellableInventoryItemCreatedBy")) {
                dto.setSellableInventoryItemCreatedBy(state.getSellableInventoryItemCreatedBy());
            }
            if (returnedFieldsContains("SellableInventoryItemCreatedAt")) {
                dto.setSellableInventoryItemCreatedAt(state.getSellableInventoryItemCreatedAt());
            }
            if (returnedFieldsContains("SellableInventoryItemUpdatedBy")) {
                dto.setSellableInventoryItemUpdatedBy(state.getSellableInventoryItemUpdatedBy());
            }
            if (returnedFieldsContains("SellableInventoryItemUpdatedAt")) {
                dto.setSellableInventoryItemUpdatedAt(state.getSellableInventoryItemUpdatedAt());
            }
            if (returnedFieldsContains("SellableInventoryItemVersion")) {
                dto.setSellableInventoryItemVersion(state.getSellableInventoryItemVersion());
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

