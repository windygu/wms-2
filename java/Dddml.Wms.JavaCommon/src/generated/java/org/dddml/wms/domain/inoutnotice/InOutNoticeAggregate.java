package org.dddml.wms.domain.inoutnotice;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InOutNoticeAggregate
{
    InOutNoticeState getState();

    List<Event> getChanges();

    void create(InOutNoticeCommand.CreateInOutNotice c);

    void mergePatch(InOutNoticeCommand.MergePatchInOutNotice c);

    void delete(InOutNoticeCommand.DeleteInOutNotice c);

    void inOutNoticeAction(String value, Long version, String commandId, String requesterId, InOutNoticeCommands.InOutNoticeAction c);

    void throwOnInvalidStateTransition(Command c);
}

