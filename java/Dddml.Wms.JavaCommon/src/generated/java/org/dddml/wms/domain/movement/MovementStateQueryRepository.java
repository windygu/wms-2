package org.dddml.wms.domain.movement;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import java.math.BigDecimal;
import org.dddml.wms.domain.*;

public interface MovementStateQueryRepository
{
    MovementState get(String id);

    Iterable<MovementState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<MovementState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    MovementState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    MovementState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<MovementState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    MovementLineState getMovementLine(String movementDocumentNumber, String lineNumber);

    Iterable<MovementLineState> getMovementLines(String movementDocumentNumber, Criterion filter, List<String> orders);

}

