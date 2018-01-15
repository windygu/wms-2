package org.dddml.wms.domain.inventoryprtriggered;

import org.dddml.wms.domain.inventoryitem.InventoryItemEntryIdDto;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryPRTriggeredIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "sourceEntryIdInventoryItemIdProductId",
            "sourceEntryIdInventoryItemIdLocatorId",
            "sourceEntryIdInventoryItemIdAttributeSetInstanceId",
            "sourceEntryIdEntrySeqId",
            "inventoryPostingRuleId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "Long",
            "String",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private InventoryPRTriggeredIdDto value;

    public InventoryPRTriggeredIdFlattenedDto()
    {
        this(new InventoryPRTriggeredIdDto());
    }

    public InventoryPRTriggeredIdFlattenedDto(InventoryPRTriggeredIdDto value)
    {
        this.value = value;
    }

    public InventoryPRTriggeredIdDto toInventoryPRTriggeredIdDto()
    {
        return this.value;
    }

    public InventoryPRTriggeredId toInventoryPRTriggeredId()
    {
        return this.value.toInventoryPRTriggeredId();
    }

    public String getSourceEntryIdInventoryItemIdProductId()
    {
        return this.value.getSourceEntryId().getInventoryItemId().getProductId();
    }

    public void setSourceEntryIdInventoryItemIdProductId(String sourceEntryIdInventoryItemIdProductId)
    {
        this.value.getSourceEntryId().getInventoryItemId().setProductId(sourceEntryIdInventoryItemIdProductId);
    }

    public String getSourceEntryIdInventoryItemIdLocatorId()
    {
        return this.value.getSourceEntryId().getInventoryItemId().getLocatorId();
    }

    public void setSourceEntryIdInventoryItemIdLocatorId(String sourceEntryIdInventoryItemIdLocatorId)
    {
        this.value.getSourceEntryId().getInventoryItemId().setLocatorId(sourceEntryIdInventoryItemIdLocatorId);
    }

    public String getSourceEntryIdInventoryItemIdAttributeSetInstanceId()
    {
        return this.value.getSourceEntryId().getInventoryItemId().getAttributeSetInstanceId();
    }

    public void setSourceEntryIdInventoryItemIdAttributeSetInstanceId(String sourceEntryIdInventoryItemIdAttributeSetInstanceId)
    {
        this.value.getSourceEntryId().getInventoryItemId().setAttributeSetInstanceId(sourceEntryIdInventoryItemIdAttributeSetInstanceId);
    }

    public Long getSourceEntryIdEntrySeqId()
    {
        return this.value.getSourceEntryId().getEntrySeqId();
    }

    public void setSourceEntryIdEntrySeqId(Long sourceEntryIdEntrySeqId)
    {
        this.value.getSourceEntryId().setEntrySeqId(sourceEntryIdEntrySeqId);
    }

    public String getInventoryPostingRuleId()
    {
        return this.value.getInventoryPostingRuleId();
    }

    public void setInventoryPostingRuleId(String inventoryPostingRuleId)
    {
        this.value.setInventoryPostingRuleId(inventoryPostingRuleId);
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

        InventoryPRTriggeredIdFlattenedDto other = (InventoryPRTriggeredIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

