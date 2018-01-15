package org.dddml.wms.domain.attributeusemvo;

import java.util.List;
import org.dddml.wms.domain.attributeset.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeUseMvoAggregate
{
    AttributeUseMvoState getState();

    List<Event> getChanges();

    void create(AttributeUseMvoCommand.CreateAttributeUseMvo c);

    void mergePatch(AttributeUseMvoCommand.MergePatchAttributeUseMvo c);

    void delete(AttributeUseMvoCommand.DeleteAttributeUseMvo c);

    void throwOnInvalidStateTransition(Command c);
}

