package org.dddml.wms.domain.contactmech;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface ContactMechAggregate
{
    ContactMechState getState();

    List<Event> getChanges();

    void create(ContactMechCommand.CreateContactMech c);

    void mergePatch(ContactMechCommand.MergePatchContactMech c);

    void delete(ContactMechCommand.DeleteContactMech c);

    void throwOnInvalidStateTransition(Command c);
}

