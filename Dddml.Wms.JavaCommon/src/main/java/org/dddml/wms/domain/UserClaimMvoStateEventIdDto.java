package org.dddml.wms.domain;


public class UserClaimMvoStateEventIdDto
{

    public UserClaimMvoStateEventIdDto()
    {
    }

    public UserClaimMvoStateEventId toUserClaimMvoStateEventId()
    {
        UserClaimMvoStateEventId v = new UserClaimMvoStateEventId();
        v.setUserClaimId(this.getUserClaimId().toUserClaimId());
        v.setUserVersion(this.getUserVersion());
        return v;
    }

    private UserClaimIdDto userClaimId = new UserClaimIdDto();

    public UserClaimIdDto getUserClaimId()
    {
        return this.userClaimId;
    }

    public void setUserClaimId(UserClaimIdDto userClaimId)
    {
        this.userClaimId = userClaimId;
    }

    private Long userVersion;

    public Long getUserVersion()
    {
        return this.userVersion;
    }

    public void setUserVersion(Long userVersion)
    {
        this.userVersion = userVersion;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != UserClaimMvoStateEventIdDto.class) {
            return false;
        }

        UserClaimMvoStateEventIdDto other = (UserClaimMvoStateEventIdDto)obj;
        return true 
            && (getUserClaimId() == other.getUserClaimId() || (getUserClaimId() != null && getUserClaimId().equals(other.getUserClaimId())))
            && (getUserVersion() == other.getUserVersion() || (getUserVersion() != null && getUserVersion().equals(other.getUserVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUserClaimId() != null) {
            hash += 13 * this.getUserClaimId().hashCode();
        }
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

