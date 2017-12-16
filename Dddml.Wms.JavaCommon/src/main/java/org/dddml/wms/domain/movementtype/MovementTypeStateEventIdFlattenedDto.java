package org.dddml.wms.domain.movementtype;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementTypeStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "movementTypeId",
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
	
    private MovementTypeStateEventIdDto value;

    public MovementTypeStateEventIdFlattenedDto()
    {
        this(new MovementTypeStateEventIdDto());
    }

    public MovementTypeStateEventIdFlattenedDto(MovementTypeStateEventIdDto value)
    {
        this.value = value;
    }

    public MovementTypeStateEventIdDto toMovementTypeStateEventIdDto()
    {
        return this.value;
    }

    public MovementTypeStateEventId toMovementTypeStateEventId()
    {
        return this.value.toMovementTypeStateEventId();
    }

    public String getMovementTypeId()
    {
        return this.value.getMovementTypeId();
    }

    public void setMovementTypeId(String movementTypeId)
    {
        this.value.setMovementTypeId(movementTypeId);
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

        MovementTypeStateEventIdFlattenedDto other = (MovementTypeStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

