package org.dddml.wms.domain.movementtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementTypeApplicationService
{
    void when(MovementTypeCommand.CreateMovementType c);

    void when(MovementTypeCommand.MergePatchMovementType c);

    void when(MovementTypeCommand.DeleteMovementType c);

    MovementTypeState get(String id);

    Iterable<MovementTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<MovementTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

