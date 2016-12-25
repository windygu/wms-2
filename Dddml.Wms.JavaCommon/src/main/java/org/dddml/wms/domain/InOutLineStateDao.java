package org.dddml.wms.domain;

import java.math.BigDecimal;
import java.util.Date;

public interface InOutLineStateDao
{
    InOutLineState get(InOutLineId id);

    InOutLineState get(InOutLineId id, boolean nullAllowed);

    void save(InOutLineState state);

    Iterable<InOutLineState> findByInOutDocumentNumber(String inOutDocumentNumber);

    void delete(InOutLineState state);
}


