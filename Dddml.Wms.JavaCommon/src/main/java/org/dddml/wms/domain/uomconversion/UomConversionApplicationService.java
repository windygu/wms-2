package org.dddml.wms.domain.uomconversion;

import java.util.Map;
import java.util.List;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.Command;

public interface UomConversionApplicationService
{
    void when(UomConversionCommand.CreateUomConversion c);

    void when(UomConversionCommand.MergePatchUomConversion c);

    void when(UomConversionCommand.DeleteUomConversion c);

    UomConversionState get(UomConversionId id);

    Iterable<UomConversionState> getAll(Integer firstResult, Integer maxResults);

    Iterable<UomConversionState> get(Iterable<Map.Entry<String, Object>> filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomConversionState> get(Criterion filter, List<String> orders, Integer firstResult, Integer maxResults);

    Iterable<UomConversionState> getByProperty(String propertyName, Object propertyValue, List<String> orders, Integer firstResult, Integer maxResults);

    long getCount(Iterable<Map.Entry<String, Object>> filter);

    long getCount(Criterion filter);

    UomConversionStateEvent getStateEvent(UomConversionId uomConversionId, long version);

    UomConversionState getHistoryState(UomConversionId uomConversionId, long version);

}

