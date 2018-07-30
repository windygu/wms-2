package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InventoryItemRequirementStateDto
{

    private InventoryItemId inventoryItemRequirementId;

    public InventoryItemId getInventoryItemRequirementId()
    {
        return this.inventoryItemRequirementId;
    }

    public void setInventoryItemRequirementId(InventoryItemId inventoryItemRequirementId)
    {
        this.inventoryItemRequirementId = inventoryItemRequirementId;
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

    private InventoryItemRequirementEntryStateDto[] entries;

    public InventoryItemRequirementEntryStateDto[] getEntries()
    {
        return this.entries;
    }	

    public void setEntries(InventoryItemRequirementEntryStateDto[] entries)
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

        public InventoryItemRequirementStateDto[] toInventoryItemRequirementStateDtoArray(Iterable<InventoryItemRequirementState> states) {
            return toInventoryItemRequirementStateDtoList(states).toArray(new InventoryItemRequirementStateDto[0]);
        }

        public List<InventoryItemRequirementStateDto> toInventoryItemRequirementStateDtoList(Iterable<InventoryItemRequirementState> states) {
            ArrayList<InventoryItemRequirementStateDto> stateDtos = new ArrayList();
            for (InventoryItemRequirementState s : states) {
                InventoryItemRequirementStateDto dto = toInventoryItemRequirementStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos;
        }

        public InventoryItemRequirementStateDto toInventoryItemRequirementStateDto(InventoryItemRequirementState state)
        {
            if(state == null) {
                return null;
            }
            InventoryItemRequirementStateDto dto = new InventoryItemRequirementStateDto();
            if (returnedFieldsContains("InventoryItemRequirementId")) {
                dto.setInventoryItemRequirementId(state.getInventoryItemRequirementId());
            }
            if (returnedFieldsContains("Quantity")) {
                dto.setQuantity(state.getQuantity());
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
                ArrayList<InventoryItemRequirementEntryStateDto> arrayList = new ArrayList();
                if (state.getEntries() != null) {
                    InventoryItemRequirementEntryStateDto.DtoConverter conv = new InventoryItemRequirementEntryStateDto.DtoConverter();
                    String returnFS = CollectionUtils.mapGetValueIgnoringCase(getReturnedFields(), "Entries");
                    if(returnFS != null) { conv.setReturnedFieldsString(returnFS); } else { conv.setAllFieldsReturned(this.getAllFieldsReturned()); }
                    for (InventoryItemRequirementEntryState s : state.getEntries()) {
                        arrayList.add(conv.toInventoryItemRequirementEntryStateDto(s));
                    }
                }
                dto.setEntries(arrayList.toArray(new InventoryItemRequirementEntryStateDto[0]));
            }
            return dto;
        }

    }
}

