package org.dddml.wms.domain;


public class UserClaimIdDtoWrapper extends UserClaimIdDto
{
	
    private UserClaimId value;

    public UserClaimIdDtoWrapper()
    {
        this(new UserClaimId());
    }

    public UserClaimIdDtoWrapper(UserClaimId value)
    {
        this.value = value;
    }

    public UserClaimId toUserClaimId()
    {
        return this.value;
    }

    @Override
    public String getUserId()
    {
        return this.value.getUserId();
    }

    @Override
    public void setUserId(String userId)
    {
        this.value.setUserId(userId);
    }

    @Override
    public Integer getClaimId()
    {
        return this.value.getClaimId();
    }

    @Override
    public void setClaimId(Integer claimId)
    {
        this.value.setClaimId(claimId);
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
        if (obj.getClass() == UserClaimIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserClaimIdDtoWrapper other = (UserClaimIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

