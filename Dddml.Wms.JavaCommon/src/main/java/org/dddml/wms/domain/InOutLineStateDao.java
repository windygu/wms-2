package org.dddml.wms.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutLineStateDao
{
    InOutLineState get(InOutLineId id, boolean nullAllowed);

    void save(InOutLineState state);

    Iterable<InOutLineState> findByInOutDocumentNumber(String inOutDocumentNumber);

    void delete(InOutLineState state);
}


