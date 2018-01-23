package org.dddml.wms.domain;

import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.locator.LocatorState;

import java.util.List;
import java.util.Map;

public interface LocatorTreeApplicationService {
    Iterable<LocatorState> getRoots(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LocatorState> getChildren(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getRootIds(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getChildIds(String parentId, Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LocatorState> getRoots(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<LocatorState> getChildren(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getRootIds(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<String> getChildIds(String parentId, Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

}


