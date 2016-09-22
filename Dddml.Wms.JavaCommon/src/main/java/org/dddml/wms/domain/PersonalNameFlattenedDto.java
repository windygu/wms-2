package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class PersonalNameFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "firstName",
            "lastName",
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
	
    private PersonalNameDto value;

    public PersonalNameFlattenedDto()
    {
        this(new PersonalNameDto());
    }

    public PersonalNameFlattenedDto(PersonalNameDto value)
    {
        this.value = value;
    }

    public PersonalNameDto toPersonalNameDto()
    {
        return this.value;
    }

    public PersonalName toPersonalName()
    {
        return this.value.toPersonalName();
    }

    public String getFirstName()
    {
        return this.value.getFirstName();
    }

    public void setFirstName(String firstName)
    {
        this.value.setFirstName(firstName);
    }

    public String getLastName()
    {
        return this.value.getLastName();
    }

    public void setLastName(String lastName)
    {
        this.value.setLastName(lastName);
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

        PersonalNameFlattenedDto other = (PersonalNameFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

