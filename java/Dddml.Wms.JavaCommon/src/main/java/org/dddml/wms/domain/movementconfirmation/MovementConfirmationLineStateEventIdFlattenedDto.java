package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementConfirmationLineStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "movementConfirmationDocumentNumber",
            "lineNumber",
            "movementConfirmationVersion",
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

    public String getMovementConfirmationDocumentNumber()
    {
        return this.value.getMovementConfirmationDocumentNumber();
    }

    public void setMovementConfirmationDocumentNumber(String movementConfirmationDocumentNumber)
    {
        this.value.setMovementConfirmationDocumentNumber(movementConfirmationDocumentNumber);
    }

    public String getLineNumber()
    {
        return this.value.getLineNumber();
    }

    public void setLineNumber(String lineNumber)
    {
        this.value.setLineNumber(lineNumber);
    }

    public Long getMovementConfirmationVersion()
    {
        return this.value.getMovementConfirmationVersion();
    }

    public void setMovementConfirmationVersion(Long movementConfirmationVersion)
    {
        this.value.setMovementConfirmationVersion(movementConfirmationVersion);
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

