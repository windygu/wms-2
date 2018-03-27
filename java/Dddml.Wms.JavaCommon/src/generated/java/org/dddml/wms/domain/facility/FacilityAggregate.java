package org.dddml.wms.domain.facility;

import java.util.List;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface FacilityAggregate
{
    FacilityState getState();

    List<Event> getChanges();

    void create(FacilityCommand.CreateFacility c);

    void mergePatch(FacilityCommand.MergePatchFacility c);

    void delete(FacilityCommand.DeleteFacility c);

    void throwOnInvalidStateTransition(Command c);
}

