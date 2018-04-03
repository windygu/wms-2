package org.dddml.wms.domain.movement;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementApplicationService
{
    void when(MovementCommand.CreateMovement c);

    void when(MovementCommand.MergePatchMovement c);

    void when(MovementCommand.DeleteMovement c);

    void when(MovementCommands.DocumentAction c);

    MovementState get(String id);

    Iterable<MovementState> getAll(Integer firstResult, Integer maxResults);

    Iterable<MovementState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    MovementStateEvent getStateEvent(String documentNumber, long version);

    MovementState getHistoryState(String documentNumber, long version);

    MovementLineState getMovementLine(String movementDocumentNumber, String lineNumber);

    Iterable<MovementLineState> getMovementLines(String movementDocumentNumber);

}

