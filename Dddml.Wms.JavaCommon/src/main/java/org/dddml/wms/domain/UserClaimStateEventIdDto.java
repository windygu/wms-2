package org.dddml.wms.domain;


public class UserClaimStateEventIdDto
{

    public UserClaimStateEventIdDto()
    {
    }

    public UserClaimStateEventId toUserClaimStateEventId()
    {
        UserClaimStateEventId v = new UserClaimStateEventId();
        v.setUserId(this.getUserId());
        v.setClaimId(this.getClaimId());
        v.setUserVersion(this.getUserVersion());
        return v;
    }

    private String userId;

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    private Integer claimId;

    public Integer getClaimId()
    {
        return this.claimId;
    }

    public void setClaimId(Integer claimId)
    {
        this.claimId = claimId;
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
        if (obj == null || obj.getClass() != UserClaimStateEventIdDto.class) {
            return false;
        }

        UserClaimStateEventIdDto other = (UserClaimStateEventIdDto)obj;
        return true 
            && (userId == other.userId || (userId != null && userId.equals(other.userId)))
            && (claimId == other.claimId || (claimId != null && claimId.equals(other.claimId)))
            && (userVersion == other.userVersion || (userVersion != null && userVersion.equals(other.userVersion)))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.userId != null) {
            hash += 13 * this.userId.hashCode();
        }
        if (this.claimId != null) {
            hash += 13 * this.claimId.hashCode();
        }
        if (this.userVersion != null) {
            hash += 13 * this.userVersion.hashCode();
        }
        return hash;
    }

}

