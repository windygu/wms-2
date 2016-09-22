package org.dddml.wms.domain;


public class UserClaimIdDto
{

    public UserClaimIdDto()
    {
    }

    public UserClaimId toUserClaimId()
    {
        UserClaimId v = new UserClaimId();
        v.setUserId(this.getUserId());
        v.setClaimId(this.getClaimId());
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


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != UserClaimIdDto.class) {
            return false;
        }

        UserClaimIdDto other = (UserClaimIdDto)obj;
        return true 
            && (getUserId() == other.getUserId() || (getUserId() != null && getUserId().equals(other.getUserId())))
            && (getClaimId() == other.getClaimId() || (getClaimId() != null && getClaimId().equals(other.getClaimId())))
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
        return hash;
    }

}

