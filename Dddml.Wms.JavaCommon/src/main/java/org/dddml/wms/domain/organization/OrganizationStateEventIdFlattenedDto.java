package org.dddml.wms.domain.organization;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class OrganizationStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "partyId",
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
	
    private OrganizationStateEventIdDto value;

    public OrganizationStateEventIdFlattenedDto()
    {
        this(new OrganizationStateEventIdDto());
    }

    public OrganizationStateEventIdFlattenedDto(OrganizationStateEventIdDto value)
    {
        this.value = value;
    }

    public OrganizationStateEventIdDto toOrganizationStateEventIdDto()
    {
        return this.value;
    }

    public OrganizationStateEventId toOrganizationStateEventId()
    {
        return this.value.toOrganizationStateEventId();
    }

    public String getPartyId()
    {
        return this.value.getPartyId();
    }

    public void setPartyId(String partyId)
    {
        this.value.setPartyId(partyId);
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

        OrganizationStateEventIdFlattenedDto other = (OrganizationStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

