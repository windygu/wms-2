package org.dddml.wms.domain.inventorypostingrule;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryPostingRuleStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryPostingRuleId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private InventoryPostingRuleStateEventIdDto value;

    public InventoryPostingRuleStateEventIdFlattenedDto()
    {
        this(new InventoryPostingRuleStateEventIdDto());
    }

    public InventoryPostingRuleStateEventIdFlattenedDto(InventoryPostingRuleStateEventIdDto value)
    {
        this.value = value;
    }

    public InventoryPostingRuleStateEventIdDto toInventoryPostingRuleStateEventIdDto()
    {
        return this.value;
    }

    public InventoryPostingRuleStateEventId toInventoryPostingRuleStateEventId()
    {
        return this.value.toInventoryPostingRuleStateEventId();
    }

    public String getInventoryPostingRuleId()
    {
        return this.value.getInventoryPostingRuleId();
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.value.setInventoryPostingRuleId(inventoryPostingRuleId);
    }

    public Long getVersion()
    {
        return this.value.getVersion();
    }

    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        InventoryPostingRuleStateEventIdFlattenedDto other = (InventoryPostingRuleStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

