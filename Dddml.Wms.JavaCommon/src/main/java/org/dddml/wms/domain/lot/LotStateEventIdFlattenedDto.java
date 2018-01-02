package org.dddml.wms.domain.lot;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class LotStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "lotId",
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
	
    private LotStateEventIdDto value;

    public LotStateEventIdFlattenedDto()
    {
        this(new LotStateEventIdDto());
    }

    public LotStateEventIdFlattenedDto(LotStateEventIdDto value)
    {
        this.value = value;
    }

    public LotStateEventIdDto toLotStateEventIdDto()
    {
        return this.value;
    }

    public LotStateEventId toLotStateEventId()
    {
        return this.value.toLotStateEventId();
    }

    public String getLotId()
    {
        return this.value.getLotId();
    }

    public void setLotId(String lotId)
    {
        this.value.setLotId(lotId);
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

        LotStateEventIdFlattenedDto other = (LotStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

