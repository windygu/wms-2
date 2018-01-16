package org.dddml.wms.domain.locator;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface LocatorStateRepository
{
    LocatorState get(String id, boolean nullAllowed);

    void save(LocatorState state);

}

