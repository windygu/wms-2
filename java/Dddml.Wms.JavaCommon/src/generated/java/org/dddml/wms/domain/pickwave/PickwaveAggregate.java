package org.dddml.wms.domain.pickwave;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PickwaveAggregate
{
    PickwaveState getState();

    List<Event> getChanges();

    void create(PickwaveCommand.CreatePickwave c);

    void mergePatch(PickwaveCommand.MergePatchPickwave c);

    void delete(PickwaveCommand.DeletePickwave c);

    void throwOnInvalidStateTransition(Command c);
}

