package org.dddml.wms.domain.locatortype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface LocatorTypeAggregate
{
    LocatorTypeState getState();

    List<Event> getChanges();

    void create(LocatorTypeCommand.CreateLocatorType c);

    void mergePatch(LocatorTypeCommand.MergePatchLocatorType c);

    void delete(LocatorTypeCommand.DeleteLocatorType c);

    void throwOnInvalidStateTransition(Command c);
}

