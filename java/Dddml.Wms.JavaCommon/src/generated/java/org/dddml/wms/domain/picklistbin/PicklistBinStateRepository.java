package org.dddml.wms.domain.picklistbin;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistBinStateRepository
{
    PicklistBinState get(String id, boolean nullAllowed);

    void save(PicklistBinState state);

}

