package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class YearPlanMvoFilteringProperties
{

    private YearPlanMvoFilteringProperties()
    {
    }

    public static final String[] propertyNames = new String[] {
            "description",
            "createdBy",
            "updatedBy",
            "version",
            "createdAt",
            "updatedAt",
            "active",
            "deleted",
            "personBirthDate",
            "personCreatedBy",
            "personUpdatedBy",
            "personVersion",
            "personCreatedAt",
            "personUpdatedAt",
            "personActive",
            "personDeleted",
            "yearPlanId.personalNameFirstName",
            "yearPlanId.personalNameLastName",
            "yearPlanId.year",
            "personLoves.firstName",
            "personLoves.lastName",
            "personEmergencyContact.personalNameFirstName",
            "personEmergencyContact.personalNameLastName",
            "personEmergencyContact.phoneNumber",
            "personEmergencyContact.address",
    };

    public static final String[] propertyTypes = new String[] {
            "String",
            "String",
            "String",
            "Long",
            "Date",
            "Date",
            "Boolean",
            "Boolean",
            "Date",
            "String",
            "String",
            "Long",
            "Date",
            "Date",
            "Boolean",
            "Boolean",
            "String",
            "String",
            "Integer",
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

