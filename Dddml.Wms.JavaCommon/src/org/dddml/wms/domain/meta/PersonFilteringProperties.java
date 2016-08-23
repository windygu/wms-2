package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class PersonFilteringProperties
{

    private PersonFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "birthDate",
            "version",
            "createdBy",
            "createdAt",
            "updatedBy",
            "updatedAt",
            "active",
            "deleted",
            "personalName.firstName",
            "personalName.lastName",
            "loves.firstName",
            "loves.lastName",
            "emergencyContact.personalNameFirstName",
            "emergencyContact.personalNameLastName",
            "emergencyContact.phoneNumber",
            "emergencyContact.address",
    };

    public static final String[] propertyTypes = new String[] {
            "Date",
            "Long",
            "String",
            "Date",
            "String",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "String",
            "String",
            "String",
            "String",
            "String",
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

}

