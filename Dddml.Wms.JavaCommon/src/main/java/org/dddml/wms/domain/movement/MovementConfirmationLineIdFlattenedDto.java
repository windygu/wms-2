package org.dddml.wms.domain.movement;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementConfirmationLineIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "movementDocumentNumber",
            "lineNumber",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private MovementConfirmationLineIdDto value;

    public MovementConfirmationLineIdFlattenedDto()
    {
        this(new MovementConfirmationLineIdDto());
    }

    public MovementConfirmationLineIdFlattenedDto(MovementConfirmationLineIdDto value)
    {
        this.value = value;
    }

    public MovementConfirmationLineIdDto toMovementConfirmationLineIdDto()
    {
        return this.value;
    }

    public MovementConfirmationLineId toMovementConfirmationLineId()
    {
        return this.value.toMovementConfirmationLineId();
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MovementConfirmationLineIdFlattenedDto other = (MovementConfirmationLineIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

