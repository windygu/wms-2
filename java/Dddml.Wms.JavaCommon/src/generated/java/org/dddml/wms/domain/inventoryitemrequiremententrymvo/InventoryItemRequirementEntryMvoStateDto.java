package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.*;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InventoryItemRequirementEntryMvoStateDto
{

    private InventoryItemRequirementEntryId inventoryItemRequirementEntryId;

    public InventoryItemRequirementEntryId getInventoryItemRequirementEntryId()
    {
        return this.inventoryItemRequirementEntryId;
    }

    public void setInventoryItemRequirementEntryId(InventoryItemRequirementEntryId inventoryItemRequirementEntryId)
    {
        this.inventoryItemRequirementEntryId = inventoryItemRequirementEntryId;
    }

    private BigDecimal quantity;

    public BigDecimal getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    private InventoryPRTriggeredId sourceEventId;

    public InventoryPRTriggeredId getSourceEventId()
    {
        return this.sourceEventId;
    }

    public void setSourceEventId(InventoryPRTriggeredId sourceEventId)
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

    private BigDecimal inventoryItemRequirementQuantity;

    public BigDecimal getInventoryItemRequirementQuantity()
    {
        return this.inventoryItemRequirementQuantity;
    }

    public void setInventoryItemRequirementQuantity(BigDecimal inventoryItemRequirementQuantity)
    {
        this.inventoryItemRequirementQuantity = inventoryItemRequirementQuantity;
    }

    private String inventoryItemRequirementCreatedBy;

    public String getInventoryItemRequirementCreatedBy()
    {
        return this.inventoryItemRequirementCreatedBy;
    }

    public void setInventoryItemRequirementCreatedBy(String inventoryItemRequirementCreatedBy)
    {
        this.inventoryItemRequirementCreatedBy = inventoryItemRequirementCreatedBy;
    }

    private Date inventoryItemRequirementCreatedAt;

    public Date getInventoryItemRequirementCreatedAt()
    {
        return this.inventoryItemRequirementCreatedAt;
    }

    public void setInventoryItemRequirementCreatedAt(Date inventoryItemRequirementCreatedAt)
    {
        this.inventoryItemRequirementCreatedAt = inventoryItemRequirementCreatedAt;
    }

    private String inventoryItemRequirementUpdatedBy;

    public String getInventoryItemRequirementUpdatedBy()
    {
        return this.inventoryItemRequirementUpdatedBy;
    }

    public void setInventoryItemRequirementUpdatedBy(String inventoryItemRequirementUpdatedBy)
    {
        this.inventoryItemRequirementUpdatedBy = inventoryItemRequirementUpdatedBy;
    }

    private Date inventoryItemRequirementUpdatedAt;

    public Date getInventoryItemRequirementUpdatedAt()
    {
        return this.inventoryItemRequirementUpdatedAt;
    }

    public void setInventoryItemRequirementUpdatedAt(Date inventoryItemRequirementUpdatedAt)
    {
        this.inventoryItemRequirementUpdatedAt = inventoryItemRequirementUpdatedAt;
    }

    private Long inventoryItemRequirementVersion;

    public Long getInventoryItemRequirementVersion()
    {
        return this.inventoryItemRequirementVersion;
    }

    public void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion)
    {
        this.inventoryItemRequirementVersion = inventoryItemRequirementVersion;
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

        public InventoryItemRequirementEntryMvoStateDto[] toInventoryItemRequirementEntryMvoStateDtoArray(Iterable<InventoryItemRequirementEntryMvoState> states) 
        {
            ArrayList<InventoryItemRequirementEntryMvoStateDto> stateDtos = new ArrayList();
            for (InventoryItemRequirementEntryMvoState s : states) {
                InventoryItemRequirementEntryMvoStateDto dto = toInventoryItemRequirementEntryMvoStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InventoryItemRequirementEntryMvoStateDto[0]);
        }

        public InventoryItemRequirementEntryMvoStateDto toInventoryItemRequirementEntryMvoStateDto(InventoryItemRequirementEntryMvoState state)
        {
            if(state == null) {
                return null;
            }
            InventoryItemRequirementEntryMvoStateDto dto = new InventoryItemRequirementEntryMvoStateDto();
            if (returnedFieldsContains("InventoryItemRequirementEntryId")) {
                dto.setInventoryItemRequirementEntryId(state.getInventoryItemRequirementEntryId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
            }
            if (returnedFieldsContains("SourceEventId")) {
                dto.setSourceEventId(state.getSourceEventId());
            }
            if (returnedFieldsContains("Version")) {
                dto.setVersion(state.getVersion());
            }
            if (returnedFieldsContains("InventoryItemRequirementQuantity")) {
                dto.setInventoryItemRequirementQuantity(state.getInventoryItemRequirementQuantity());
            }
            if (returnedFieldsContains("InventoryItemRequirementCreatedBy")) {
                dto.setInventoryItemRequirementCreatedBy(state.getInventoryItemRequirementCreatedBy());
            }
            if (returnedFieldsContains("InventoryItemRequirementCreatedAt")) {
                dto.setInventoryItemRequirementCreatedAt(state.getInventoryItemRequirementCreatedAt());
            }
            if (returnedFieldsContains("InventoryItemRequirementUpdatedBy")) {
                dto.setInventoryItemRequirementUpdatedBy(state.getInventoryItemRequirementUpdatedBy());
            }
            if (returnedFieldsContains("InventoryItemRequirementUpdatedAt")) {
                dto.setInventoryItemRequirementUpdatedAt(state.getInventoryItemRequirementUpdatedAt());
            }
            if (returnedFieldsContains("InventoryItemRequirementVersion")) {
                dto.setInventoryItemRequirementVersion(state.getInventoryItemRequirementVersion());
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

