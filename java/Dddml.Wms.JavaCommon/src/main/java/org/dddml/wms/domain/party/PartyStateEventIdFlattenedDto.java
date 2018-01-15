package org.dddml.wms.domain.party;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class PartyStateEventIdFlattenedDto
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
	
    private PartyStateEventIdDto value;

    public PartyStateEventIdFlattenedDto()
    {
        this(new PartyStateEventIdDto());
    }

    public PartyStateEventIdFlattenedDto(PartyStateEventIdDto value)
    {
        this.value = value;
    }

    public PartyStateEventIdDto toPartyStateEventIdDto()
    {
        return this.value;
    }

    public PartyStateEventId toPartyStateEventId()
    {
        return this.value.toPartyStateEventId();
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

        PartyStateEventIdFlattenedDto other = (PartyStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

