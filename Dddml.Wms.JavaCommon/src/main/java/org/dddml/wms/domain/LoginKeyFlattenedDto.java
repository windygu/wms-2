package org.dddml.wms.domain;

import java.util.HashMap;
import java.util.Map;

public class LoginKeyFlattenedDto
{


    public static final String[] propertyNames = new String[]{
            "loginProvider",
            "providerKey",
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
	
    private LoginKeyDto value;

    public LoginKeyFlattenedDto()
    {
        this(new LoginKeyDto());
    }

    public LoginKeyFlattenedDto(LoginKeyDto value)
    {
        this.value = value;
    }

    public LoginKeyDto toLoginKeyDto()
    {
        return this.value;
    }

    public LoginKey toLoginKey()
    {
        return this.value.toLoginKey();
    }

    public String getLoginProvider()
    {
        return this.value.getLoginProvider();
    }

    public void setLoginProvider(String loginProvider)
    {
        this.value.setLoginProvider(loginProvider);
    }

    public String getProviderKey()
    {
        return this.value.getProviderKey();
    }

    public void setProviderKey(String providerKey)
    {
        this.value.setProviderKey(providerKey);
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

        LoginKeyFlattenedDto other = (LoginKeyFlattenedDto)obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

}

