package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUserPermissionMvoCommandDto extends AbstractCommand
{
    private UserPermissionIdDto userPermissionId;

    public UserPermissionIdDto getUserPermissionId()
    {
        return this.userPermissionId;
    }

    public void setUserPermissionId(UserPermissionIdDto userPermissionId)
    {
        this.userPermissionId = userPermissionId;
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


    public void copyTo(AbstractUserPermissionMvoCommand command)
    {
        command.setUserPermissionId((this.getUserPermissionId() == null) ? null : this.getUserPermissionId().toUserPermissionId());
        command.setUserVersion(this.getUserVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
