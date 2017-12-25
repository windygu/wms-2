package org.dddml.wms.domain.inout;

import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InOutAggregate
{
    InOutState getState();

    List<Event> getChanges();

    void create(InOutCommand.CreateInOut c);

    void mergePatch(InOutCommand.MergePatchInOut c);

    void delete(InOutCommand.DeleteInOut c);

    void throwOnInvalidStateTransition(Command c);
}

