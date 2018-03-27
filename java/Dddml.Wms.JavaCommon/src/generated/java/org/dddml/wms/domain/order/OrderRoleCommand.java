package org.dddml.wms.domain.order;

import java.util.*;
import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface OrderRoleCommand extends Command
{
    PartyRoleId getPartyRoleId();

    void setPartyRoleId(PartyRoleId partyRoleId);

    String getOrderId();

    void setOrderId(String orderId);

    interface CreateOrMergePatchOrderRole extends OrderRoleCommand
    {
        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateOrderRole extends CreateOrMergePatchOrderRole
    {
    }

    interface MergePatchOrderRole extends CreateOrMergePatchOrderRole
    {
        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemoveOrderRole extends OrderRoleCommand
	{
	}

}

