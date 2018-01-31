package org.dddml.wms.domain.physicalinventorylinemvo;

import java.util.List;
import org.dddml.wms.domain.physicalinventory.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PhysicalInventoryLineMvoAggregate
{
    PhysicalInventoryLineMvoState getState();

    List<Event> getChanges();

    void create(PhysicalInventoryLineMvoCommand.CreatePhysicalInventoryLineMvo c);

    void mergePatch(PhysicalInventoryLineMvoCommand.MergePatchPhysicalInventoryLineMvo c);

    void delete(PhysicalInventoryLineMvoCommand.DeletePhysicalInventoryLineMvo c);

    void throwOnInvalidStateTransition(Command c);
}

