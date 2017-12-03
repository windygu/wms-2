package org.dddml.wms.domain.sellableinventoryitem;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class SellableInventoryItemStateDto
{

    private InventoryItemIdDto sellableInventoryItemId;

    public InventoryItemIdDto getSellableInventoryItemId()
    {
        return this.sellableInventoryItemId;
    }

    public void setSellableInventoryItemId(InventoryItemIdDto sellableInventoryItemId)
    {
        this.sellableInventoryItemId = sellableInventoryItemId;
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

    private SellableInventoryItemEntryStateDto[] entries;

    public SellableInventoryItemEntryStateDto[] getEntries()
    {
        return this.entries;
    }	

    public void setEntries(SellableInventoryItemEntryStateDto[] entries)
    {
        this.entries = entries;
    }


    public static class DtoConverter extends AbstractStateDtoConverter
    {
        public static Collection<String> collectionFieldNames = Arrays.asList(new String[]{"Entries"});

        @Override
        protected boolean isCollectionField(String fieldName) {
            return CollectionUtils.collectionContainsIgnoringCase(collectionFieldNames, fieldName);
        }

        public SellableInventoryItemStateDto[] toSellableInventoryItemStateDtoArray(Iterable<SellableInventoryItemState> states) 
        {
            ArrayList<SellableInventoryItemStateDto> stateDtos = new ArrayList();
            for (SellableInventoryItemState s : states) {
                SellableInventoryItemStateDto dto = toSellableInventoryItemStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new SellableInventoryItemStateDto[0]);
        }

        public SellableInventoryItemStateDto toSellableInventoryItemStateDto(SellableInventoryItemState state)
        {
            if(state == null) {
                return null;
            }
            SellableInventoryItemStateDto dto = new SellableInventoryItemStateDto();
            if (returnedFieldsContains("SellableInventoryItemId")) {
                dto.setSellableInventoryItemId((state.getSellableInventoryItemId() == null) ? null : new InventoryItemIdDtoWrapper(state.getSellableInventoryItemId()));
            }
            if (returnedFieldsContains("QuantitySellable")) {
                dto.setQuantitySellable(state.getQuantitySellable());
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
            if (returnedFieldsContains("Entries")) {
                ArrayList<SellableInventoryItemEntryStateDto> arrayList = new ArrayList();
                if (state.getEntries() != null) {
                    SellableInventoryItemEntryStateDto.DtoConverter conv = new SellableInventoryItemEntryStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "Entries");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (SellableInventoryItemEntryState s : state.getEntries()) {
                        arrayList.add(conv.toSellableInventoryItemEntryStateDto(s));
                    }
                }
                dto.setEntries(arrayList.toArray(new SellableInventoryItemEntryStateDto[0]));
            }
            return dto;
        }

    }
}

