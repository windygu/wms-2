package org.dddml.wms.domain;

import org.dddml.wms.domain.*;

public class OrganizationStateEventIdDto
{

    public OrganizationStateEventIdDto()
    {
    }

    public OrganizationStateEventId toOrganizationStateEventId()
    {
        OrganizationStateEventId v = new OrganizationStateEventId();
        v.setOrganizationId(this.getOrganizationId());
        v.setVersion(this.getVersion());
        return v;
    }

    private String organizationId;

    public String getOrganizationId()
    {
        return this.organizationId;
    }

    public void setOrganizationId(String organizationId)
    {
        this.organizationId = organizationId;
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
            && (getOrganizationId() == other.getOrganizationId() || (getOrganizationId() != null && getOrganizationId().equals(other.getOrganizationId())))
            && (getVersion() == other.getVersion() || (getVersion() != null && getVersion().equals(other.getVersion())))
            ;

    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.getOrganizationId() != null) {
            hash += 13 * this.getOrganizationId().hashCode();
        }
        if (this.getVersion() != null) {
            hash += 13 * this.getVersion().hashCode();
        }
        return hash;
    }

}

