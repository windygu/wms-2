package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class YearPlanIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "personalNameFirstName",
            "personalNameLastName",
            "year",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
            "String",
            "Integer",
        };

    public static final Map<String, String> propertyTypeMap;

    static {
        propertyTypeMap = new HashMap<String, String>();
        for (int i = 0; i < propertyNames.length; i++ ) {
            propertyTypeMap.put(propertyNames[i], propertyTypes[i]);
        }
    }
	
    private YearPlanIdDto value;

    public YearPlanIdFlattenedDto()
    {
        this(new YearPlanIdDto());
    }

    public YearPlanIdFlattenedDto(YearPlanIdDto value)
    {
        this.value = value;
    }

    public YearPlanIdDto toYearPlanIdDto()
    {
        return this.value;
    }

    public YearPlanId toYearPlanId()
    {
        return this.value.toYearPlanId();
    }

    public String getPersonalNameFirstName()
    {
        return this.value.getPersonalName().getFirstName();
    }

    public void setPersonalNameFirstName(String personalNameFirstName)
    {
        this.value.getPersonalName().setFirstName(personalNameFirstName);
    }

    public String getPersonalNameLastName()
    {
        return this.value.getPersonalName().getLastName();
    }

    public void setPersonalNameLastName(String personalNameLastName)
    {
        this.value.getPersonalName().setLastName(personalNameLastName);
    }

    public Integer getYear()
    {
        return this.value.getYear();
    }

    public void setYear(Integer year)
    {
        this.value.setYear(year);
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

        YearPlanIdFlattenedDto other = (YearPlanIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

