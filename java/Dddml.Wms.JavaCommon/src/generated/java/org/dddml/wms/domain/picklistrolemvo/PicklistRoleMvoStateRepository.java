package org.dddml.wms.domain.picklistrolemvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklist.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistRoleMvoStateRepository
{
    PicklistRoleMvoState get(PicklistRoleId id, boolean nullAllowed);

    void save(PicklistRoleMvoState state);

}

