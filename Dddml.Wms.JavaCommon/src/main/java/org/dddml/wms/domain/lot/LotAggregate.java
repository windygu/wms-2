package org.dddml.wms.domain.lot;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface LotAggregate
{
    LotState getState();

    List<Event> getChanges();

    void create(LotCommand.CreateLot c);

    void mergePatch(LotCommand.MergePatchLot c);

    void delete(LotCommand.DeleteLot c);

    void throwOnInvalidStateTransition(Command c);
}

