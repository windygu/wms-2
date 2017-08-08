package org.dddml.wms.domain.organization;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.util.Date;
import org.dddml.wms.domain.*;

public interface OrganizationStateRepository
{
    OrganizationState get(String id, boolean nullAllowed);

    void save(OrganizationState state);

}

