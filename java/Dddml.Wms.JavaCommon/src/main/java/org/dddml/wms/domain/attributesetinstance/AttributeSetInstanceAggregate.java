package org.dddml.wms.domain.attributesetinstance;

import java.util.List;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeSetInstanceAggregate
{
    AttributeSetInstanceState getState();

    List<Event> getChanges();

    void create(AttributeSetInstanceCommand.CreateAttributeSetInstance c);

    void throwOnInvalidStateTransition(Command c);
}

