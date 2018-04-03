package org.dddml.wms.domain.picklistbin;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface PicklistBinApplicationService
{
    void when(PicklistBinCommand.CreatePicklistBin c);

    void when(PicklistBinCommand.MergePatchPicklistBin c);

    void when(PicklistBinCommand.DeletePicklistBin c);

    PicklistBinState get(String id);

    Iterable<PicklistBinState> getAll(Integer firstResult, Integer maxResults);

    Iterable<PicklistBinState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistBinState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<PicklistBinState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    PicklistBinStateEvent getStateEvent(String picklistBinId, long version);

    PicklistBinState getHistoryState(String picklistBinId, long version);

    PicklistItemState getPicklistItem(String picklistBinId, PicklistItemOrderShipGrpInvId picklistItemOrderShipGrpInvId);

    Iterable<PicklistItemState> getPicklistItems(String picklistBinId);

}

