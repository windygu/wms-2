package org.dddml.wms.domain.facility;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface FacilityStateRepository
{
    FacilityState get(String id, boolean nullAllowed);

    void save(FacilityState state);

}

