package org.dddml.wms.domain.damagehandlingmethod;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class DamageHandlingMethodStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "damageHandlingMethodId",
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
	
    private DamageHandlingMethodStateEventIdDto value;

    public DamageHandlingMethodStateEventIdFlattenedDto()
    {
        this(new DamageHandlingMethodStateEventIdDto());
    }

    public DamageHandlingMethodStateEventIdFlattenedDto(DamageHandlingMethodStateEventIdDto value)
    {
        this.value = value;
    }

    public DamageHandlingMethodStateEventIdDto toDamageHandlingMethodStateEventIdDto()
    {
        return this.value;
    }

    public DamageHandlingMethodStateEventId toDamageHandlingMethodStateEventId()
    {
        return this.value.toDamageHandlingMethodStateEventId();
    }

    public String getDamageHandlingMethodId()
    {
        return this.value.getDamageHandlingMethodId();
    }

    public void setDamageHandlingMethodId(String damageHandlingMethodId)
    {
        this.value.setDamageHandlingMethodId(damageHandlingMethodId);
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

        DamageHandlingMethodStateEventIdFlattenedDto other = (DamageHandlingMethodStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

