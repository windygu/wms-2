package org.dddml.wms.domain;


public class LoginKeyDto
{

    public LoginKeyDto()
    {
    }

    public LoginKey toLoginKey()
    {
        LoginKey v = new LoginKey();
        v.setLoginProvider(this.getLoginProvider());
        v.setProviderKey(this.getProviderKey());
        return v;
    }

    private String loginProvider;

    public String getLoginProvider()
    {
        return this.loginProvider;
    }

    public void setLoginProvider(String loginProvider)
    {
        this.loginProvider = loginProvider;
    }

    private String providerKey;

    public String getProviderKey()
    {
        return this.providerKey;
    }

    public void setProviderKey(String providerKey)
    {
        this.providerKey = providerKey;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != LoginKeyDto.class) {
            return false;
        }

        LoginKeyDto other = (LoginKeyDto)obj;
        return true 
            && (loginProvider == other.loginProvider || (loginProvider != null && loginProvider.equals(other.loginProvider)))
            && (providerKey == other.providerKey || (providerKey != null && providerKey.equals(other.providerKey)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.loginProvider != null) {
            hash += 13 * this.loginProvider.hashCode();
        }
        if (this.providerKey != null) {
            hash += 13 * this.providerKey.hashCode();
        }
        return hash;
    }

}

