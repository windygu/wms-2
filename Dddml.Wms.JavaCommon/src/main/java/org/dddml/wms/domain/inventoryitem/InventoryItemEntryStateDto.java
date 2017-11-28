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

    private BigDecimal quantityOnHandVar;

    public BigDecimal getQuantityOnHandVar()
    {
        return this.quantityOnHandVar;
    }

    public void setQuantityOnHandVar(BigDecimal quantityOnHandVar)
    {
        this.quantityOnHandVar = quantityOnHandVar;
    }

    private BigDecimal quantityReservedVar;

    public BigDecimal getQuantityReservedVar()
    {
        return this.quantityReservedVar;
    }

    public void setQuantityReservedVar(BigDecimal quantityReservedVar)
    {
        this.quantityReservedVar = quantityReservedVar;
    }

    private BigDecimal quantityOccupiedVar;

    public BigDecimal getQuantityOccupiedVar()
    {
        return this.quantityOccupiedVar;
    }

    public void setQuantityOccupiedVar(BigDecimal quantityOccupiedVar)
    {
        this.quantityOccupiedVar = quantityOccupiedVar;
    }

    private BigDecimal quantityVirtualVar;

    public BigDecimal getQuantityVirtualVar()
    {
        return this.quantityVirtualVar;
    }

    public void setQuantityVirtualVar(BigDecimal quantityVirtualVar)
    {
        this.quantityVirtualVar = quantityVirtualVar;
    }

    private InventoryItemEventVODto eventVO;

    public InventoryItemEventVODto getEventVO()
    {
        return this.eventVO;
    }

    public void setEventVO(InventoryItemEventVODto eventVO)
    {
        this.eventVO = eventVO;
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
            if (returnedFieldsContains("QuantityOnHandVar")) {
                dto.setQuantityOnHandVar(state.getQuantityOnHandVar());
            }
            if (returnedFieldsContains("QuantityReservedVar")) {
                dto.setQuantityReservedVar(state.getQuantityReservedVar());
            }
            if (returnedFieldsContains("QuantityOccupiedVar")) {
                dto.setQuantityOccupiedVar(state.getQuantityOccupiedVar());
            }
            if (returnedFieldsContains("QuantityVirtualVar")) {
                dto.setQuantityVirtualVar(state.getQuantityVirtualVar());
            }
            if (returnedFieldsContains("EventVO")) {
                dto.setEventVO((state.getEventVO() == null) ? null : new InventoryItemEventVODtoWrapper(state.getEventVO()));
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
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

