package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class UserRoleIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "userId",
            "roleId",
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
	
    private UserRoleIdDto value;

    public UserRoleIdFlattenedDto()
    {
        this(new UserRoleIdDto());
    }

    public UserRoleIdFlattenedDto(UserRoleIdDto value)
    {
        this.value = value;
    }

    public UserRoleIdDto toUserRoleIdDto()
    {
        return this.value;
    }

    public UserRoleId toUserRoleId()
    {
        return this.value.toUserRoleId();
    }

    public String getUserId()
    {
        return this.value.getUserId();
    }

    public void setUserId(String userId)
    {
        this.value.setUserId(userId);
    }

    public String getRoleId()
    {
        return this.value.getRoleId();
    }

    public void setRoleId(String roleId)
    {
        this.value.setRoleId(roleId);
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

        UserRoleIdFlattenedDto other = (UserRoleIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

