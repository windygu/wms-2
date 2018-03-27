package org.dddml.wms.domain.picklist;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPicklistRoleCommandDto extends AbstractCommand
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


    public void copyTo(AbstractPicklistRoleCommand command)
    {
        command.setPartyRoleId(this.getPartyRoleId());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
