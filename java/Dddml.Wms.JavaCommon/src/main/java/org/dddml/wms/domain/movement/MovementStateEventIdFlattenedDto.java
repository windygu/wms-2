package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "documentNumber",
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
	
    private MovementStateEventIdDto value;

    public MovementStateEventIdFlattenedDto()
    {
        this(new MovementStateEventIdDto());
    }

    public MovementStateEventIdFlattenedDto(MovementStateEventIdDto value)
    {
        this.value = value;
    }

    public MovementStateEventIdDto toMovementStateEventIdDto()
    {
        return this.value;
    }

    public MovementStateEventId toMovementStateEventId()
    {
        return this.value.toMovementStateEventId();
    }

    public String getDocumentNumber()
    {
        return this.value.getDocumentNumber();
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.value.setDocumentNumber(documentNumber);
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

        MovementStateEventIdFlattenedDto other = (MovementStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

