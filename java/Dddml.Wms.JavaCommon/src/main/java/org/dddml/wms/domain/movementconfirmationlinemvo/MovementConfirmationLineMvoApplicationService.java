package org.dddml.wms.domain.movementconfirmationlinemvo;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.movementconfirmation.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface MovementConfirmationLineMvoApplicationService
{
    void when(MovementConfirmationLineMvoCommand.CreateMovementConfirmationLineMvo c);

    void when(MovementConfirmationLineMvoCommand.MergePatchMovementConfirmationLineMvo c);

    void when(MovementConfirmationLineMvoCommand.DeleteMovementConfirmationLineMvo c);

    MovementConfirmationLineMvoState get(MovementConfirmationLineId id);

    Iterable<MovementConfirmationLineMvoState> getAll(Integer firstResult, Integer maxResults);

    Iterable<MovementConfirmationLineMvoState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementConfirmationLineMvoState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<MovementConfirmationLineMvoState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    MovementConfirmationLineMvoStateEvent getStateEvent(MovementConfirmationLineId movementConfirmationLineId, long version);

    MovementConfirmationLineMvoState getHistoryState(MovementConfirmationLineId movementConfirmationLineId, long version);

}

