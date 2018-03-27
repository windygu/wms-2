package org.dddml.wms.domain.facility;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface FacilityApplicationService
{
    void when(FacilityCommand.CreateFacility c);

    void when(FacilityCommand.MergePatchFacility c);

    void when(FacilityCommand.DeleteFacility c);

    FacilityState get(String id);

    Iterable<FacilityState> getAll(Integer firstResult, Integer maxResults);

    Iterable<FacilityState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<FacilityState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<FacilityState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    FacilityStateEvent getStateEvent(String facilityId, long version);

    FacilityState getHistoryState(String facilityId, long version);

}

