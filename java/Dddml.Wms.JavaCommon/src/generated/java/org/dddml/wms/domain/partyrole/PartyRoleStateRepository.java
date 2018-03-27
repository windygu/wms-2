package org.dddml.wms.domain.partyrole;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PartyRoleStateRepository
{
    PartyRoleState get(PartyRoleId id, boolean nullAllowed);

    void save(PartyRoleState state);

}

