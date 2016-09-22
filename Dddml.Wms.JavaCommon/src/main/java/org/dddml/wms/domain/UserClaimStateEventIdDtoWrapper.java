package org.dddml.wms.domain;


public class UserClaimStateEventIdDtoWrapper extends UserClaimStateEventIdDto
{
	
    private UserClaimStateEventId value;

    public UserClaimStateEventIdDtoWrapper()
    {
        this(new UserClaimStateEventId());
    }

    public UserClaimStateEventIdDtoWrapper(UserClaimStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UserClaimStateEventId toUserClaimStateEventId()
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
    public Long getUserVersion()
    {
        return this.value.getUserVersion();
    }

    @Override
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
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == UserClaimStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserClaimStateEventIdDtoWrapper other = (UserClaimStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

