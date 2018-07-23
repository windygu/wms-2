package org.dddml.wms.domain.order;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.AbstractCommand;

public abstract class AbstractOrderRoleCommandDto extends AbstractCommand
{
    /**
     * Party Role Id
     */
    private PartyRoleId partyRoleId;

    public PartyRoleId getPartyRoleId()
    {
        return this.partyRoleId;
    }

    public void setPartyRoleId(PartyRoleId partyRoleId)
    {
        this.partyRoleId = partyRoleId;
    }


}
