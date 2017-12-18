package org.dddml.wms.domain.inventoryitemrequirement;

import java.util.List;
import org.dddml.wms.domain.inventoryitem.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryprtriggered.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemRequirementAggregate
{
    InventoryItemRequirementState getState();

    List<Event> getChanges();

    void create(InventoryItemRequirementCommand.CreateInventoryItemRequirement c);

    void mergePatch(InventoryItemRequirementCommand.MergePatchInventoryItemRequirement c);

    void throwOnInvalidStateTransition(Command c);
}

