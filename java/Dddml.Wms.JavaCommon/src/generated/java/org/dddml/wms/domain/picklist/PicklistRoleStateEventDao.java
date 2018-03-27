package org.dddml.wms.domain.picklist;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistRoleStateEventDao
{
    void save(PicklistRoleStateEvent e);

    Iterable<PicklistRoleStateEvent> findByPicklistEventId(PicklistEventId picklistEventId);

}

