package org.dddml.wms.domain.inventoryitem;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InventoryItemEntryStateDto
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

    private BigDecimal quantityOnHand;

    public BigDecimal getQuantityOnHand()
    {
        return this.quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand)
    {
        this.quantityOnHand = quantityOnHand;
    }

    private BigDecimal quantityInTransit;

    public BigDecimal getQuantityInTransit()
    {
        return this.quantityInTransit;
    }

    public void setQuantityInTransit(BigDecimal quantityInTransit)
    {
        this.quantityInTransit = quantityInTransit;
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

    private InventoryItemSourceVODto source;

    public InventoryItemSourceVODto getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceVODto source)
    {
        this.source = source;
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

    private InventoryItemIdDto inventoryItemId;

    public InventoryItemIdDto getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemIdDto inventoryItemId)
    {
        this.inventoryItemId = inventoryItemId;
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

        public InventoryItemEntryStateDto[] toInventoryItemEntryStateDtoArray(Iterable<InventoryItemEntryState> states) 
        {
            ArrayList<InventoryItemEntryStateDto> stateDtos = new ArrayList();
            for (InventoryItemEntryState s : states) {
                InventoryItemEntryStateDto dto = toInventoryItemEntryStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InventoryItemEntryStateDto[0]);
        }

        public InventoryItemEntryStateDto toInventoryItemEntryStateDto(InventoryItemEntryState state)
        {
            if(state == null) {
                return null;
            }
            InventoryItemEntryStateDto dto = new InventoryItemEntryStateDto();
            if (returnedFieldsContains("EntrySeqId")) {
                dto.setEntrySeqId(state.getEntrySeqId());
            }
            if (returnedFieldsContains("QuantityOnHand")) {
                dto.setQuantityOnHand(state.getQuantityOnHand());
            }
            if (returnedFieldsContains("QuantityInTransit")) {
                dto.setQuantityInTransit(state.getQuantityInTransit());
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
            if (returnedFieldsContains("Source")) {
                dto.setSource((state.getSource() == null) ? null : new InventoryItemSourceVODtoWrapper(state.getSource()));
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("InventoryItemId")) {
                dto.setInventoryItemId((state.getInventoryItemId() == null) ? null : new InventoryItemIdDtoWrapper(state.getInventoryItemId()));
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

