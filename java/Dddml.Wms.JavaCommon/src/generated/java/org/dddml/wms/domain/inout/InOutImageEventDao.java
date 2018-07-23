package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutImageEventDao
{
    void save(InOutImageEvent e);

    Iterable<InOutImageEvent> findByInOutEventId(InOutEventId inOutEventId);

}

