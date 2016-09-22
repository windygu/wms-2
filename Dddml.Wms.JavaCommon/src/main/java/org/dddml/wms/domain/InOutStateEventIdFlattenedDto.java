package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class InOutStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "documentNumber",
            "version",
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
	
    private InOutStateEventIdDto value;

    public InOutStateEventIdFlattenedDto()
    {
        this(new InOutStateEventIdDto());
    }

    public InOutStateEventIdFlattenedDto(InOutStateEventIdDto value)
    {
        this.value = value;
    }

    public InOutStateEventIdDto toInOutStateEventIdDto()
    {
        return this.value;
    }

    public InOutStateEventId toInOutStateEventId()
    {
        return this.value.toInOutStateEventId();
    }

    public String getDocumentNumber()
    {
        return this.value.getDocumentNumber();
    }

    public void setDocumentNumber(String documentNumber)
    {
        this.value.setDocumentNumber(documentNumber);
    }

    public Long getVersion()
    {
        return this.value.getVersion();
    }

    public void setVersion(Long version)
    {
        this.value.setVersion(version);
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

        InOutStateEventIdFlattenedDto other = (InOutStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

