package org.dddml.wms.domain.organization;

import org.dddml.wms.domain.*;

public class OrganizationStateEventIdDto
{

    public OrganizationStateEventIdDto()
    {
    }

    public OrganizationStateEventId toOrganizationStateEventId()
    {
        OrganizationStateEventId v = new OrganizationStateEventId();
        v.setPartyId(this.getPartyId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String partyId;

    public String getPartyId()
    {
        return this.partyId;
    }

    public void setPartyId(String partyId)
    {
        this.partyId = partyId;
    }

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != OrganizationStateEventIdDto.class) {
            return false;
        }

        OrganizationStateEventIdDto other = (OrganizationStateEventIdDto)obj;
        return true 
            && (getPartyId() == other.getPartyId() || (getPartyId() != null && getPartyId().equals(other.getPartyId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getPartyId() != null) {
            hash += 13 * this.getPartyId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

