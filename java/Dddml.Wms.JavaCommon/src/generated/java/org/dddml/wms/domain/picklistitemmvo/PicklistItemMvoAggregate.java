package org.dddml.wms.domain.picklistitemmvo;

import java.util.List;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistItemMvoAggregate
{
    PicklistItemMvoState getState();

    List<Event> getChanges();

    void create(PicklistItemMvoCommand.CreatePicklistItemMvo c);

    void mergePatch(PicklistItemMvoCommand.MergePatchPicklistItemMvo c);

    void delete(PicklistItemMvoCommand.DeletePicklistItemMvo c);

    void throwOnInvalidStateTransition(Command c);
}

