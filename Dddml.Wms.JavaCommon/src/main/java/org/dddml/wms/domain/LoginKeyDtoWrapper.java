package org.dddml.wms.domain;


public class LoginKeyDtoWrapper extends LoginKeyDto
{
	
    private LoginKey value;

    public LoginKeyDtoWrapper()
    {
        this(new LoginKey());
    }

    public LoginKeyDtoWrapper(LoginKey value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public LoginKey toLoginKey()
    {
        return this.value;
    }

    @Override
    public String getLoginProvider()
    {
        return this.value.getLoginProvider();
    }

    @Override
    public void setLoginProvider(String loginProvider)
    {
        this.value.setLoginProvider(loginProvider);
    }

    @Override
    public String getProviderKey()
    {
        return this.value.getProviderKey();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == LoginKeyDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        LoginKeyDtoWrapper other = (LoginKeyDtoWrapper)obj;
        return value.equals(other.value);
    }

}

