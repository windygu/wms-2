package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementLineStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "movementDocumentNumber",
            "lineNumber",
            "movementVersion",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
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
	
    private MovementLineStateEventIdDto value;

    public MovementLineStateEventIdFlattenedDto()
    {
        this(new MovementLineStateEventIdDto());
    }

    public MovementLineStateEventIdFlattenedDto(MovementLineStateEventIdDto value)
    {
        this.value = value;
    }

    public MovementLineStateEventIdDto toMovementLineStateEventIdDto()
    {
        return this.value;
    }

    public MovementLineStateEventId toMovementLineStateEventId()
    {
        return this.value.toMovementLineStateEventId();
    }

    public String getMovementDocumentNumber()
    {
        return this.value.getMovementDocumentNumber();
    }

    public void setMovementDocumentNumber(String movementDocumentNumber)
    {
        this.value.setMovementDocumentNumber(movementDocumentNumber);
    }

    public String getLineNumber()
    {
        return this.value.getLineNumber();
    }

    public void setLineNumber(String lineNumber)
    {
        this.value.setLineNumber(lineNumber);
    }

    public Long getMovementVersion()
    {
        return this.value.getMovementVersion();
    }

    public void setMovementVersion(Long movementVersion)
    {
        this.value.setMovementVersion(movementVersion);
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

        MovementLineStateEventIdFlattenedDto other = (MovementLineStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

