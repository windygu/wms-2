package org.dddml.wms.domain.picklist;

import org.dddml.wms.domain.partyrole.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistRoleStateDao
{
    PicklistRoleState get(PicklistRoleId id, boolean nullAllowed);

    void save(PicklistRoleState state);

    Iterable<PicklistRoleState> findByPicklistId(String picklistId);

    void delete(PicklistRoleState state);
}


