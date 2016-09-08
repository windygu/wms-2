package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUserPermissionCommandDto extends AbstractCommand
{
    private String permissionId;

    public String getPermissionId()
    {
        return this.permissionId;
    }

    public void setPermissionId(String permissionId)
    {
        this.permissionId = permissionId;
    }


    public void copyTo(AbstractUserPermissionCommand command)
    {
        command.setPermissionId(this.getPermissionId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}

