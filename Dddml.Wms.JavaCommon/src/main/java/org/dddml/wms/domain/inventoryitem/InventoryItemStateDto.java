package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InventoryItemStateDto
{

    private InventoryItemIdDto inventoryItemId;

    public InventoryItemIdDto getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemIdDto inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
    }

    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand()
    {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand)
    {
        this.quantityOnHand = quantityOnHand;
    }

    private BigDecimal quantityReserved;

    public BigDecimal getQuantityReserved()
    {
        return this.quantityReserved;
    }

    public void setQuantityReserved(BigDecimal quantityReserved)
    {
        this.quantityReserved = quantityReserved;
    }

    private BigDecimal quantityOccupied;

    public BigDecimal getQuantityOccupied()
    {
        return this.quantityOccupied;
    }

    public void setQuantityOccupied(BigDecimal quantityOccupied)
    {
        this.quantityOccupied = quantityOccupied;
    }

    private BigDecimal quantityVirtual;

    public BigDecimal getQuantityVirtual()
    {
        return this.quantityVirtual;
    }

    public void setQuantityVirtual(BigDecimal quantityVirtual)
    {
        this.quantityVirtual = quantityVirtual;
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

    private InventoryItemEntryStateDto[] entries;

    public InventoryItemEntryStateDto[] getEntries()
    {
        return this.entries;
    }	

    public void setEntries(InventoryItemEntryStateDto[] entries)
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

        public InventoryItemStateDto[] toInventoryItemStateDtoArray(Iterable<InventoryItemState> states) 
        {
            ArrayList<InventoryItemStateDto> stateDtos = new ArrayList();
            for (InventoryItemState s : states) {
                InventoryItemStateDto dto = toInventoryItemStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InventoryItemStateDto[0]);
        }

        public InventoryItemStateDto toInventoryItemStateDto(InventoryItemState state)
        {
            if(state == null) {
                return null;
            }
            InventoryItemStateDto dto = new InventoryItemStateDto();
            if (returnedFieldsContains("InventoryItemId")) {
                dto.setInventoryItemId((state.getInventoryItemId() == null) ? null : new InventoryItemIdDtoWrapper(state.getInventoryItemId()));
            }
            if (returnedFieldsContains("QuantityOnHand")) {
                dto.setQuantityOnHand(state.getQuantityOnHand());
            }
            if (returnedFieldsContains("QuantityReserved")) {
                dto.setQuantityReserved(state.getQuantityReserved());
            }
            if (returnedFieldsContains("QuantityOccupied")) {
                dto.setQuantityOccupied(state.getQuantityOccupied());
            }
            if (returnedFieldsContains("QuantityVirtual")) {
                dto.setQuantityVirtual(state.getQuantityVirtual());
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
                ArrayList<InventoryItemEntryStateDto> arrayList = new ArrayList();
                if (state.getEntries() != null) {
                    InventoryItemEntryStateDto.DtoConverter conv = new InventoryItemEntryStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "Entries");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (InventoryItemEntryState s : state.getEntries()) {
                        arrayList.add(conv.toInventoryItemEntryStateDto(s));
                    }
                }
                dto.setEntries(arrayList.toArray(new InventoryItemEntryStateDto[0]));
            }
            return dto;
        }

    }
}

