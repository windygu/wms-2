package org.dddml.wms.domain.roletype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface RoleTypeStateRepository
{
    RoleTypeState get(String id, boolean nullAllowed);

    void save(RoleTypeState state);

}

