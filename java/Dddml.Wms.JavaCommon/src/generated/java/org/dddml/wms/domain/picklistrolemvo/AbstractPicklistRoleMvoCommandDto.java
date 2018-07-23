package org.dddml.wms.domain.picklistrolemvo;

import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistRoleMvoCommandDto extends AbstractCommand
{
    /**
     * Picklist Role Id
     */
    private PicklistRoleId picklistRoleId;

    public PicklistRoleId getPicklistRoleId()
    {
        return this.picklistRoleId;
    }

    public void setPicklistRoleId(PicklistRoleId picklistRoleId)
    {
        this.picklistRoleId = picklistRoleId;
    }

    /**
     * Picklist Version
     */
    private Long picklistVersion;

    public Long getPicklistVersion()
    {
        return this.picklistVersion;
    }

    public void setPicklistVersion(Long picklistVersion)
    {
        this.picklistVersion = picklistVersion;
    }


    public void copyTo(AbstractPicklistRoleMvoCommand command)
    {
        command.setPicklistRoleId(this.getPicklistRoleId());
        command.setPicklistVersion(this.getPicklistVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
