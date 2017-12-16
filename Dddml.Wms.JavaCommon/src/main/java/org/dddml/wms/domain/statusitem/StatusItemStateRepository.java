package org.dddml.wms.domain.statusitem;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface StatusItemStateRepository
{
    StatusItemState get(String id, boolean nullAllowed);

    void save(StatusItemState state);

}

