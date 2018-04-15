package org.dddml.wms.domain.inout;

import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutLineEventDao
{
    void save(InOutLineEvent e);

    Iterable<InOutLineEvent> findByInOutEventId(InOutEventId inOutEventId);

}

