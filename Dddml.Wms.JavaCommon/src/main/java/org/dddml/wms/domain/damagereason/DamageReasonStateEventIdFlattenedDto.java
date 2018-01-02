package org.dddml.wms.domain.damagereason;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class DamageReasonStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "damageReasonId",
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
	
    private DamageReasonStateEventIdDto value;

    public DamageReasonStateEventIdFlattenedDto()
    {
        this(new DamageReasonStateEventIdDto());
    }

    public DamageReasonStateEventIdFlattenedDto(DamageReasonStateEventIdDto value)
    {
        this.value = value;
    }

    public DamageReasonStateEventIdDto toDamageReasonStateEventIdDto()
    {
        return this.value;
    }

    public DamageReasonStateEventId toDamageReasonStateEventId()
    {
        return this.value.toDamageReasonStateEventId();
    }

    public String getDamageReasonId()
    {
        return this.value.getDamageReasonId();
    }

    public void setDamageReasonId(String damageReasonId)
    {
        this.value.setDamageReasonId(damageReasonId);
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

        DamageReasonStateEventIdFlattenedDto other = (DamageReasonStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

