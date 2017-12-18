package org.dddml.wms.domain.inventoryitemrequiremententrymvo;

import java.util.List;
import org.dddml.wms.domain.inventoryitemrequirement.*;
import java.math.BigDecimal;
import org.dddml.wms.domain.inventoryprtriggered.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InventoryItemRequirementEntryMvoAggregate
{
    InventoryItemRequirementEntryMvoState getState();

    List<Event> getChanges();

    void create(InventoryItemRequirementEntryMvoCommand.CreateInventoryItemRequirementEntryMvo c);

    void mergePatch(InventoryItemRequirementEntryMvoCommand.MergePatchInventoryItemRequirementEntryMvo c);

    void throwOnInvalidStateTransition(Command c);
}

