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
            && (getUserId() == other.getUserId() || (getUserId() != null && getUserId().equals(other.getUserId())))
            && (getClaimId() == other.getClaimId() || (getClaimId() != null && getClaimId().equals(other.getClaimId())))
            && (getUserVersion() == other.getUserVersion() || (getUserVersion() != null && getUserVersion().equals(other.getUserVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getUserId() != null) {
            hash += 13 * this.getUserId().hashCode();
        }
        if (this.getClaimId() != null) {
            hash += 13 * this.getClaimId().hashCode();
        }
        if (this.getUserVersion() != null) {
            hash += 13 * this.getUserVersion().hashCode();
        }
        return hash;
    }

}

