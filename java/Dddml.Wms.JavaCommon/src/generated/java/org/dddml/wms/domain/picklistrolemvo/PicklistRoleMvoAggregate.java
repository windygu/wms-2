package org.dddml.wms.domain.picklistrolemvo;

import java.util.List;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistRoleMvoAggregate
{
    PicklistRoleMvoState getState();

    List<Event> getChanges();

    void create(PicklistRoleMvoCommand.CreatePicklistRoleMvo c);

    void mergePatch(PicklistRoleMvoCommand.MergePatchPicklistRoleMvo c);

    void delete(PicklistRoleMvoCommand.DeletePicklistRoleMvo c);

    void throwOnInvalidStateTransition(Command c);
}

