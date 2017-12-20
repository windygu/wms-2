package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.movement.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface MovementConfirmationLineMvoStateQueryRepository
{
    MovementConfirmationLineMvoState get(MovementConfirmationLineId id);

    Iterable<MovementConfirmationLineMvoState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<MovementConfirmationLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementConfirmationLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    MovementConfirmationLineMvoState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    MovementConfirmationLineMvoState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<MovementConfirmationLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

