package org.dddml.wms.domain.damagetype;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class DamageTypeStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "damageTypeId",
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
	
    private DamageTypeStateEventIdDto value;

    public DamageTypeStateEventIdFlattenedDto()
    {
        this(new DamageTypeStateEventIdDto());
    }

    public DamageTypeStateEventIdFlattenedDto(DamageTypeStateEventIdDto value)
    {
        this.value = value;
    }

    public DamageTypeStateEventIdDto toDamageTypeStateEventIdDto()
    {
        return this.value;
    }

    public DamageTypeStateEventId toDamageTypeStateEventId()
    {
        return this.value.toDamageTypeStateEventId();
    }

    public String getDamageTypeId()
    {
        return this.value.getDamageTypeId();
    }

    public void setDamageTypeId(String damageTypeId)
    {
        this.value.setDamageTypeId(damageTypeId);
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

        DamageTypeStateEventIdFlattenedDto other = (DamageTypeStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

