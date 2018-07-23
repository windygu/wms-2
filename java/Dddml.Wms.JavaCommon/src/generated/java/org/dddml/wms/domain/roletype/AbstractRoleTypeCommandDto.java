package org.dddml.wms.domain.roletype;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractRoleTypeCommandDto extends AbstractCommand
{
    /**
     * Role Type Id
     */
    private String roleTypeId;

    public String getRoleTypeId()
    {
        return this.roleTypeId;
    }

    public void setRoleTypeId(String roleTypeId)
    {
        this.roleTypeId = roleTypeId;
    }

    /**
     * Version
     */
    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public void copyTo(AbstractRoleTypeCommand command)
    {
        command.setRoleTypeId(this.getRoleTypeId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
