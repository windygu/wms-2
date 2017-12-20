package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementConfirmationLineStateEventIdFlattenedDto
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
	
    private MovementConfirmationLineStateEventIdDto value;

    public MovementConfirmationLineStateEventIdFlattenedDto()
    {
        this(new MovementConfirmationLineStateEventIdDto());
    }

    public MovementConfirmationLineStateEventIdFlattenedDto(MovementConfirmationLineStateEventIdDto value)
    {
        this.value = value;
    }

    public MovementConfirmationLineStateEventIdDto toMovementConfirmationLineStateEventIdDto()
    {
        return this.value;
    }

    public MovementConfirmationLineStateEventId toMovementConfirmationLineStateEventId()
    {
        return this.value.toMovementConfirmationLineStateEventId();
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

        MovementConfirmationLineStateEventIdFlattenedDto other = (MovementConfirmationLineStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

