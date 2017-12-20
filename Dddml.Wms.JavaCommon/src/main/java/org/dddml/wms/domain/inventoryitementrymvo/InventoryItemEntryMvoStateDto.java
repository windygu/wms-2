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

    private BigDecimal inventoryItemQuantityOnHand;

    public BigDecimal getInventoryItemQuantityOnHand()
    {
        return this.inventoryItemQuantityOnHand;
    }

    public void setInventoryItemQuantityOnHand(BigDecimal inventoryItemQuantityOnHand)
    {
        this.inventoryItemQuantityOnHand = inventoryItemQuantityOnHand;
    }

    private BigDecimal inventoryItemQuantityInTransit;

    public BigDecimal getInventoryItemQuantityInTransit()
    {
        return this.inventoryItemQuantityInTransit;
    }

    public void setInventoryItemQuantityInTransit(BigDecimal inventoryItemQuantityInTransit)
    {
        this.inventoryItemQuantityInTransit = inventoryItemQuantityInTransit;
    }

    private BigDecimal inventoryItemQuantityReserved;

    public BigDecimal getInventoryItemQuantityReserved()
    {
        return this.inventoryItemQuantityReserved;
    }

    public void setInventoryItemQuantityReserved(BigDecimal inventoryItemQuantityReserved)
    {
        this.inventoryItemQuantityReserved = inventoryItemQuantityReserved;
    }

    private BigDecimal inventoryItemQuantityOccupied;

    public BigDecimal getInventoryItemQuantityOccupied()
    {
        return this.inventoryItemQuantityOccupied;
    }

    public void setInventoryItemQuantityOccupied(BigDecimal inventoryItemQuantityOccupied)
    {
        this.inventoryItemQuantityOccupied = inventoryItemQuantityOccupied;
    }

    private BigDecimal inventoryItemQuantityVirtual;

    public BigDecimal getInventoryItemQuantityVirtual()
    {
        return this.inventoryItemQuantityVirtual;
    }

    public void setInventoryItemQuantityVirtual(BigDecimal inventoryItemQuantityVirtual)
    {
        this.inventoryItemQuantityVirtual = inventoryItemQuantityVirtual;
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
                dto.setSource((state.getSource() == null) ? null : new InventoryItemSourceInfoDtoWrapper(state.getSource()));
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("InventoryItemQuantityOnHand")) {
                dto.setInventoryItemQuantityOnHand(state.getInventoryItemQuantityOnHand());
            }
            if (returnedFieldsContains("InventoryItemQuantityInTransit")) {
                dto.setInventoryItemQuantityInTransit(state.getInventoryItemQuantityInTransit());
            }
            if (returnedFieldsContains("InventoryItemQuantityReserved")) {
                dto.setInventoryItemQuantityReserved(state.getInventoryItemQuantityReserved());
            }
            if (returnedFieldsContains("InventoryItemQuantityOccupied")) {
                dto.setInventoryItemQuantityOccupied(state.getInventoryItemQuantityOccupied());
            }
            if (returnedFieldsContains("InventoryItemQuantityVirtual")) {
                dto.setInventoryItemQuantityVirtual(state.getInventoryItemQuantityVirtual());
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

