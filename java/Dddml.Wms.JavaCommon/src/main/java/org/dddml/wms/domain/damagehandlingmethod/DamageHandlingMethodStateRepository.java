package org.dddml.wms.domain.damagehandlingmethod;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface DamageHandlingMethodStateRepository
{
    DamageHandlingMethodState get(String id, boolean nullAllowed);

    void save(DamageHandlingMethodState state);

}

