package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class SellableInventoryItemEntryStateDto
{

    private Long entrySeqId;

    public Long getEntrySeqId()
    {
        return this.entrySeqId;
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.entrySeqId = entrySeqId;
    }

    private BigDecimal quantitySellable;

    public BigDecimal getQuantitySellable()
    {
        return this.quantitySellable;
    }

    public void setQuantitySellable(BigDecimal quantitySellable)
    {
        this.quantitySellable = quantitySellable;
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

    private InventoryItemIdDto sellableInventoryItemId;

    public InventoryItemIdDto getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemIdDto sellableInventoryItemId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
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

        public SellableInventoryItemEntryStateDto[] toSellableInventoryItemEntryStateDtoArray(Iterable<SellableInventoryItemEntryState> states) 
        {
            ArrayList<SellableInventoryItemEntryStateDto> stateDtos = new ArrayList();
            for (SellableInventoryItemEntryState s : states) {
                SellableInventoryItemEntryStateDto dto = toSellableInventoryItemEntryStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new SellableInventoryItemEntryStateDto[0]);
        }

        public SellableInventoryItemEntryStateDto toSellableInventoryItemEntryStateDto(SellableInventoryItemEntryState state)
        {
            if(state == null) {
                return null;
            }
            SellableInventoryItemEntryStateDto dto = new SellableInventoryItemEntryStateDto();
            if (returnedFieldsContains("EntrySeqId")) {
                dto.setEntrySeqId(state.getEntrySeqId());
            }
            if (returnedFieldsContains("QuantitySellable")) {
                dto.setQuantitySellable(state.getQuantitySellable());
            }
            if (returnedFieldsContains("SourceEventId")) {
                dto.setSourceEventId((state.getSourceEventId() == null) ? null : new InventoryPRTriggeredIdDtoWrapper(state.getSourceEventId()));
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("SellableInventoryItemId")) {
                dto.setSellableInventoryItemId((state.getSellableInventoryItemId() == null) ? null : new InventoryItemIdDtoWrapper(state.getSellableInventoryItemId()));
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

