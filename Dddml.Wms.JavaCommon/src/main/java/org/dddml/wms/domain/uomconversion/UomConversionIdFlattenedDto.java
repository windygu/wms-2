package org.dddml.wms.domain.uomconversion;

import org.dddml.wms.domain.*;
import java.util.HashMap;
import java.util.Map;

public class UomConversionIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "uomId",
            "uomIdTo",
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
	
    private UomConversionIdDto value;

    public UomConversionIdFlattenedDto()
    {
        this(new UomConversionIdDto());
    }

    public UomConversionIdFlattenedDto(UomConversionIdDto value)
    {
        this.value = value;
    }

    public UomConversionIdDto toUomConversionIdDto()
    {
        return this.value;
    }

    public UomConversionId toUomConversionId()
    {
        return this.value.toUomConversionId();
    }

    public String getUomId()
    {
        return this.value.getUomId();
    }

    public void setUomId(String uomId)
    {
        this.value.setUomId(uomId);
    }

    public String getUomIdTo()
    {
        return this.value.getUomIdTo();
    }

    public void setUomIdTo(String uomIdTo)
    {
        this.value.setUomIdTo(uomIdTo);
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

        UomConversionIdFlattenedDto other = (UomConversionIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

