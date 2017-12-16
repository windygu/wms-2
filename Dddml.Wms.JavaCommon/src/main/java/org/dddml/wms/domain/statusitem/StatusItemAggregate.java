package org.dddml.wms.domain.statusitem;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface StatusItemAggregate
{
    StatusItemState getState();

    List<Event> getChanges();

    void create(StatusItemCommand.CreateStatusItem c);

    void mergePatch(StatusItemCommand.MergePatchStatusItem c);

    void throwOnInvalidStateTransition(Command c);
}

