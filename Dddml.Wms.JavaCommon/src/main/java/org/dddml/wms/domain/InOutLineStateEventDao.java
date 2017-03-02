package org.dddml.wms.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutLineStateEventDao
{
    void save(InOutLineStateEvent e);

    Iterable<InOutLineStateEvent> findByInOutStateEventId(InOutStateEventId inOutStateEventId);

}

