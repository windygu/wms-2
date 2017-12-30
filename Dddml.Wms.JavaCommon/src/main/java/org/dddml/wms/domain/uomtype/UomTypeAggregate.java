package org.dddml.wms.domain.uomtype;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface UomTypeAggregate
{
    UomTypeState getState();

    List<Event> getChanges();

    void create(UomTypeCommand.CreateUomType c);

    void mergePatch(UomTypeCommand.MergePatchUomType c);

    void delete(UomTypeCommand.DeleteUomType c);

    void throwOnInvalidStateTransition(Command c);
}

