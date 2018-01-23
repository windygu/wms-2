package org.dddml.wms.domain.damagetype;

import org.dddml.support.criterion.Criterion;

import java.util.List;
import java.util.Map;

public interface DamageTypeApplicationService {
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

