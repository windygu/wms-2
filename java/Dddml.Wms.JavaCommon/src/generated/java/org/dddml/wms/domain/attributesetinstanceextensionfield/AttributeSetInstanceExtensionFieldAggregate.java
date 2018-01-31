package org.dddml.wms.domain.attributesetinstanceextensionfield;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeSetInstanceExtensionFieldAggregate
{
    AttributeSetInstanceExtensionFieldState getState();

    List<Event> getChanges();

    void create(AttributeSetInstanceExtensionFieldCommand.CreateAttributeSetInstanceExtensionField c);

    void mergePatch(AttributeSetInstanceExtensionFieldCommand.MergePatchAttributeSetInstanceExtensionField c);

    void delete(AttributeSetInstanceExtensionFieldCommand.DeleteAttributeSetInstanceExtensionField c);

    void throwOnInvalidStateTransition(Command c);
}

