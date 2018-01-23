package org.dddml.wms.domain.damagetype;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface DamageTypeApplicationService
{
    void when(DamageTypeCommand.CreateDamageType c);

    void when(DamageTypeCommand.MergePatchDamageType c);

    void when(DamageTypeCommand.DeleteDamageType c);

    DamageTypeState get(String id);

    Iterable<DamageTypeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<DamageTypeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DamageTypeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<DamageTypeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

}

