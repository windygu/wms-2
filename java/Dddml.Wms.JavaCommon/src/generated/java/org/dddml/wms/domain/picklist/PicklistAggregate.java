package org.dddml.wms.domain.picklist;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistAggregate
{
    PicklistState getState();

    List<Event> getChanges();

    void create(PicklistCommand.CreatePicklist c);

    void mergePatch(PicklistCommand.MergePatchPicklist c);

    void delete(PicklistCommand.DeletePicklist c);

    void throwOnInvalidStateTransition(Command c);
}

