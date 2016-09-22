package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class UserLoginMvoStateEventIdFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "userLoginIdUserId",
            "userLoginIdLoginKeyLoginProvider",
            "userLoginIdLoginKeyProviderKey",
            "userVersion",
        };

    public static final String[] propertyTypes = new String[]{
            "String",
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
	
    private UserLoginMvoStateEventIdDto value;

    public UserLoginMvoStateEventIdFlattenedDto()
    {
        this(new UserLoginMvoStateEventIdDto());
    }

    public UserLoginMvoStateEventIdFlattenedDto(UserLoginMvoStateEventIdDto value)
    {
        this.value = value;
    }

    public UserLoginMvoStateEventIdDto toUserLoginMvoStateEventIdDto()
    {
        return this.value;
    }

    public UserLoginMvoStateEventId toUserLoginMvoStateEventId()
    {
        return this.value.toUserLoginMvoStateEventId();
    }

    public String getUserLoginIdUserId()
    {
        return this.value.getUserLoginId().getUserId();
    }

    public void setUserLoginIdUserId(String userLoginIdUserId)
    {
        this.value.getUserLoginId().setUserId(userLoginIdUserId);
    }

    public String getUserLoginIdLoginKeyLoginProvider()
    {
        return this.value.getUserLoginId().getLoginKey().getLoginProvider();
    }

    public void setUserLoginIdLoginKeyLoginProvider(String userLoginIdLoginKeyLoginProvider)
    {
        this.value.getUserLoginId().getLoginKey().setLoginProvider(userLoginIdLoginKeyLoginProvider);
    }

    public String getUserLoginIdLoginKeyProviderKey()
    {
        return this.value.getUserLoginId().getLoginKey().getProviderKey();
    }

    public void setUserLoginIdLoginKeyProviderKey(String userLoginIdLoginKeyProviderKey)
    {
        this.value.getUserLoginId().getLoginKey().setProviderKey(userLoginIdLoginKeyProviderKey);
    }

    public Long getUserVersion()
    {
        return this.value.getUserVersion();
    }

    public void setUserVersion(Long userVersion)
    {
        this.value.setUserVersion(userVersion);
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

        UserLoginMvoStateEventIdFlattenedDto other = (UserLoginMvoStateEventIdFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

