package org.dddml.wms.domain.damagetype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface DamageTypeAggregate
{
    DamageTypeState getState();

    List<Event> getChanges();

    void create(DamageTypeCommand.CreateDamageType c);

    void mergePatch(DamageTypeCommand.MergePatchDamageType c);

    void delete(DamageTypeCommand.DeleteDamageType c);

    void throwOnInvalidStateTransition(Command c);
}

