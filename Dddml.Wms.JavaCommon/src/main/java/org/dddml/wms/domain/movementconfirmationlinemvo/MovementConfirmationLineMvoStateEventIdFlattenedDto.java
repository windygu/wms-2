package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movement.MovementConfirmationLineIdDto;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementConfirmationLineMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "movementConfirmationLineIdMovementDocumentNumber",
            "movementConfirmationLineIdLineNumber",
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
	
    private MovementConfirmationLineMvoStateEventIdDto value;

    public MovementConfirmationLineMvoStateEventIdFlattenedDto()
    {
        this(new MovementConfirmationLineMvoStateEventIdDto());
    }

    public MovementConfirmationLineMvoStateEventIdFlattenedDto(MovementConfirmationLineMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public MovementConfirmationLineMvoStateEventIdDto toMovementConfirmationLineMvoStateEventIdDto()
    {
        return this.value;
    }

    public MovementConfirmationLineMvoStateEventId toMovementConfirmationLineMvoStateEventId()
    {
        return this.value.toMovementConfirmationLineMvoStateEventId();
    }

    public String getMovementConfirmationLineIdMovementDocumentNumber()
    {
        return this.value.getMovementConfirmationLineId().getMovementDocumentNumber();
    }

    public void setMovementConfirmationLineIdMovementDocumentNumber(String movementConfirmationLineIdMovementDocumentNumber)
    {
        this.value.getMovementConfirmationLineId().setMovementDocumentNumber(movementConfirmationLineIdMovementDocumentNumber);
    }

    public String getMovementConfirmationLineIdLineNumber()
    {
        return this.value.getMovementConfirmationLineId().getLineNumber();
    }

    public void setMovementConfirmationLineIdLineNumber(String movementConfirmationLineIdLineNumber)
    {
        this.value.getMovementConfirmationLineId().setLineNumber(movementConfirmationLineIdLineNumber);
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

        MovementConfirmationLineMvoStateEventIdFlattenedDto other = (MovementConfirmationLineMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

