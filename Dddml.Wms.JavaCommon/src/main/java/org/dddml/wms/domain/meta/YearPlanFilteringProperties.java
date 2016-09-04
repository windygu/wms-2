package org.dddml.wms.domain.meta;

import java.util.HashMap;
import java.util.Map;

public final class YearPlanFilteringProperties
{

    private YearPlanFilteringProperties()
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
            "yearPlanId.personalNameFirstName",
            "yearPlanId.personalNameLastName",
            "yearPlanId.year",
            "personalName.firstName",
            "personalName.lastName",
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
            "String",
            "String",
            "Integer",
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

