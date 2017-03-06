package org.dddml.wms.domain;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InOutLineMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inOutLineIdInOutDocumentNumber",
            "inOutLineIdLineNumber",
            "inOutVersion",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "Long",
            "Long",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private InOutLineMvoStateEventIdDto value;

    public InOutLineMvoStateEventIdFlattenedDto()
    {
        this(new InOutLineMvoStateEventIdDto());
    }

    public InOutLineMvoStateEventIdFlattenedDto(InOutLineMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public InOutLineMvoStateEventIdDto toInOutLineMvoStateEventIdDto()
    {
        return this.value;
    }

    public InOutLineMvoStateEventId toInOutLineMvoStateEventId()
    {
        return this.value.toInOutLineMvoStateEventId();
    }

    public String getInOutLineIdInOutDocumentNumber()
    {
        return this.value.getInOutLineId().getInOutDocumentNumber();
    }

    public void setInOutLineIdInOutDocumentNumber(String inOutLineIdInOutDocumentNumber)
    {
        this.value.getInOutLineId().setInOutDocumentNumber(inOutLineIdInOutDocumentNumber);
    }

    public Long getInOutLineIdLineNumber()
    {
        return this.value.getInOutLineId().getLineNumber();
    }

    public void setInOutLineIdLineNumber(Long inOutLineIdLineNumber)
    {
        this.value.getInOutLineId().setLineNumber(inOutLineIdLineNumber);
    }

    public Long getInOutVersion()
    {
        return this.value.getInOutVersion();
    }

    public void setInOutVersion(Long inOutVersion)
    {
        this.value.setInOutVersion(inOutVersion);
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

        InOutLineMvoStateEventIdFlattenedDto other = (InOutLineMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

