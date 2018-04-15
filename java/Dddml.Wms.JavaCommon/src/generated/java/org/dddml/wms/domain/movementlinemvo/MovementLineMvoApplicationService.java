package org.dddml.wms.domain.movementlinemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementLineMvoApplicationService
{
    void when(MovementLineMvoCommand.CreateMovementLineMvo c);

    void when(MovementLineMvoCommand.MergePatchMovementLineMvo c);

    void when(MovementLineMvoCommand.DeleteMovementLineMvo c);

    MovementLineMvoState get(MovementLineId id);

    Iterable<MovementLineMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<MovementLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    MovementLineMvoEvent getEvent(MovementLineId movementLineId, long version);

    MovementLineMvoState getHistoryState(MovementLineId movementLineId, long version);

}

