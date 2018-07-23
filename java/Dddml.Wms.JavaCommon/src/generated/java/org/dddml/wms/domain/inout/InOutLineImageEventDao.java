package org.dddml.wms.domain.inout;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface InOutLineImageEventDao
{
    void save(InOutLineImageEvent e);

    Iterable<InOutLineImageEvent> findByInOutLineEventId(InOutLineEventId inOutLineEventId);

}

