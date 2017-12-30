package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class UomConversionStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "uomConversionIdUomId",
            "uomConversionIdUomIdTo",
            "version",
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
	
    private UomConversionStateEventIdDto value;

    public UomConversionStateEventIdFlattenedDto()
    {
        this(new UomConversionStateEventIdDto());
    }

    public UomConversionStateEventIdFlattenedDto(UomConversionStateEventIdDto value)
    {
        this.value = value;
    }

    public UomConversionStateEventIdDto toUomConversionStateEventIdDto()
    {
        return this.value;
    }

    public UomConversionStateEventId toUomConversionStateEventId()
    {
        return this.value.toUomConversionStateEventId();
    }

    public String getUomConversionIdUomId()
    {
        return this.value.getUomConversionId().getUomId();
    }

    public void setUomConversionIdUomId(String uomConversionIdUomId)
    {
        this.value.getUomConversionId().setUomId(uomConversionIdUomId);
    }

    public String getUomConversionIdUomIdTo()
    {
        return this.value.getUomConversionId().getUomIdTo();
    }

    public void setUomConversionIdUomIdTo(String uomConversionIdUomIdTo)
    {
        this.value.getUomConversionId().setUomIdTo(uomConversionIdUomIdTo);
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

        UomConversionStateEventIdFlattenedDto other = (UomConversionStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

