package org.dddml.wms.domain.sellableinventoryitementrymvo;

import java.util.List;
import org.dddml.wms.domain.sellableinventoryitem.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface SellableInventoryItemEntryMvoAggregate
{
    SellableInventoryItemEntryMvoState getState();

    List<Event> getChanges();

    void create(SellableInventoryItemEntryMvoCommand.CreateSellableInventoryItemEntryMvo c);

    void mergePatch(SellableInventoryItemEntryMvoCommand.MergePatchSellableInventoryItemEntryMvo c);

    void throwOnInvalidStateTransition(Command c);
}

