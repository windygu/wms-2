package org.dddml.wms.domain.damagetype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface DamageTypeStateRepository
{
    DamageTypeState get(String id, boolean nullAllowed);

    void save(DamageTypeState state);

}

