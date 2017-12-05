package org.dddml.wms.domain.inventorypostingrule;

import java.util.*;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;

public interface InventoryPostingRuleStateEvent extends Event
{
    InventoryPostingRuleStateEventId getStateEventId();

    boolean getStateEventReadOnly();

    void setStateEventReadOnly(boolean readOnly);

    InventoryItemId getTrigger();

    void setTrigger(InventoryItemId trigger);

    InventoryItemId getOutput();

    void setOutput(InventoryItemId output);

    String getAccountName();

    void setAccountName(String accountName);

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

    interface InventoryPostingRuleStateCreated extends InventoryPostingRuleStateEvent
    {
    
    }


    interface InventoryPostingRuleStateMergePatched extends InventoryPostingRuleStateEvent
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

    interface InventoryPostingRuleStateDeleted extends InventoryPostingRuleStateEvent
    {
    }


}

