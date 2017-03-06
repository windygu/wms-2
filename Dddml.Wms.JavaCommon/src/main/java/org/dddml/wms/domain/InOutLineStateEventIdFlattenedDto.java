package org.dddml.wms.domain;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InOutLineStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inOutDocumentNumber",
            "lineNumber",
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
	
    private InOutLineStateEventIdDto value;

    public InOutLineStateEventIdFlattenedDto()
    {
        this(new InOutLineStateEventIdDto());
    }

    public InOutLineStateEventIdFlattenedDto(InOutLineStateEventIdDto value)
    {
        this.value = value;
    }

    public InOutLineStateEventIdDto toInOutLineStateEventIdDto()
    {
        return this.value;
    }

    public InOutLineStateEventId toInOutLineStateEventId()
    {
        return this.value.toInOutLineStateEventId();
    }

    public String getInOutDocumentNumber()
    {
        return this.value.getInOutDocumentNumber();
    }

    public void setInOutDocumentNumber(String inOutDocumentNumber)
    {
        this.value.setInOutDocumentNumber(inOutDocumentNumber);
    }

    public Long getLineNumber()
    {
        return this.value.getLineNumber();
    }

    public void setLineNumber(Long lineNumber)
    {
        this.value.setLineNumber(lineNumber);
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

        InOutLineStateEventIdFlattenedDto other = (InOutLineStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

