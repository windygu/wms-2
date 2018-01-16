package org.dddml.wms.domain.attributealiasmvo;

import java.util.List;
import org.dddml.wms.domain.attribute.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface AttributeAliasMvoAggregate
{
    AttributeAliasMvoState getState();

    List<Event> getChanges();

    void create(AttributeAliasMvoCommand.CreateAttributeAliasMvo c);

    void mergePatch(AttributeAliasMvoCommand.MergePatchAttributeAliasMvo c);

    void delete(AttributeAliasMvoCommand.DeleteAttributeAliasMvo c);

    void throwOnInvalidStateTransition(Command c);
}

