package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PicklistRoleCommand extends Command
{
    PartyRoleId getPartyRoleId();

    void setPartyRoleId(PartyRoleId partyRoleId);

    String getPicklistId();

    void setPicklistId(String picklistId);

    interface CreateOrMergePatchPicklistRole extends PicklistRoleCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreatePicklistRole extends CreateOrMergePatchPicklistRole
    {
    }

    interface MergePatchPicklistRole extends CreateOrMergePatchPicklistRole
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemovePicklistRole extends PicklistRoleCommand
	{
	}

}

