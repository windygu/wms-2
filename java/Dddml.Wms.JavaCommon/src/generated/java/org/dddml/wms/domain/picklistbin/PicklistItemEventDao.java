package org.dddml.wms.domain.picklistbin;

import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistItemEventDao
{
    void save(PicklistItemEvent e);

    Iterable<PicklistItemEvent> findByPicklistBinEventId(PicklistBinEventId picklistBinEventId);

}

