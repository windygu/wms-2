package org.dddml.wms.domain.locatortype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface LocatorTypeStateRepository
{
    LocatorTypeState get(String id, boolean nullAllowed);

    void save(LocatorTypeState state);

}

