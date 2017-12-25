package org.dddml.wms.domain.physicalinventory;

import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PhysicalInventoryAggregate
{
    PhysicalInventoryState getState();

    List<Event> getChanges();

    void create(PhysicalInventoryCommand.CreatePhysicalInventory c);

    void mergePatch(PhysicalInventoryCommand.MergePatchPhysicalInventory c);

    void delete(PhysicalInventoryCommand.DeletePhysicalInventory c);

    void throwOnInvalidStateTransition(Command c);
}

