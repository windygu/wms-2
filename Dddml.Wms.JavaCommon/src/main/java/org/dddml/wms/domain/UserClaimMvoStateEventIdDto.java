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
            && (userClaimId == other.userClaimId || (userClaimId != null && userClaimId.equals(other.userClaimId)))
            && (userVersion == other.userVersion || (userVersion != null && userVersion.equals(other.userVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.userClaimId != null) {
            hash += 13 * this.userClaimId.hashCode();
        }
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

