package org.dddml.wms.domain.inventoryprtriggered;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryPRTriggeredAggregate
{
    InventoryPRTriggeredState getState();

    List<Event> getChanges();

    void create(InventoryPRTriggeredCommand.CreateInventoryPRTriggered c);

    void mergePatch(InventoryPRTriggeredCommand.MergePatchInventoryPRTriggered c);

    void throwOnInvalidStateTransition(Command c);
}

