package org.dddml.wms.domain.physicalinventory;

import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PhysicalInventoryAggregate
{
    PhysicalInventoryState getState();

    List<Event> getChanges();

    void create(PhysicalInventoryCommand.CreatePhysicalInventory c);

    void mergePatch(PhysicalInventoryCommand.MergePatchPhysicalInventory c);

    void countItem(String locatorId, String productId, java.util.Map<String, Object> attributeSetInstance, BigDecimal countedQuantity, Long version, String commandId, String requesterId);

    void documentAction(String value, Long version, String commandId, String requesterId);

    void throwOnInvalidStateTransition(Command c);
}

