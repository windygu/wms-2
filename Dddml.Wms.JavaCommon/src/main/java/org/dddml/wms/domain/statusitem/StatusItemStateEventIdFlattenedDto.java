package org.dddml.wms.domain.statusitem;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class StatusItemStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "statusId",
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
	
    private StatusItemStateEventIdDto value;

    public StatusItemStateEventIdFlattenedDto()
    {
        this(new StatusItemStateEventIdDto());
    }

    public StatusItemStateEventIdFlattenedDto(StatusItemStateEventIdDto value)
    {
        this.value = value;
    }

    public StatusItemStateEventIdDto toStatusItemStateEventIdDto()
    {
        return this.value;
    }

    public StatusItemStateEventId toStatusItemStateEventId()
    {
        return this.value.toStatusItemStateEventId();
    }

    public String getStatusId()
    {
        return this.value.getStatusId();
    }

    public void setStatusId(String statusId)
    {
        this.value.setStatusId(statusId);
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

        StatusItemStateEventIdFlattenedDto other = (StatusItemStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

