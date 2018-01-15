package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryPRTriggeredStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId",
            "inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId",
            "inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId",
            "inventoryPRTriggeredIdSourceEntryIdEntrySeqId",
            "inventoryPRTriggeredIdInventoryPostingRuleId",
            "version",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "Long",
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
	
    private InventoryPRTriggeredStateEventIdDto value;

    public InventoryPRTriggeredStateEventIdFlattenedDto()
    {
        this(new InventoryPRTriggeredStateEventIdDto());
    }

    public InventoryPRTriggeredStateEventIdFlattenedDto(InventoryPRTriggeredStateEventIdDto value)
    {
        this.value = value;
    }

    public InventoryPRTriggeredStateEventIdDto toInventoryPRTriggeredStateEventIdDto()
    {
        return this.value;
    }

    public InventoryPRTriggeredStateEventId toInventoryPRTriggeredStateEventId()
    {
        return this.value.toInventoryPRTriggeredStateEventId();
    }

    public String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId()
    {
        return this.value.getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getProductId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId)
    {
        this.value.getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setProductId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdProductId);
    }

    public String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId()
    {
        return this.value.getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getLocatorId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId)
    {
        this.value.getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setLocatorId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdLocatorId);
    }

    public String getInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId()
    {
        return this.value.getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId(String inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId)
    {
        this.value.getInventoryPRTriggeredId().getSourceEntryId().getInventoryItemId().setAttributeSetInstanceId(inventoryPRTriggeredIdSourceEntryIdInventoryItemIdAttributeSetInstanceId);
    }

    public Long getInventoryPRTriggeredIdSourceEntryIdEntrySeqId()
    {
        return this.value.getInventoryPRTriggeredId().getSourceEntryId().getEntrySeqId();
    }

    public void setInventoryPRTriggeredIdSourceEntryIdEntrySeqId(Long inventoryPRTriggeredIdSourceEntryIdEntrySeqId)
    {
        this.value.getInventoryPRTriggeredId().getSourceEntryId().setEntrySeqId(inventoryPRTriggeredIdSourceEntryIdEntrySeqId);
    }

    public String getInventoryPRTriggeredIdInventoryPostingRuleId()
    {
        return this.value.getInventoryPRTriggeredId().getInventoryPostingRuleId();
    }

    public void setInventoryPRTriggeredIdInventoryPostingRuleId(String inventoryPRTriggeredIdInventoryPostingRuleId)
    {
        this.value.getInventoryPRTriggeredId().setInventoryPostingRuleId(inventoryPRTriggeredIdInventoryPostingRuleId);
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

        InventoryPRTriggeredStateEventIdFlattenedDto other = (InventoryPRTriggeredStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

