package org.dddml.wms.domain;

import java.util.Date;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractUserRoleMvoCommandDto extends AbstractCommand
{
    private UserRoleIdDto userRoleId;

    public UserRoleIdDto getUserRoleId()
    {
        return this.userRoleId;
    }

    public void setUserRoleId(UserRoleIdDto userRoleId)
    {
        this.userRoleId = userRoleId;
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


    public void copyTo(AbstractUserRoleMvoCommand command)
    {
        command.setUserRoleId((this.getUserRoleId() == null) ? null : this.getUserRoleId().toUserRoleId());
        command.setUserVersion(this.getUserVersion());
    }

}

