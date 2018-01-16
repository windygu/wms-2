package org.dddml.wms.domain.rejectionreason;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class RejectionReasonStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "rejectionReasonId",
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
	
    private RejectionReasonStateEventIdDto value;

    public RejectionReasonStateEventIdFlattenedDto()
    {
        this(new RejectionReasonStateEventIdDto());
    }

    public RejectionReasonStateEventIdFlattenedDto(RejectionReasonStateEventIdDto value)
    {
        this.value = value;
    }

    public RejectionReasonStateEventIdDto toRejectionReasonStateEventIdDto()
    {
        return this.value;
    }

    public RejectionReasonStateEventId toRejectionReasonStateEventId()
    {
        return this.value.toRejectionReasonStateEventId();
    }

    public String getRejectionReasonId()
    {
        return this.value.getRejectionReasonId();
    }

    public void setRejectionReasonId(String rejectionReasonId)
    {
        this.value.setRejectionReasonId(rejectionReasonId);
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

        RejectionReasonStateEventIdFlattenedDto other = (RejectionReasonStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

