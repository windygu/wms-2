package org.dddml.wms.domain.inventorypostingrule;

import java.util.Set;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleEvent.*;

public interface InventoryPostingRuleState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getInventoryPostingRuleId();

    InventoryItemId getTriggerInventoryItemId();

    InventoryItemId getOutputInventoryItemId();

    String getTriggerAccountName();

    String getOutputAccountName();

    Boolean getIsOutputNegated();

    Long getVersion();

    String getCreatedBy();

    Date getCreatedAt();

    String getUpdatedBy();

    Date getUpdatedAt();

    Boolean getActive();

    Boolean getDeleted();

    interface MutableInventoryPostingRuleState extends InventoryPostingRuleState {
        void setInventoryPostingRuleId(String inventoryPostingRuleId);

        void setTriggerInventoryItemId(InventoryItemId triggerInventoryItemId);

        void setOutputInventoryItemId(InventoryItemId outputInventoryItemId);

        void setTriggerAccountName(String triggerAccountName);

        void setOutputAccountName(String outputAccountName);

        void setIsOutputNegated(Boolean isOutputNegated);

        void setVersion(Long version);

        void setCreatedBy(String createdBy);

        void setCreatedAt(Date createdAt);

        void setUpdatedBy(String updatedBy);

        void setUpdatedAt(Date updatedAt);

        void setActive(Boolean active);

        void setDeleted(Boolean deleted);


        void mutate(Event e);

        void when(InventoryPostingRuleEvent.InventoryPostingRuleStateCreated e);

        void when(InventoryPostingRuleEvent.InventoryPostingRuleStateMergePatched e);

        void when(InventoryPostingRuleEvent.InventoryPostingRuleStateDeleted e);
    }

    interface SqlInventoryPostingRuleState extends MutableInventoryPostingRuleState {

        boolean isStateUnsaved();

        boolean getForReapplying();
    }
}

