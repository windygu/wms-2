package org.dddml.wms.domain.picklistbin;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PicklistItemCommand extends Command
{
    PicklistItemOrderShipGrpInvId getPicklistItemOrderShipGrpInvId();

    void setPicklistItemOrderShipGrpInvId(PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    String getPicklistBinId();

    void setPicklistBinId(String picklistBinId);

    interface CreateOrMergePatchPicklistItem extends PicklistItemCommand
    {
        String getItemStatusId();

        void setItemStatusId(String itemStatusId);

        java.math.BigDecimal getQuantity();

        void setQuantity(java.math.BigDecimal quantity);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreatePicklistItem extends CreateOrMergePatchPicklistItem
    {
    }

    interface MergePatchPicklistItem extends CreateOrMergePatchPicklistItem
    {
        Boolean getIsPropertyItemStatusIdRemoved();

        void setIsPropertyItemStatusIdRemoved(Boolean removed);

        Boolean getIsPropertyQuantityRemoved();

        void setIsPropertyQuantityRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface RemovePicklistItem extends PicklistItemCommand
	{
	}

}

