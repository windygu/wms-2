package org.dddml.wms.domain.lot;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface LotStateRepository
{
    LotState get(String id, boolean nullAllowed);

    void save(LotState state);

}

