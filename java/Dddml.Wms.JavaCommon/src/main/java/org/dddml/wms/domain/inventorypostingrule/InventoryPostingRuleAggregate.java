package org.dddml.wms.domain.inventorypostingrule;

import java.util.List;
import org.dddml.wms.domain.inventoryitem.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryPostingRuleAggregate
{
    InventoryPostingRuleState getState();

    List<Event> getChanges();

    void create(InventoryPostingRuleCommand.CreateInventoryPostingRule c);

    void mergePatch(InventoryPostingRuleCommand.MergePatchInventoryPostingRule c);

    void delete(InventoryPostingRuleCommand.DeleteInventoryPostingRule c);

    void throwOnInvalidStateTransition(Command c);
}

