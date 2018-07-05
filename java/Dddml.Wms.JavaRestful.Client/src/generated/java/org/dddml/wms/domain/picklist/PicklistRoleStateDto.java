package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;


public class PicklistRoleStateDto
{

    private PartyRoleId partyRoleId;

    public PartyRoleId getPartyRoleId()
    {
        return this.partyRoleId;
    }

    public void setPartyRoleId(PartyRoleId partyRoleId)
    {
        this.partyRoleId = partyRoleId;
    }

    private Boolean active;

    public Boolean getActive()
    {
        return this.active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
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

    private String picklistId;

    public String getPicklistId()
    {
        return this.picklistId;
    }

    public void setPicklistId(String picklistId)
    {
        this.picklistId = picklistId;
    }

    private String createdByUserLogin;

    public String getCreatedByUserLogin()
    {
        return this.createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin)
    {
        this.createdByUserLogin = createdByUserLogin;
    }

    private Date createdAt;

    public Date getCreatedAt()
    {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    private String lastModifiedByUserLogin;

    public String getLastModifiedByUserLogin()
    {
        return this.lastModifiedByUserLogin;
    }

    public void setLastModifiedByUserLogin(String lastModifiedByUserLogin)
    {
        this.lastModifiedByUserLogin = lastModifiedByUserLogin;
    }

    private Date updatedAt;

    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}

