package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryPostingRuleEvent extends Event {

    interface SqlInventoryPostingRuleEvent extends InventoryPostingRuleEvent {
        InventoryPostingRuleEventId getInventoryPostingRuleEventId();
    }

    String getInventoryPostingRuleId();

    //void setInventoryPostingRuleId(String inventoryPostingRuleId);

    Long getVersion();
    
    //void getVersion(Long version);

    boolean getEventReadOnly();

    void setEventReadOnly(boolean readOnly);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);

    interface InventoryPostingRuleStateEvent extends InventoryPostingRuleEvent {
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

    interface InventoryPostingRuleStateCreated extends InventoryPostingRuleStateEvent
    {
    
    }


    interface InventoryPostingRuleStateMergePatched extends InventoryPostingRuleStateEvent
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

    interface InventoryPostingRuleStateDeleted extends InventoryPostingRuleStateEvent
    {
    }


}

