package org.dddml.wms.domain.party;

import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractPartyCommandDto extends AbstractCommand
{
    /**
     * Party Id
     */
    private String partyId;

    public String getPartyId()
    {
        return this.partyId;
    }

    public void setPartyId(String partyId)
    {
        this.partyId = partyId;
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


    public void copyTo(AbstractPartyCommand command)
    {
        command.setPartyId(this.getPartyId());
        command.setVersion(this.getVersion());
        
        command.setRequesterId(this.getRequesterId());
        command.setCommandId(this.getCommandId());
    }

}
