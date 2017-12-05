package org.dddml.wms.domain.inventorypostingrule;

import java.util.Set;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.inventorypostingrule.InventoryPostingRuleStateEvent.*;

public interface InventoryPostingRuleState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getInventoryPostingRuleId();

    void setInventoryPostingRuleId(String inventoryPostingRuleId);

    InventoryItemId getTrigger();

    void setTrigger(InventoryItemId trigger);

    InventoryItemId getOutput();

    void setOutput(InventoryItemId output);

    Boolean getIsOutputNegated();

    void setIsOutputNegated(Boolean isOutputNegated);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(InventoryPostingRuleStateEvent.InventoryPostingRuleStateCreated e);

    void when(InventoryPostingRuleStateEvent.InventoryPostingRuleStateMergePatched e);

    void when(InventoryPostingRuleStateEvent.InventoryPostingRuleStateDeleted e);
    
}

