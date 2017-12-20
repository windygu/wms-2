package org.dddml.wms.domain.movementconfirmationlinemvo;

import org.dddml.wms.domain.movementconfirmation.MovementConfirmationLineIdDto;
import org.dddml.wms.domain.movementconfirmation.*;
import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class MovementConfirmationLineMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "movementConfirmationLineIdMovementConfirmationDocumentNumber",
            "movementConfirmationLineIdLineNumber",
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

    public String getMovementConfirmationLineIdMovementConfirmationDocumentNumber()
    {
        return this.value.getMovementConfirmationLineId().getMovementConfirmationDocumentNumber();
    }

    public void setMovementConfirmationLineIdMovementConfirmationDocumentNumber(String movementConfirmationLineIdMovementConfirmationDocumentNumber)
    {
        this.value.getMovementConfirmationLineId().setMovementConfirmationDocumentNumber(movementConfirmationLineIdMovementConfirmationDocumentNumber);
    }

    public String getMovementConfirmationLineIdLineNumber()
    {
        return this.value.getMovementConfirmationLineId().getLineNumber();
    }

    public void setMovementConfirmationLineIdLineNumber(String movementConfirmationLineIdLineNumber)
    {
        this.value.getMovementConfirmationLineId().setLineNumber(movementConfirmationLineIdLineNumber);
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

        MovementConfirmationLineMvoStateEventIdFlattenedDto other = (MovementConfirmationLineMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

