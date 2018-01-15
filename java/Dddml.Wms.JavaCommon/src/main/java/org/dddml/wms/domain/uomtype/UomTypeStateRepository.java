package org.dddml.wms.domain.uomtype;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface UomTypeStateRepository
{
    UomTypeState get(String id, boolean nullAllowed);

    void save(UomTypeState state);

}

