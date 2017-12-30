package org.dddml.wms.domain.uom;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface UomAggregate
{
    UomState getState();

    List<Event> getChanges();

    void create(UomCommand.CreateUom c);

    void mergePatch(UomCommand.MergePatchUom c);

    void delete(UomCommand.DeleteUom c);

    void throwOnInvalidStateTransition(Command c);
}

