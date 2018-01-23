package org.dddml.wms.domain.uom;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface UomStateRepository
{
    UomState get(String id, boolean nullAllowed);

    void save(UomState state);

}

