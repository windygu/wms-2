package org.dddml.wms.domain.picklistitemmvo;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import org.dddml.wms.domain.picklistbin.*;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface PicklistItemMvoStateRepository
{
    PicklistItemMvoState get(PicklistBinPicklistItemId id, boolean nullAllowed);

    void save(PicklistItemMvoState state);

}

