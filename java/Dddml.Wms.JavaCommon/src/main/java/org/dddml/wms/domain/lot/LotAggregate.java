package org.dddml.wms.domain.lot;

import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.Event;

import java.util.List;

public interface LotAggregate {
    LotState getState();

    List<Event> getChanges();

    void create(LotCommand.CreateLot c);

    void mergePatch(LotCommand.MergePatchLot c);

    void delete(LotCommand.DeleteLot c);

    void throwOnInvalidStateTransition(Command c);
}

