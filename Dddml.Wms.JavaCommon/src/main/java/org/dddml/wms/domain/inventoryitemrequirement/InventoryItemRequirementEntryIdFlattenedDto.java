package org.dddml.wms.domain.inventoryitemrequirement;

import org.dddml.wms.domain.inventoryitem.InventoryItemIdDto;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemRequirementEntryIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryItemRequirementIdProductId",
            "inventoryItemRequirementIdLocatorId",
            "inventoryItemRequirementIdAttributeSetInstanceId",
            "entrySeqId",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
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
	
    private InventoryItemRequirementEntryIdDto value;

    public InventoryItemRequirementEntryIdFlattenedDto()
    {
        this(new InventoryItemRequirementEntryIdDto());
    }

    public InventoryItemRequirementEntryIdFlattenedDto(InventoryItemRequirementEntryIdDto value)
    {
        this.value = value;
    }

    public InventoryItemRequirementEntryIdDto toInventoryItemRequirementEntryIdDto()
    {
        return this.value;
    }

    public InventoryItemRequirementEntryId toInventoryItemRequirementEntryId()
    {
        return this.value.toInventoryItemRequirementEntryId();
    }

    public String getInventoryItemRequirementIdProductId()
    {
        return this.value.getInventoryItemRequirementId().getProductId();
    }

    public void setInventoryItemRequirementIdProductId(String inventoryItemRequirementIdProductId)
    {
        this.value.getInventoryItemRequirementId().setProductId(inventoryItemRequirementIdProductId);
    }

    public String getInventoryItemRequirementIdLocatorId()
    {
        return this.value.getInventoryItemRequirementId().getLocatorId();
    }

    public void setInventoryItemRequirementIdLocatorId(String inventoryItemRequirementIdLocatorId)
    {
        this.value.getInventoryItemRequirementId().setLocatorId(inventoryItemRequirementIdLocatorId);
    }

    public String getInventoryItemRequirementIdAttributeSetInstanceId()
    {
        return this.value.getInventoryItemRequirementId().getAttributeSetInstanceId();
    }

    public void setInventoryItemRequirementIdAttributeSetInstanceId(String inventoryItemRequirementIdAttributeSetInstanceId)
    {
        this.value.getInventoryItemRequirementId().setAttributeSetInstanceId(inventoryItemRequirementIdAttributeSetInstanceId);
    }

    public Long getEntrySeqId()
    {
        return this.value.getEntrySeqId();
    }

    public void setEntrySeqId(Long entrySeqId)
    {
        this.value.setEntrySeqId(entrySeqId);
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

        InventoryItemRequirementEntryIdFlattenedDto other = (InventoryItemRequirementEntryIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

