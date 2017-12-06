package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;

public interface InventoryPostingRuleCommand extends Command
{
    String getInventoryPostingRuleId();

    void setInventoryPostingRuleId(String inventoryPostingRuleId);

    Long getVersion();

    void setVersion(Long version);


    interface CreateOrMergePatchInventoryPostingRule extends InventoryPostingRuleCommand
    {
        InventoryItemId getTriggerInventoryItemId();

        void setTriggerInventoryItemId(InventoryItemId triggerInventoryItemId);

        InventoryItemId getOutputInventoryItemId();

        void setOutputInventoryItemId(InventoryItemId outputInventoryItemId);

        String getTriggerAccountName();

        void setTriggerAccountName(String triggerAccountName);

        String getOutputAccountName();

        void setOutputAccountName(String outputAccountName);

        Boolean getIsOutputNegated();

        void setIsOutputNegated(Boolean isOutputNegated);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateInventoryPostingRule extends CreateOrMergePatchInventoryPostingRule
    {
    }

    interface MergePatchInventoryPostingRule extends CreateOrMergePatchInventoryPostingRule
    {
        Boolean getIsPropertyTriggerInventoryItemIdRemoved();

        void setIsPropertyTriggerInventoryItemIdRemoved(Boolean removed);

        Boolean getIsPropertyOutputInventoryItemIdRemoved();

        void setIsPropertyOutputInventoryItemIdRemoved(Boolean removed);

        Boolean getIsPropertyTriggerAccountNameRemoved();

        void setIsPropertyTriggerAccountNameRemoved(Boolean removed);

        Boolean getIsPropertyOutputAccountNameRemoved();

        void setIsPropertyOutputAccountNameRemoved(Boolean removed);

        Boolean getIsPropertyIsOutputNegatedRemoved();

        void setIsPropertyIsOutputNegatedRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteInventoryPostingRule extends InventoryPostingRuleCommand
	{
	}

}

