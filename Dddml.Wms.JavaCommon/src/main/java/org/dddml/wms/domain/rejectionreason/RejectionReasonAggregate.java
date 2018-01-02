package org.dddml.wms.domain.rejectionreason;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface RejectionReasonAggregate
{
    RejectionReasonState getState();

    List<Event> getChanges();

    void create(RejectionReasonCommand.CreateRejectionReason c);

    void mergePatch(RejectionReasonCommand.MergePatchRejectionReason c);

    void delete(RejectionReasonCommand.DeleteRejectionReason c);

    void throwOnInvalidStateTransition(Command c);
}

