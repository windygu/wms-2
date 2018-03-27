package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistItemStateEventDao
{
    void save(PicklistItemStateEvent e);

    Iterable<PicklistItemStateEvent> findByPicklistBinEventId(PicklistBinEventId picklistBinEventId);

}

