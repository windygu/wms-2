package org.dddml.wms.domain.party;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PartyAggregate
{
    PartyState getState();

    List<Event> getChanges();

    void create(PartyCommand.CreateParty c);

    void mergePatch(PartyCommand.MergePatchParty c);

    void delete(PartyCommand.DeleteParty c);

    void throwOnInvalidStateTransition(Command c);
}

