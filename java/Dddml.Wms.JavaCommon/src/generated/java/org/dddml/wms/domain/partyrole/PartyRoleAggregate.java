package org.dddml.wms.domain.partyrole;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PartyRoleAggregate
{
    PartyRoleState getState();

    List<Event> getChanges();

    void create(PartyRoleCommand.CreatePartyRole c);

    void mergePatch(PartyRoleCommand.MergePatchPartyRole c);

    void delete(PartyRoleCommand.DeletePartyRole c);

    void throwOnInvalidStateTransition(Command c);
}

