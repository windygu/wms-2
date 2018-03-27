package org.dddml.wms.domain.picklistbin;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistBinAggregate
{
    PicklistBinState getState();

    List<Event> getChanges();

    void create(PicklistBinCommand.CreatePicklistBin c);

    void mergePatch(PicklistBinCommand.MergePatchPicklistBin c);

    void delete(PicklistBinCommand.DeletePicklistBin c);

    void throwOnInvalidStateTransition(Command c);
}

