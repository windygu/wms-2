package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class InventoryPostingRuleStateDto
{

    private String inventoryPostingRuleId;

    public String getInventoryPostingRuleId()
    {
        return this.inventoryPostingRuleId;
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.inventoryPostingRuleId = inventoryPostingRuleId;
    }

    private InventoryItemIdDto trigger;

    public InventoryItemIdDto getTrigger()
    {
        return this.trigger;
    }

    public void setTrigger(InventoryItemIdDto trigger)
    {
        this.trigger = trigger;
    }

    private InventoryItemIdDto output;

    public InventoryItemIdDto getOutput()
    {
        return this.output;
    }

    public void setOutput(InventoryItemIdDto output)
    {
        this.output = output;
    }

    private String accountName;

    public String getAccountName()
    {
        return this.accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    private Boolean isOutputNegated;

    public Boolean getIsOutputNegated()
    {
        return this.isOutputNegated;
    }

    public void setIsOutputNegated(Boolean isOutputNegated)
    {
        this.isOutputNegated = isOutputNegated;
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

        public InventoryPostingRuleStateDto[] toInventoryPostingRuleStateDtoArray(Iterable<InventoryPostingRuleState> states) 
        {
            ArrayList<InventoryPostingRuleStateDto> stateDtos = new ArrayList();
            for (InventoryPostingRuleState s : states) {
                InventoryPostingRuleStateDto dto = toInventoryPostingRuleStateDto(s);
                stateDtos.add(dto);
            }
            return stateDtos.toArray(new InventoryPostingRuleStateDto[0]);
        }

        public InventoryPostingRuleStateDto toInventoryPostingRuleStateDto(InventoryPostingRuleState state)
        {
            if(state == null) {
                return null;
            }
            InventoryPostingRuleStateDto dto = new InventoryPostingRuleStateDto();
            if (returnedFieldsContains("InventoryPostingRuleId")) {
                dto.setInventoryPostingRuleId(state.getInventoryPostingRuleId());
            }
            if (returnedFieldsContains("Trigger")) {
                dto.setTrigger((state.getTrigger() == null) ? null : new InventoryItemIdDtoWrapper(state.getTrigger()));
            }
            if (returnedFieldsContains("Output")) {
                dto.setOutput((state.getOutput() == null) ? null : new InventoryItemIdDtoWrapper(state.getOutput()));
            }
            if (returnedFieldsContains("AccountName")) {
                dto.setAccountName(state.getAccountName());
            }
            if (returnedFieldsContains("IsOutputNegated")) {
                dto.setIsOutputNegated(state.getIsOutputNegated());
            }
            if (returnedFieldsContains("Active")) {
                dto.setActive(state.getActive());
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
            return dto;
        }

    }
}

