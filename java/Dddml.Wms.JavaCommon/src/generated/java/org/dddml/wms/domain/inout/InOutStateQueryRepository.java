package org.dddml.wms.domain.inout;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutStateQueryRepository
{
    InOutState get(String id);

    Iterable<InOutState> getAll(Integer firstResult, Integer maxResults);
    
    Iterable<InOutState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<InOutState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    InOutState getFirst(Iterable<Map.Entry<String, Object>> filter, List<String> orders);

    InOutState getFirst(Map.Entry<String, Object> keyValue, List<String> orders);

    Iterable<InOutState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    InOutImageState getInOutImage(String inOutDocumentNumber, String sequenceId);

    Iterable<InOutImageState> getInOutImages(String inOutDocumentNumber, Criterion filter, List<String> orders);

    InOutLineState getInOutLine(String inOutDocumentNumber, String lineNumber);

    Iterable<InOutLineState> getInOutLines(String inOutDocumentNumber, Criterion filter, List<String> orders);

    InOutLineImageState getInOutLineImage(String inOutDocumentNumber, String inOutLineLineNumber, String sequenceId);

    Iterable<InOutLineImageState> getInOutLineImages(String inOutDocumentNumber, String inOutLineLineNumber, Criterion filter, List<String> orders);

}

