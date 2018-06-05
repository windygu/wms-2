package org.dddml.wms.domain.goodidentificationtype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface GoodIdentificationTypeApplicationService
{
    void when(GoodIdentificationTypeCommand.CreateGoodIdentificationType c);

    void when(GoodIdentificationTypeCommand.MergePatchGoodIdentificationType c);

    void when(GoodIdentificationTypeCommand.DeleteGoodIdentificationType c);

    GoodIdentificationTypeState get(String id);

    Iterable<GoodIdentificationTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<GoodIdentificationTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<GoodIdentificationTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<GoodIdentificationTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    GoodIdentificationTypeEvent getEvent(String goodIdentificationTypeId, long version);

    GoodIdentificationTypeState getHistoryState(String goodIdentificationTypeId, long version);

}

