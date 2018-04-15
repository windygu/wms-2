package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryPostingRuleEvent extends Event
{
    InventoryPostingRuleEventId getInventoryPostingRuleEventId();

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

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

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    Boolean getActive();

    void setActive(Boolean active);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryPostingRuleStateCreated extends InventoryPostingRuleEvent
    {
    
    }


    interface InventoryPostingRuleStateMergePatched extends InventoryPostingRuleEvent
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

    interface InventoryPostingRuleStateDeleted extends InventoryPostingRuleEvent
    {
    }


}

