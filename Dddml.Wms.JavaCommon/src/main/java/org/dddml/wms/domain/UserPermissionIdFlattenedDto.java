package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class UserPermissionIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "userId",
            "permissionId",
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
	
    private UserPermissionIdDto value;

    public UserPermissionIdFlattenedDto()
    {
        this(new UserPermissionIdDto());
    }

    public UserPermissionIdFlattenedDto(UserPermissionIdDto value)
    {
        this.value = value;
    }

    public UserPermissionIdDto toUserPermissionIdDto()
    {
        return this.value;
    }

    public UserPermissionId toUserPermissionId()
    {
        return this.value.toUserPermissionId();
    }

    public String getUserId()
    {
        return this.value.getUserId();
    }

    public void setUserId(String userId)
    {
        this.value.setUserId(userId);
    }

    public String getPermissionId()
    {
        return this.value.getPermissionId();
    }

    public void setPermissionId(String permissionId)
    {
        this.value.setPermissionId(permissionId);
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

        UserPermissionIdFlattenedDto other = (UserPermissionIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

