package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InventoryItemEntryMvoStateDto
{

    private InventoryItemEntryIdDto inventoryItemEntryId;

    public InventoryItemEntryIdDto getInventoryItemEntryId()
    {
        return this.inventoryItemEntryId;
    }

    public void setInventoryItemEntryId(InventoryItemEntryIdDto inventoryItemEntryId)
    {
        this.inventoryItemEntryId = inventoryItemEntryId;
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

    private InventoryItemSourceInfoDto source;

    public InventoryItemSourceInfoDto getSource()
    {
        return this.source;
    }

    public void setSource(InventoryItemSourceInfoDto source)
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

    private BigDecimal inventoryItemOnHandQuantity;

    public BigDecimal getInventoryItemOnHandQuantity()
    {
        return this.inventoryItemOnHandQuantity;
    }

    public void setInventoryItemOnHandQuantity(BigDecimal inventoryItemOnHandQuantity)
    {
        this.inventoryItemOnHandQuantity = inventoryItemOnHandQuantity;
    }

    private BigDecimal inventoryItemInTransitQuantity;

    public BigDecimal getInventoryItemInTransitQuantity()
    {
        return this.inventoryItemInTransitQuantity;
    }

    public void setInventoryItemInTransitQuantity(BigDecimal inventoryItemInTransitQuantity)
    {
        this.inventoryItemInTransitQuantity = inventoryItemInTransitQuantity;
    }

    private BigDecimal inventoryItemReservedQuantity;

    public BigDecimal getInventoryItemReservedQuantity()
    {
        return this.inventoryItemReservedQuantity;
    }

    public void setInventoryItemReservedQuantity(BigDecimal inventoryItemReservedQuantity)
    {
        this.inventoryItemReservedQuantity = inventoryItemReservedQuantity;
    }

    private BigDecimal inventoryItemOccupiedQuantity;

    public BigDecimal getInventoryItemOccupiedQuantity()
    {
        return this.inventoryItemOccupiedQuantity;
    }

    public void setInventoryItemOccupiedQuantity(BigDecimal inventoryItemOccupiedQuantity)
    {
        this.inventoryItemOccupiedQuantity = inventoryItemOccupiedQuantity;
    }

    private BigDecimal inventoryItemVirtualQuantity;

    public BigDecimal getInventoryItemVirtualQuantity()
    {
        return this.inventoryItemVirtualQuantity;
    }

    public void setInventoryItemVirtualQuantity(BigDecimal inventoryItemVirtualQuantity)
    {
        this.inventoryItemVirtualQuantity = inventoryItemVirtualQuantity;
    }

    private String inventoryItemCreatedBy;

    public String getInventoryItemCreatedBy()
    {
        return this.inventoryItemCreatedBy;
    }

    public void setInventoryItemCreatedBy(String inventoryItemCreatedBy)
    {
        this.inventoryItemCreatedBy = inventoryItemCreatedBy;
    }

    private Date inventoryItemCreatedAt;

    public Date getInventoryItemCreatedAt()
    {
        return this.inventoryItemCreatedAt;
    }

    public void setInventoryItemCreatedAt(Date inventoryItemCreatedAt)
    {
        this.inventoryItemCreatedAt = inventoryItemCreatedAt;
    }

    private String inventoryItemUpdatedBy;

    public String getInventoryItemUpdatedBy()
    {
        return this.inventoryItemUpdatedBy;
    }

    public void setInventoryItemUpdatedBy(String inventoryItemUpdatedBy)
    {
        this.inventoryItemUpdatedBy = inventoryItemUpdatedBy;
    }

    private Date inventoryItemUpdatedAt;

    public Date getInventoryItemUpdatedAt()
    {
        return this.inventoryItemUpdatedAt;
    }

    public void setInventoryItemUpdatedAt(Date inventoryItemUpdatedAt)
    {
        this.inventoryItemUpdatedAt = inventoryItemUpdatedAt;
    }

    private Long inventoryItemVersion;

    public Long getInventoryItemVersion()
    {
        return this.inventoryItemVersion;
    }

    public void setInventoryItemVersion(Long inventoryItemVersion)
    {
        this.inventoryItemVersion = inventoryItemVersion;
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

        public InventoryItemEntryMvoStateDto[] toInventoryItemEntryMvoStateDtoArray(Iterable<InventoryItemEntryMvoState> states) 
        {
            ArrayList<InventoryItemEntryMvoStateDto> stateDtos = new ArrayList();
            for (InventoryItemEntryMvoState s : states) {
                InventoryItemEntryMvoStateDto dto = toInventoryItemEntryMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InventoryItemEntryMvoStateDto[0]);
        }

        public InventoryItemEntryMvoStateDto toInventoryItemEntryMvoStateDto(InventoryItemEntryMvoState state)
        {
            if(state == null) {
                return null;
            }
            InventoryItemEntryMvoStateDto dto = new InventoryItemEntryMvoStateDto();
            if (returnedFieldsContains("InventoryItemEntryId")) {
                dto.setInventoryItemEntryId((state.getInventoryItemEntryId() == null) ? null : new InventoryItemEntryIdDtoWrapper(state.getInventoryItemEntryId()));
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
                dto.setSource((state.getSource() == null) ? null : new InventoryItemSourceInfoDtoWrapper(state.getSource()));
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("InventoryItemOnHandQuantity")) {
                dto.setInventoryItemOnHandQuantity(state.getInventoryItemOnHandQuantity());
            }
            if (returnedFieldsContains("InventoryItemInTransitQuantity")) {
                dto.setInventoryItemInTransitQuantity(state.getInventoryItemInTransitQuantity());
            }
            if (returnedFieldsContains("InventoryItemReservedQuantity")) {
                dto.setInventoryItemReservedQuantity(state.getInventoryItemReservedQuantity());
            }
            if (returnedFieldsContains("InventoryItemOccupiedQuantity")) {
                dto.setInventoryItemOccupiedQuantity(state.getInventoryItemOccupiedQuantity());
            }
            if (returnedFieldsContains("InventoryItemVirtualQuantity")) {
                dto.setInventoryItemVirtualQuantity(state.getInventoryItemVirtualQuantity());
            }
            if (returnedFieldsContains("InventoryItemCreatedBy")) {
                dto.setInventoryItemCreatedBy(state.getInventoryItemCreatedBy());
            }
            if (returnedFieldsContains("InventoryItemCreatedAt")) {
                dto.setInventoryItemCreatedAt(state.getInventoryItemCreatedAt());
            }
            if (returnedFieldsContains("InventoryItemUpdatedBy")) {
                dto.setInventoryItemUpdatedBy(state.getInventoryItemUpdatedBy());
            }
            if (returnedFieldsContains("InventoryItemUpdatedAt")) {
                dto.setInventoryItemUpdatedAt(state.getInventoryItemUpdatedAt());
            }
            if (returnedFieldsContains("InventoryItemVersion")) {
                dto.setInventoryItemVersion(state.getInventoryItemVersion());
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

