package org.dddml.wms.domain.inout;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class InOutLineIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "inOutDocumentNumber",
            "lineNumber",
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
	
    private InOutLineIdDto value;

    public InOutLineIdFlattenedDto()
    {
        this(new InOutLineIdDto());
    }

    public InOutLineIdFlattenedDto(InOutLineIdDto value)
    {
        this.value = value;
    }

    public InOutLineIdDto toInOutLineIdDto()
    {
        return this.value;
    }

    public InOutLineId toInOutLineId()
    {
        return this.value.toInOutLineId();
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        InOutLineIdFlattenedDto other = (InOutLineIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

