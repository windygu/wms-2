package org.dddml.wms.domain.roletype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface RoleTypeAggregate
{
    RoleTypeState getState();

    List<Event> getChanges();

    void create(RoleTypeCommand.CreateRoleType c);

    void mergePatch(RoleTypeCommand.MergePatchRoleType c);

    void delete(RoleTypeCommand.DeleteRoleType c);

    void throwOnInvalidStateTransition(Command c);
}

