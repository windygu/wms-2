package org.dddml.wms.domain.uom;

import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.Event;

import java.util.List;

public interface UomAggregate {
    UomState getState();

    List<Event> getChanges();

    void create(UomCommand.CreateUom c);

    void mergePatch(UomCommand.MergePatchUom c);

    void delete(UomCommand.DeleteUom c);

    void throwOnInvalidStateTransition(Command c);
}

