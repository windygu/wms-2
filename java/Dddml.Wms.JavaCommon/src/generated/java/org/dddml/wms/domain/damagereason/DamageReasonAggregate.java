package org.dddml.wms.domain.damagereason;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface DamageReasonAggregate
{
    DamageReasonState getState();

    List<Event> getChanges();

    void create(DamageReasonCommand.CreateDamageReason c);

    void mergePatch(DamageReasonCommand.MergePatchDamageReason c);

    void delete(DamageReasonCommand.DeleteDamageReason c);

    void throwOnInvalidStateTransition(Command c);
}

