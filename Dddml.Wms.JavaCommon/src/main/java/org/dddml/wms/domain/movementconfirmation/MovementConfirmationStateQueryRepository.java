package org.dddml.wms.domain.movementconfirmation;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationStateQueryRepository
{
    MovementConfirmationState get(String id);

    Iterable<MovementConfirmationState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<MovementConfirmationState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementConfirmationState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    MovementConfirmationState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    MovementConfirmationState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<MovementConfirmationState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    MovementConfirmationLineState getMovementConfirmationLine(String movementConfirmationDocumentNumber, String lineNumber);

}

