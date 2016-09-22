package org.dddml.wms.domain;


public class UserClaimMvoStateEventIdDtoWrapper extends UserClaimMvoStateEventIdDto
{
	
    private UserClaimMvoStateEventId value;

    public UserClaimMvoStateEventIdDtoWrapper()
    {
        this(new UserClaimMvoStateEventId());
    }

    public UserClaimMvoStateEventIdDtoWrapper(UserClaimMvoStateEventId value)
    {
        if (value == null) { throw new IllegalArgumentException("value == null"); }
        this.value = value;
    }

    public UserClaimMvoStateEventId toUserClaimMvoStateEventId()
    {
        return this.value;
    }

    @Override
    public UserClaimIdDto getUserClaimId()
    {
        return new UserClaimIdDtoWrapper(this.value.getUserClaimId());
    }

    @Override
    public void setUserClaimId(UserClaimIdDto userClaimId)
    {
        this.value.setUserClaimId(userClaimId.toUserClaimId());
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
        if (obj.getClass() == UserClaimMvoStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        UserClaimMvoStateEventIdDtoWrapper other = (UserClaimMvoStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

}

