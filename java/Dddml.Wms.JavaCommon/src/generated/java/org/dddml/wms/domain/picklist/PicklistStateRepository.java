package org.dddml.wms.domain.picklist;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.partyrole.*;
import org.dddml.wms.domain.*;

public interface PicklistStateRepository
{
    PicklistState get(String id, boolean nullAllowed);

    void save(PicklistState state);

}

