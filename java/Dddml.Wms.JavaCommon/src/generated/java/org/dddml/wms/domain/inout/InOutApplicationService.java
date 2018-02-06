package org.dddml.wms.domain.inout;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface InOutApplicationService
{
    void when(InOutCommand.CreateInOut c);

    void when(InOutCommand.MergePatchInOut c);

    void when(InOutCommands.Complete c);

    void when(InOutCommands.Close c);

    void when(InOutCommands.Void c);

    void when(InOutCommands.Reverse c);

    void when(InOutCommands.AddLine c);

    void when(InOutCommands.DocumentAction c);

    InOutState get(String id);

    Iterable<InOutState> getAll(Integer firstResult, Integer maxResults);

    Iterable<InOutState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InOutState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InOutState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InOutStateEvent getStateEvent(String documentNumber, long version);

    InOutState getHistoryState(String documentNumber, long version);

    InOutLineState getInOutLine(String inOutDocumentNumber, String lineNumber);

}

