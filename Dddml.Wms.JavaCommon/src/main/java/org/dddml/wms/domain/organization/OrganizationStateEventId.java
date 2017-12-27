package org.dddml.wms.domain.organization;

import java.io.Serializable;
import org.dddml.wms.domain.*;

public class OrganizationStateEventId implements Serializable
{
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

    public OrganizationStateEventId()
    {
    }

    public OrganizationStateEventId(String partyId, Long version)
    {
        this.partyId = partyId;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrganizationStateEventId other = (OrganizationStateEventId)obj;
        return true 
            && (partyId == other.partyId || (partyId != null && partyId.equals(other.partyId)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.partyId != null) {
            hash += 13 * this.partyId.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }

}

