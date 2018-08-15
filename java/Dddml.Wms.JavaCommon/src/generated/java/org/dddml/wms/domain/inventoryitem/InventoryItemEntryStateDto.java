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

    private BigDecimal onHandQuantity;

    public BigDecimal getOnHandQuantity()
    {
        return this.onHandQuantity;
    }

    public void setOnHandQuantity(BigDecimal onHandQuantity)
    {
        this.onHandQuantity = onHandQuantity;
    }

    private BigDecimal inTransitQuantity;

    public BigDecimal getInTransitQuantity()
    {
        return this.inTransitQuantity;
    }

    public void setInTransitQuantity(BigDecimal inTransitQuantity)
    {
        this.inTransitQuantity = inTransitQuantity;
    }

    private BigDecimal reservedQuantity;

    public BigDecimal getReservedQuantity()
    {
        return this.reservedQuantity;
    }

    public void setReservedQuantity(BigDecimal reservedQuantity)
    {
        this.reservedQuantity = reservedQuantity;
    }

    private BigDecimal occupiedQuantity;

    public BigDecimal getOccupiedQuantity()
    {
        return this.occupiedQuantity;
    }

    public void setOccupiedQuantity(BigDecimal occupiedQuantity)
    {
        this.occupiedQuantity = occupiedQuantity;
    }

    private BigDecimal virtualQuantity;

    public BigDecimal getVirtualQuantity()
    {
        return this.virtualQuantity;
    }

    public void setVirtualQuantity(BigDecimal virtualQuantity)
    {
        this.virtualQuantity = virtualQuantity;
    }

    private InventoryItemSourceInfo source;

    public InventoryItemSourceInfo getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceInfo source)
    {
        this.source = source;
    }

    private java.sql.Timestamp occurredAt;

    public java.sql.Timestamp getOccurredAt()
    {
        return this.occurredAt;
    }

    public void setOccurredAt(java.sql.Timestamp occurredAt)
    {
        this.occurredAt = occurredAt;
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

    private InventoryItemId inventoryItemId;

    public InventoryItemId getInventoryItemId()
    {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemId inventoryItemId)
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

        public InventoryItemEntryStateDto[] toInventoryItemEntryStateDtoArray(Iterable<InventoryItemEntryState> states) {
            return toInventoryItemEntryStateDtoList(states).toArray(new InventoryItemEntryStateDto[0]);
        }

        public List<InventoryItemEntryStateDto> toInventoryItemEntryStateDtoList(Iterable<InventoryItemEntryState> states) {
            ArrayList<InventoryItemEntryStateDto> stateDtos = new ArrayList();
            for (InventoryItemEntryState s : states) {
                InventoryItemEntryStateDto dto = toInventoryItemEntryStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
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
            if (returnedFieldsContains("OnHandQuantity")) {
                dto.setOnHandQuantity(state.getOnHandQuantity());
            }
            if (returnedFieldsContains("InTransitQuantity")) {
                dto.setInTransitQuantity(state.getInTransitQuantity());
            }
            if (returnedFieldsContains("ReservedQuantity")) {
                dto.setReservedQuantity(state.getReservedQuantity());
            }
            if (returnedFieldsContains("OccupiedQuantity")) {
                dto.setOccupiedQuantity(state.getOccupiedQuantity());
            }
            if (returnedFieldsContains("VirtualQuantity")) {
                dto.setVirtualQuantity(state.getVirtualQuantity());
            }
            if (returnedFieldsContains("Source")) {
                dto.setSource(state.getSource());
            }
            if (returnedFieldsContains("OccurredAt")) {
                dto.setOccurredAt(state.getOccurredAt());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("InventoryItemId")) {
                dto.setInventoryItemId(state.getInventoryItemId());
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

