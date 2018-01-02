package org.dddml.wms.domain.damagereason;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface DamageReasonApplicationService
{
    void when(DamageReasonCommand.CreateDamageReason c);

    void when(DamageReasonCommand.MergePatchDamageReason c);

    void when(DamageReasonCommand.DeleteDamageReason c);

    DamageReasonState get(String id);

    Iterable<DamageReasonState> getAll(Integer firstResult, Integer maxResults);

    Iterable<DamageReasonState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DamageReasonState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DamageReasonState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    DamageReasonStateEvent getStateEvent(String damageReasonId, long version);

    DamageReasonState getHistoryState(String damageReasonId, long version);

}

