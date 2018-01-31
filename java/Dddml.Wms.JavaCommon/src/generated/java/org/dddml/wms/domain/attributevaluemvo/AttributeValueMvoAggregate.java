package org.dddml.wms.domain.attributevaluemvo;

import java.util.List;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeValueMvoAggregate
{
    AttributeValueMvoState getState();

    List<Event> getChanges();

    void create(AttributeValueMvoCommand.CreateAttributeValueMvo c);

    void mergePatch(AttributeValueMvoCommand.MergePatchAttributeValueMvo c);

    void delete(AttributeValueMvoCommand.DeleteAttributeValueMvo c);

    void throwOnInvalidStateTransition(Command c);
}

