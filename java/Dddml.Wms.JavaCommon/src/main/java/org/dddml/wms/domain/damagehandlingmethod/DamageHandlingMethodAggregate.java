package org.dddml.wms.domain.damagehandlingmethod;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface DamageHandlingMethodAggregate
{
    DamageHandlingMethodState getState();

    List<Event> getChanges();

    void create(DamageHandlingMethodCommand.CreateDamageHandlingMethod c);

    void mergePatch(DamageHandlingMethodCommand.MergePatchDamageHandlingMethod c);

    void delete(DamageHandlingMethodCommand.DeleteDamageHandlingMethod c);

    void throwOnInvalidStateTransition(Command c);
}

