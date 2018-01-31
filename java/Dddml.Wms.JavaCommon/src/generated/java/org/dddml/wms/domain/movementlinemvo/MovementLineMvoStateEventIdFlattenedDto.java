package org.dddml.wms.domain.movementlinemvo;

import org.dddml.wms.domain.movement.MovementLineIdDto;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementLineMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "movementLineIdMovementDocumentNumber",
            "movementLineIdLineNumber",
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
	
    private MovementLineMvoStateEventIdDto value;

    public MovementLineMvoStateEventIdFlattenedDto()
    {
        this(new MovementLineMvoStateEventIdDto());
    }

    public MovementLineMvoStateEventIdFlattenedDto(MovementLineMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public MovementLineMvoStateEventIdDto toMovementLineMvoStateEventIdDto()
    {
        return this.value;
    }

    public MovementLineMvoStateEventId toMovementLineMvoStateEventId()
    {
        return this.value.toMovementLineMvoStateEventId();
    }

    public String getMovementLineIdMovementDocumentNumber()
    {
        return this.value.getMovementLineId().getMovementDocumentNumber();
    }

    public void setMovementLineIdMovementDocumentNumber(String movementLineIdMovementDocumentNumber)
    {
        this.value.getMovementLineId().setMovementDocumentNumber(movementLineIdMovementDocumentNumber);
    }

    public String getMovementLineIdLineNumber()
    {
        return this.value.getMovementLineId().getLineNumber();
    }

    public void setMovementLineIdLineNumber(String movementLineIdLineNumber)
    {
        this.value.getMovementLineId().setLineNumber(movementLineIdLineNumber);
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

        MovementLineMvoStateEventIdFlattenedDto other = (MovementLineMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

