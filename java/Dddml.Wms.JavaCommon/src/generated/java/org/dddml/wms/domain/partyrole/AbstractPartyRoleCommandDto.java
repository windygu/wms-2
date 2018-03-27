package org.dddml.wms.domain.partyrole;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPartyRoleCommandDto extends AbstractCommand
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

    private Long version;

    public Long getVersion()
    {
        return this.version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    public void copyTo(AbstractPartyRoleCommand command)
    {
        command.setPartyRoleId(this.getPartyRoleId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
