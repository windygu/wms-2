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
        InventoryItemId getTrigger();

        void setTrigger(InventoryItemId trigger);

        InventoryItemId getOutput();

        void setOutput(InventoryItemId output);

        String getAccountName();

        void setAccountName(String accountName);

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
        Boolean getIsPropertyTriggerRemoved();

        void setIsPropertyTriggerRemoved(Boolean removed);

        Boolean getIsPropertyOutputRemoved();

        void setIsPropertyOutputRemoved(Boolean removed);

        Boolean getIsPropertyAccountNameRemoved();

        void setIsPropertyAccountNameRemoved(Boolean removed);

        Boolean getIsPropertyIsOutputNegatedRemoved();

        void setIsPropertyIsOutputNegatedRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteInventoryPostingRule extends InventoryPostingRuleCommand
	{
	}

}

