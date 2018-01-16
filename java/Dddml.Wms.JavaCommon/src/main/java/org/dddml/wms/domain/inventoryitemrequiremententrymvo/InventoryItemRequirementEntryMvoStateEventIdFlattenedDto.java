package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import org.dddml.wms.domain.inventoryitemrequirement.InventoryItemRequirementEntryIdDto;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryItemRequirementEntryMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId",
            "inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId",
            "inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId",
            "inventoryItemRequirementEntryIdEntrySeqId",
            "inventoryItemRequirementVersion",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "String",
            "Long",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private InventoryItemRequirementEntryMvoStateEventIdDto value;

    public InventoryItemRequirementEntryMvoStateEventIdFlattenedDto()
    {
        this(new InventoryItemRequirementEntryMvoStateEventIdDto());
    }

    public InventoryItemRequirementEntryMvoStateEventIdFlattenedDto(InventoryItemRequirementEntryMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public InventoryItemRequirementEntryMvoStateEventIdDto toInventoryItemRequirementEntryMvoStateEventIdDto()
    {
        return this.value;
    }

    public InventoryItemRequirementEntryMvoStateEventId toInventoryItemRequirementEntryMvoStateEventId()
    {
        return this.value.toInventoryItemRequirementEntryMvoStateEventId();
    }

    public String getInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId()
    {
        return this.value.getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getProductId();
    }

    public void setInventoryItemRequirementEntryIdInventoryItemRequirementIdProductId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId)
    {
        this.value.getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setProductId(inventoryItemRequirementEntryIdInventoryItemRequirementIdProductId);
    }

    public String getInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId()
    {
        return this.value.getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getLocatorId();
    }

    public void setInventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId)
    {
        this.value.getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setLocatorId(inventoryItemRequirementEntryIdInventoryItemRequirementIdLocatorId);
    }

    public String getInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId()
    {
        return this.value.getInventoryItemRequirementEntryId().getInventoryItemRequirementId().getAttributeSetInstanceId();
    }

    public void setInventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId(String inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId)
    {
        this.value.getInventoryItemRequirementEntryId().getInventoryItemRequirementId().setAttributeSetInstanceId(inventoryItemRequirementEntryIdInventoryItemRequirementIdAttributeSetInstanceId);
    }

    public Long getInventoryItemRequirementEntryIdEntrySeqId()
    {
        return this.value.getInventoryItemRequirementEntryId().getEntrySeqId();
    }

    public void setInventoryItemRequirementEntryIdEntrySeqId(Long inventoryItemRequirementEntryIdEntrySeqId)
    {
        this.value.getInventoryItemRequirementEntryId().setEntrySeqId(inventoryItemRequirementEntryIdEntrySeqId);
    }

    public Long getInventoryItemRequirementVersion()
    {
        return this.value.getInventoryItemRequirementVersion();
    }

    public void setInventoryItemRequirementVersion(Long inventoryItemRequirementVersion)
    {
        this.value.setInventoryItemRequirementVersion(inventoryItemRequirementVersion);
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

        InventoryItemRequirementEntryMvoStateEventIdFlattenedDto other = (InventoryItemRequirementEntryMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

