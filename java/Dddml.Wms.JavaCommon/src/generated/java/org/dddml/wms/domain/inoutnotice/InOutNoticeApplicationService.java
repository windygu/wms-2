package org.dddml.wms.domain.inoutnotice;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InOutNoticeApplicationService
{
    void when(InOutNoticeCommand.CreateInOutNotice c);

    void when(InOutNoticeCommand.MergePatchInOutNotice c);

    void when(InOutNoticeCommand.DeleteInOutNotice c);

    void when(InOutNoticeCommands.InOutNoticeAction c);

    InOutNoticeState get(String id);

    Iterable<InOutNoticeState> getAll(Integer firstResult, Integer maxResults);

    Iterable<InOutNoticeState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InOutNoticeState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InOutNoticeState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InOutNoticeEvent getEvent(String inOutNoticeId, long version);

    InOutNoticeState getHistoryState(String inOutNoticeId, long version);

}

