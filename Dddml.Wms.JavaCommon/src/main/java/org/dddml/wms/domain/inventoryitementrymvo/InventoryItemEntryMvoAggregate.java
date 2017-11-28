package org.dddml.wms.domain.inventoryitementrymvo;

import java.util.List;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemEntryMvoAggregate
{
    InventoryItemEntryMvoState getState();

    List<Event> getChanges();

    void create(InventoryItemEntryMvoCommand.CreateInventoryItemEntryMvo c);

    void mergePatch(InventoryItemEntryMvoCommand.MergePatchInventoryItemEntryMvo c);

    void throwOnInvalidStateTransition(Command c);
}

